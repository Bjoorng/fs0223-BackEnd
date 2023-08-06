package com.main.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JWTAuthResponse {
	
	private String username;
	private String token;
	private String tokenType = "bearer";
}
