package com.main.service;

import com.main.payload.LoginDTO;
import com.main.payload.RegisterDTO;

public interface AuthService {
	
	String login(LoginDTO loginDto);
    String register(RegisterDTO registerDto);
	
}
