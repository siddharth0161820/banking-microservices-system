package com.common.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserResponseDTO {
    //1>Fields
    private Long userId;
    private String firstName;
    private String email;
    private String status;


    // 2>Default constructor
    public UserResponseDTO() {
    }

    // 3>Parameterized constructor
    public UserResponseDTO(Long userId, String firstName, String email, String status) {
        this.userId = userId;
        this.firstName = firstName;
        this.email = email;
        this.status = status;
    }

    // 4>Getter & Setter
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public @NotEmpty @Size(max = 51, message = "First Name should be valid") String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public @NotEmpty @Email(message = "Please, enter the email") String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public @NotEmpty(message = "Status for each user need to be updated") String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    // 5>toString()

    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
