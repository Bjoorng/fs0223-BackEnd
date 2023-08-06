package com.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.classes.Role;
import com.main.enums.UserRole;

public interface RolesRepository extends JpaRepository<Role, Long>{
	
	Optional<Role> findByRoleName(UserRole roleName);
	
}
