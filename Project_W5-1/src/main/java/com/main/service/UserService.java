package com.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.main.classes.User;
import com.main.repos.UserRepo;

public class UserService {

	Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired UserRepo utenteRepository;
    @Autowired @Qualifier("user") private ObjectProvider<User> up;
	
    public User createUser(String username, String nomeCompleto, String email) {
    	User user = up.getObject();
        user.setUsername(username);
        user.setFullName(nomeCompleto);
        user.setEmail(email);

        utenteRepository.save(user);
        log.info("Utente" + user.getFullName() + " saved.");
        return user;
    }
    
}
