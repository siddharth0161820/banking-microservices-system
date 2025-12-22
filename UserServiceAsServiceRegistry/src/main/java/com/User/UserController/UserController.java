package com.User.UserController;


import com.User.UserService.UserService;

import com.common.dto.UserRequestDTO;
import com.common.dto.UserResponseDTO;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    //1>Connect UserController to UserService via constructor injection
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //2>Creating endpoints
    //2.1>addUser
    @PostMapping("/addUser")
    public ResponseEntity<UserResponseDTO> addUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO addUser=userService.addUser(userRequestDTO);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }
    //2.2>updateUser
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserResponseDTO>updateUser(@Valid @RequestBody UserRequestDTO userRequestDTO, @PathVariable long id){
        UserResponseDTO updateUser=userService.updateUser(userRequestDTO,id);
        return ResponseEntity.ok(updateUser);


    }
    //2.3>getAllUser
    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserResponseDTO>>getAllUser(){
        List<UserResponseDTO> getAllUser=userService.getAllUser();
        return ResponseEntity.ok(getAllUser);
    }

    //2.4>getSingleUser
    @GetMapping("/getSingleUser/{id}")
    public ResponseEntity<UserResponseDTO>getSingleUser(@PathVariable long id) {
        UserResponseDTO getSingleUser=userService.getSingleUser(id);
        return ResponseEntity.ok(getSingleUser);
    }

    //2.5>deleteUser
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

}
