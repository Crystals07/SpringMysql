package com.jaideep.spring.MysqlSpringProject.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="User")
public class User {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    private String name;
    private String descr;
    private Integer age;
    private Integer salary;

    public User() {
     
    }
    
    public User(String name, String descr, Integer age, Integer salary) {
        this.name = name;
        this.descr = descr;
        this.age = age;
        this.salary = salary;
    }
    
    // Getter and setter methods are provided by Lombok annotations

    // Getter methods
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }

    public Integer getAge() {
        return age;
    }

    // Setter methods
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
