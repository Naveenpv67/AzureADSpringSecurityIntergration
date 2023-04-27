package com.ih.azuread.ad.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello World");
	}

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('APPROLE_Admin')")
	public String admin() {
		return "Hello Admin!";
	}
}
