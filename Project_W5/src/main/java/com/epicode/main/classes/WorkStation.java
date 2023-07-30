package com.epicode.main.classes;

import java.util.List;

import com.epicode.main.enums.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class WorkStation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
	private Type type;
	private int seats;
	@ManyToOne
	private Building building;
	private boolean occupied = false;
	@ManyToMany
	private List<User> users;
	
}
