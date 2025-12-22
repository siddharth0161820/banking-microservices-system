package com.common.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {
    //1>Field
    @NotEmpty
    @Size(max = 51,message = "First Name should be valid")
    private String firstName;
    @NotEmpty
    @Email(message = "Please, enter the email")
    private String email;
    @NotEmpty(message = "Status for each user need to be updated")
    private String status;
    //2>Default constructor

    public UserRequestDTO() {
    }

    //3>Parametrized constructor

    public UserRequestDTO(String firstName, String email, String status) {
        this.firstName = firstName;
        this.email = email;
        this.status = status;
    }
    //4>toString()


    @Override
    public String toString() {
        return "UserRequestDTO{" +
                "firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
    //5>Getter & Setter

    public @NotEmpty @Size(max = 51, message = "First Name should be valid") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotEmpty @Size(max = 51, message = "First Name should be valid") String firstName) {
        this.firstName = firstName;
    }

    public @NotEmpty @Email(message = "Please, enter the email") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty @Email(message = "Please, enter the email") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "Status for each user need to be updated") String getStatus() {
        return status;
    }

    public void setStatus(@NotEmpty(message = "Status for each user need to be updated") String status) {
        this.status = status;
    }
}

