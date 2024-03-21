package com.jaideep.spring.MysqlSpringProject.UserService;

import java.util.List;

import com.jaideep.spring.MysqlSpringProject.Models.User;

public interface UserService {
	User saveUser(User user);

    List<User> fetchAllUsers();

    User getUserById(Long id);

    User updateUserById(Long id, User user);

    String deleteUserById(Long id);
}
