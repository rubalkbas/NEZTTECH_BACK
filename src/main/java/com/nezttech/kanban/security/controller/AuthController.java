package com.nezttech.kanban.security.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nezttech.kanban.entity.NztUsuario;
import com.nezttech.kanban.model.ConfirmationToken;
import com.nezttech.kanban.model.Parametros;
import com.nezttech.kanban.model.Respuesta;
import com.nezttech.kanban.payload.response.JwtResponse;
import com.nezttech.kanban.repository.ConfirmationTokenRepository;
import com.nezttech.kanban.repository.UsuarioRepository;
import com.nezttech.kanban.security.jwt.JwtUtils;
import com.nezttech.kanban.security.service.DetalleUsuarioImpl;

/**
 * @author NezTTech
 * @version 1.0
 * @since   2021-12-01
*/
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/authentication")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Value("${sistemaglobal.app.pathMicroServ}")
	private String pathMicroServ;
	
	@PostMapping("/inicioSesion")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody Parametros parametros) {
		
		NztUsuario usuarios = new NztUsuario();
		Respuesta response = new Respuesta();
		
		usuarios = usuarioRepository.usuarioHabilitado(parametros.getCorreo());
		
		if(usuarios == null) {
			
			response.setMensaje("El correo aún no ha sido Registrado!!!");
			response.setValor("0");
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		}else if(usuarios.getConfirmaCorreo() == 0) {
			
			response.setMensaje("El correo aún no ha sido confirmado!!!");
			response.setValor("1");
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		}else if(usuarios.getConfirmaCorreo() == 1){
			
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(parametros.getCorreo(), parametros.getPass()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);
			
			DetalleUsuarioImpl userDetails = (DetalleUsuarioImpl) authentication.getPrincipal();		
			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());

			return ResponseEntity.ok(new JwtResponse(jwt, 
													 userDetails.getId(), 
													 userDetails.getUsername(), 
													 userDetails.getEmail(),
													 roles));			
			
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);		
		
	}
	
	@PostMapping("/registroUsuario")
	public ResponseEntity<?> registerUserExterno( @Valid @RequestBody Parametros parametros ) throws MessagingException, IOException {
		
		Respuesta response = new Respuesta();
		
		// Create new user's account
		NztUsuario usuario = new NztUsuario(new String(parametros.getUsername()), parametros.getCorreo(), encoder.encode(parametros.getPass()));

		//poner de inicio el estatus del usuario activo
		usuario.setEstatus(1);
 
		//instancia de la nueva entidad creda por mau
		//UsuariosInfo infoUser = new UsuariosInfo();   se queda pendiente en espera de tablaya que no existe aun
		
		//fecha actual
		Date fechaActual = new Date();
		
		//set para guardar la fecha actual
		usuario.setFchReg(fechaActual);   
		
		//guardamos en tabla usuarios
		usuarioRepository.save(usuario);
		
		//recuperamos el id que se creo al guardar usuarios
		Long x = usuario.getIdUsuario();		
		
		//set para guardar el id del usuario recuperado
		//infoUser.setIdUsuario(x);  queda pendiente a tabla detale usuario
		
		//guardar en tabla de usuarios info
		//usuariosInfoRepository.save(infoUser); queda pendiente a tabla detale usuario
		
		ConfirmationToken confirmationToken = new ConfirmationToken(usuario);
		
		confirmationTokenRepository.save(confirmationToken);
		
		//envioSimple(signUpRequest.getEmail()); // correo normal
		envioHtml(parametros.getCorreo(),confirmationToken.getConfirmationToken()); // correo en html
		response.setMensaje("Usuario Registrado Correctamente!");
		return ResponseEntity.ok(response);
	}
	
//	//correo normal
//	void envioSimple(String correo) {
//
//        SimpleMailMessage msg = new SimpleMailMessage();
//        
//        msg.setTo("eduardo.0702.nunez@gmail.com");
//
//        msg.setSubject("Testing from Spring Boot");
//        msg.setText("Hello World \n Spring Boot Email");
//        
//        javaMailSender.send(msg);
//
//    }
//	
	//correo html
	void envioHtml(String correo, String token) throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(correo); // cambiar a que entre el correo personal solamente
       // helper.setTo("eduardo.0702.nunez@gmail.com"); // correo propio para prubas si no cambiar estatus confirmacion en BD

        helper.setSubject("Completa tu Registro!!!");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("Para confirmar su cuenta, haga clic aquí: "
        		+ pathMicroServ + "/api/auth/confirmar-cuenta?token="+token , true);

        javaMailSender.send(msg);

    }

}
