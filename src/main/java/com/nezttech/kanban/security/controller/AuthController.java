package com.nezttech.kanban.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nezttech.kanban.security.jwt.JwtUtils;

/**
 * @author Eduardo Nuñez
 * @version 1.0
 * @since   2021-11-27
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/authentication")
public class AuthController {
	
	

}
