package com.ih.azuread.ad.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ih.azuread.ad.security.config.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.info("LoggedInUser ==> ", principal.toString());
		return ResponseEntity.status(HttpStatus.OK).body(CommonUtils.getJson(principal.toString()));
	}

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('APPROLE_Admin')")
	public String admin() {
		return "Hello Admin!";
	}
}
