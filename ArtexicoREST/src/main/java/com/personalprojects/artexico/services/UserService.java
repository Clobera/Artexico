package com.personalprojects.artexico.services;

import java.util.List;

import com.personalprojects.artexico.entities.User;

public interface UserService {
 	public List<User> index();

    public User findById(int userId);

    public User show(String username);

    public User update(String username, User user);

    public boolean destroy(String username);
}
