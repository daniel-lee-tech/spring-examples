package com.example.mysqlexample.entities;

import com.example.mysqlexample.dto.UserDTO;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;

    private String name;
    private String email;

    public UserEntity(UserDTO userDTO) {
        this.id = 0L; // this will be overridden by @GeneratedValue
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
    }

    public UserEntity() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
