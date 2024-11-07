package com.jaideep.spring.MysqlSpringProject.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaideep.spring.MysqlSpringProject.Models.User;
import com.jaideep.spring.MysqlSpringProject.UserService.UserService;

@RestController
public class UserController {
	    @Autowired
	    private UserService userService;

		// /User mapping
	    @PostMapping("/User")
	    public User saveUser(@RequestBody User user) {
	    	System.out.println("@@ "+user.getName()+" "+user.getAge());
	    	return userService.saveUser(user);
	    }
	    
	    @GetMapping("/")
	    public String getHome() {
	        return "Welcome Home";
	    }
	    
	    @GetMapping("/User")
	    public List<User> getAllUsers() {
	        return userService.fetchAllUsers();
	    }

	    @GetMapping("/User/{id}")
	    public User getUserById(@PathVariable("id") Long id) {
	        return userService.getUserById(id);
	    }

	    @PutMapping("/User/{id}")
	    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
	        return userService.updateUserById(id, user);
	    }

	    @DeleteMapping("/User/{id}")
	    public String deleteUser(@PathVariable("id") Long id) {
	        return userService.deleteUserById(id);
	    }
}
