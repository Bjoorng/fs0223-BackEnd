package com.main.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.main.enums.UserRole;
import com.main.classes.Role;
import com.main.classes.User;
import com.main.exceptions.PersonalApiException;
import com.main.payload.LoginDTO;
import com.main.payload.RegisterDTO;
import com.main.repositories.RolesRepository;
import com.main.repositories.UserRepository;
import com.main.security.JwtTokenProvider;

@Service
public class AuthServiceIMPL implements AuthService {

	private AuthenticationManager authenticationManager;
	private UserRepository userRepo;
	private RolesRepository rolesRepo;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;

	public AuthServiceIMPL(AuthenticationManager authenticationManager, UserRepository userRepo,
			RolesRepository rolesRepo, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
		this.authenticationManager = authenticationManager;
		this.userRepo = userRepo;
		this.rolesRepo = rolesRepo;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public String login(LoginDTO loginDto) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtTokenProvider.generateToken(authentication);

		return token;
	}

	@Override
	public String register(RegisterDTO registerDto) {

		if (userRepo.existsByUsername(registerDto.getUsername())) {
			throw new PersonalApiException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
		}

		if (userRepo.existsByEmail(registerDto.getEmail())) {
			throw new PersonalApiException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
		}

		User user = new User();
		user.setName(registerDto.getName());
		user.setUsername(registerDto.getUsername());
		user.setEmail(registerDto.getEmail());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

		Set<Role> roles = new HashSet<>();

		if (registerDto.getRoles() != null) {
			registerDto.getRoles().forEach(role -> {
				Role userRole = rolesRepo.findByRoleName(getRole(role)).get();
				roles.add(userRole);
			});
		} else {
			Role userRole = rolesRepo.findByRoleName(UserRole.USER).get();
			roles.add(userRole);
		}

		user.setRoles(roles);
		System.out.println(user);
		userRepo.save(user);

		return "User registered successfully!.";
	}

	public UserRole getRole(String role) {
		if (role.equals("ADMIN"))
			return UserRole.ADMIN;
		else if (role.equals("MODERATOR"))
			return UserRole.MODERATOR;
		else
			return UserRole.USER;
	}
}
