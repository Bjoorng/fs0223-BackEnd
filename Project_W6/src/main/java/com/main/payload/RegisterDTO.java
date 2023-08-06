package com.main.payload;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterDTO {

	private String name;
	private String username;
	private String email;
	private String password;
	private Set<String> roles;

}
