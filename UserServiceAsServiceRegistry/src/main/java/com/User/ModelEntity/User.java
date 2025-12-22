package com.User.ModelEntity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "UserSERVICEINFO")
public class User {
    //1>Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String email;
    private String status;


    //2>Default constructor
    public User() {
    }

    //3>Parameterized Constructor

    public User(Long userId, String firstName, String email, String status) {
        this.userId = userId;
        this.firstName = firstName;
        this.email = email;
        this.status = status;
    }


    //4>Getter & Setter

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    //5>toString()


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
