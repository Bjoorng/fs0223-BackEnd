package com.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.payload.JWTAuthResponse;
import com.main.payload.LoginDTO;
import com.main.payload.RegisterDTO;
import com.main.service.AuthService;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	
	private AuthService authService;
	
	public AuthController(AuthService authService) {
        this.authService = authService;
    }
	
	@PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDTO loginDto){
           	
    	String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setUsername(loginDto.getUsername());
        jwtAuthResponse.setToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }
	
	 @PostMapping(value = {"/register", "/signup"})
	    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDto){
	        String response = authService.register(registerDto);
	        return new ResponseEntity<>(response, HttpStatus.CREATED);
	    }
}
