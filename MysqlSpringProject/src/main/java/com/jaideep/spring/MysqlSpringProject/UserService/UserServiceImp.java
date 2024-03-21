package com.jaideep.spring.MysqlSpringProject.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jaideep.spring.MysqlSpringProject.Models.User;
import com.jaideep.spring.MysqlSpringProject.Repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	 @Autowired
	 private UserRepository userRepository;
	
	@Override
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> fetchAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

	@Override
	public User getUserById(Long id) {
		 Optional<User> User = userRepository.findById(id);
	        if (User.isPresent()) {
	            return User.get();
	        }
	        return null;
	}

	@Override
	public User updateUserById(Long id, User user) {
		   Optional<User> User1 = userRepository.findById(id);

	        if (User1.isPresent()) {
	            User originalUser = User1.get();
	            
	            if (Objects.nonNull(user.getId())) {
	                originalUser.setId(user.getId());
	            }
	            
	            if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
	                originalUser.setName(user.getName());
	            }
	            
	            if (Objects.nonNull(user.getDescr()) && !"".equalsIgnoreCase(user.getDescr())) {
	                originalUser.setDescr(user.getDescr());
	            }
	            
	            if (Objects.nonNull(user.getAge()) && user.getAge()>0) {
	                originalUser.setAge(user.getAge());
	            }

	            return userRepository.save(originalUser);
	        }
	        return null;
	}

	@Override
	public String deleteUserById(Long id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "No such User in the database";
    }
}

