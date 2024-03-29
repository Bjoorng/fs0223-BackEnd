package com.epicode.main.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.main.classes.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

}
