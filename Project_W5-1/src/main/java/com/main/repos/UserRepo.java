package com.main.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.classes.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	
	Optional<User> findById(Long id);
}
