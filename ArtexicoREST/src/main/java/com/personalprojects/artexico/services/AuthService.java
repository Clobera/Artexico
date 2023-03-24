package com.personalprojects.artexico.services;

import com.personalprojects.artexico.entities.User;

public interface AuthService {
	public User register(User user);

	public User getUserByUsername(String username);

}
