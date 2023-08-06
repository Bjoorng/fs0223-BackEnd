package com.main.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.classes.User;
import com.main.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired UserRepository userRepo;
	
	public User findUserbyId(long id) {
		User user = userRepo.findById(id).get();
		log.info(user.toString());
		return user;
	}
	
	public List<User> findAllUsers(){
        List<User> listaUtenti= (List<User>)userRepo.findAll();
        listaUtenti.forEach(lu -> log.info(lu.toString()));
        return listaUtenti;
    }
	
	public String deleteUtenteById(long id) {
		if (userRepo.existsById(id)) {
            User user = findUserbyId(id);
            userRepo.delete(user);
            return "User deleted";
        } else {
            return "No Users matching this id";
        }
    }
}
