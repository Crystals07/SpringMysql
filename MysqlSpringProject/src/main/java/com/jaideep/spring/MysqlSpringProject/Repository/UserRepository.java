package com.jaideep.spring.MysqlSpringProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaideep.spring.MysqlSpringProject.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//User Repo
}
