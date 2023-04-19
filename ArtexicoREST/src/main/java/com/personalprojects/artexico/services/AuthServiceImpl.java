package com.personalprojects.artexico.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.personalprojects.artexico.entities.User;
import com.personalprojects.artexico.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepo;

	@Override
	public User register(User user) {
		String endodedPW = encoder.encode(user.getPassword());
		user.setPassword(endodedPW);
		user.setRole("standard");
		user.setEnabled(true);
		userRepo.saveAndFlush(user);
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		User output = userRepo.findByUsername(username);
		if (output != null) {
			return output;
		}
		return null;
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> userOpt = userRepo.findById(userId);
		User output = new User();
		if (userOpt.isPresent()) {
			output = userOpt.get();
			return output;
		}
		return null;
	}

}
