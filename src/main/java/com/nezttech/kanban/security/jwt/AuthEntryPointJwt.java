package com.nezttech.kanban.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author Nezttech
 * @version 1.0
 * @since   2021-11-27
 */

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint{
	
	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.error("No autorizado error: {}", authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: No autorizado");
	}

}
