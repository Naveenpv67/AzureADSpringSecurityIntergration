package com.ih.azuread.ad.security.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AzureADRequestFilter azureADRequestFilter;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();

		http.authorizeRequests()
		.anyRequest().authenticated().and().cors().disable()
				.csrf().disable().httpBasic().disable().exceptionHandling()
				// IMPORTANT!!
				.authenticationEntryPoint(jwtAuthenticationEntryPoint).accessDeniedHandler(
						(request, response, authException) -> response.sendError(HttpServletResponse.SC_FORBIDDEN));

		// IMPORTANT!!
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// IMPORTANT!!
		http.addFilterAfter(azureADRequestFilter, BearerTokenAuthenticationFilter.class);
	}

}