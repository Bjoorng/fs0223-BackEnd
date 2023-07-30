package com.epicode.main.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.epicode.main.classes.User;
import com.epicode.main.repo.UserRepo;

public class UserService {

	Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired UserRepo utenteRepository;
    @Autowired @Qualifier("user") private ObjectProvider<User> utenteProvider;
	
    public User createUser(String username, String fullname, String email) {
    	User user = utenteProvider.getObject();
        user.setUsername(username);
        user.setFullName(fullname);
        user.setEmail(email);

        utenteRepository.save(user);
        log.info("User" + user.getFullName() + " saved.");
        return user;
    }
    
	public List<User> findAllUsers() {
        return (List<User>) utenteRepository.findAll();
    }
    
    public User findUserById(Long id) {
    	System.out.println("Utente trovato!");
    	return utenteRepository.findById(id).get();	
    }

    public void deleteUserById(Long id) {
    	System.out.println("User deleted!");
        utenteRepository.deleteById(id);
    }
}
