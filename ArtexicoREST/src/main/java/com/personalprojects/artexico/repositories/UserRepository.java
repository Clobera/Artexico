package com.personalprojects.artexico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalprojects.artexico.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);

}
