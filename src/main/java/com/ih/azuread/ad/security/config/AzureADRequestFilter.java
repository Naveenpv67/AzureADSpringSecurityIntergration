package com.ih.azuread.ad.security.config;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.DefaultOAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AzureADRequestFilter extends OncePerRequestFilter {

	private static final String TOKEN_PREFIX = "Bearer ";

	@Value("${spring.cloud.azure.active-directory.profile.tenant-id}")
	private String tenantId;

	@Value("${spring.cloud.azure.active-directory.credential.client-id}")
	private String clientId;

	@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
	private String issuerUri;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (!StringUtils.isEmpty(authorizationHeader)) {
			String jwtToken = authorizationHeader.replace("Bearer ", "");

			JwtDecoder jwtDecoder = JwtDecoders.fromIssuerLocation(issuerUri);
			Jwt jwt = jwtDecoder.decode(jwtToken);

			// Below validations are handled by default while decoding through -->
			// jwtDecoder.decode(jwtToken);
			if (!jwt.getAudience().contains(clientId)) {
				throw new JwtException("Invalid audience");
			}

			if (!jwt.getIssuer().toString().equals(issuerUri)) {
				throw new JwtException("Invalid issuer");
			}

			if (jwt.getExpiresAt() != null && jwt.getExpiresAt().isBefore(Instant.now())) {
				throw new JwtException("Token expired");
			}

			Map<String, Object> claims = jwt.getClaims();
			Map<String, Object> attributes = jwt.getClaims();
			List<GrantedAuthority> authorities = new ArrayList<>(); // Add any authorities you need
			String nameAttributeKey = "sub";
			DefaultOAuth2AuthenticatedPrincipal principal = new DefaultOAuth2AuthenticatedPrincipal(nameAttributeKey,
					attributes, authorities);

			// Create a new OAuth2User object using the DefaultOAuth2AuthenticatedPrincipal
			OAuth2User oauth2User = new DefaultOAuth2User(principal.getAuthorities(), principal.getAttributes(),
					nameAttributeKey);

			OAuth2AuthenticationToken authenticationToken = new OAuth2AuthenticationToken(oauth2User, null, "aad");

			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		} else {
			logger.error("Error - Please provide the Access token");
			SecurityContextHolder.clearContext();
		}

		filterChain.doFilter(request, response);
	}
}