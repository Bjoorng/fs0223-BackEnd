package com.main.runner;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.main.classes.Role;
import com.main.enums.UserRole;
import com.main.repositories.RolesRepository;
import com.main.repositories.UserRepository;
import com.main.service.AuthService;

@Component
public class AuthRunner implements ApplicationRunner{
	
	@Autowired RolesRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired AuthService authService;
	
	private Set<Role> adminRole;
	private Set<Role> moderatorRole;
	private Set<Role> userRole;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
		// Da lanciare solo la prima volta
		//setRoleDefault();
	}
	
	private void setRoleDefault() {
		Role admin = new Role();
		admin.setUserRole(UserRole.ADMIN);
		roleRepository.save(admin);
		
		Role user = new Role();
		user.setUserRole(UserRole.USER);
		roleRepository.save(user);
		
		Role moderator = new Role();
		moderator.setUserRole(UserRole.MODERATOR);
		roleRepository.save(moderator);
		
		adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(moderator);
		adminRole.add(user);
		
		moderatorRole = new HashSet<Role>();
		moderatorRole.add(moderator);
		moderatorRole.add(user);
		
		userRole = new HashSet<Role>();
		userRole.add(user);
	}
}
