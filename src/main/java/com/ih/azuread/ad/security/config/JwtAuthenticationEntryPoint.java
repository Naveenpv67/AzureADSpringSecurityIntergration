package com.ih.azuread.ad.security.config;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable{

	private static final long serialVersionUID = -7678932954082506277L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED, "You are not authorized. Please login to continue");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, CommonUtils.getJson(errorResponse));
	}
	
}
