package com.User.UserService;


import com.User.GlobalExceptionHandling.NOTFOUNDEXCEPTION;
import com.User.ModelEntity.User;
import com.User.UserRepository.UserRepository;

import com.common.dto.UserRequestDTO;
import com.common.dto.UserResponseDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{
    //1>Connect service layer to the repository layer via constructor injection
    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


 //2>Implementing endpoints
    @Override
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        User addUser=new User();
        //1>convert dto mapping to entities
          addUser.setFirstName(userRequestDTO.getFirstName());
          addUser.setEmail(userRequestDTO.getEmail());
          addUser.setStatus(userRequestDTO.getStatus());
          //2>save to database
         User saveUser=userRepository.save(addUser);
         //3>Return details to user

        return new UserResponseDTO(
                saveUser.getUserId(),
                saveUser.getFirstName(),
                saveUser.getEmail(),
                saveUser.getStatus()
        );
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO, long userId) {
        //1>Check if the user in the dto to be updated exists in the repository or not to avoid error
        User exisitngUser=userRepository.findById(userId)
                .orElseThrow(()->new NOTFOUNDEXCEPTION("User details not found by userId to be updated"+userId));
        //2>If user details found in the repository update the DTO
           exisitngUser.setFirstName(userRequestDTO.getFirstName());
           exisitngUser.setEmail(userRequestDTO.getEmail());
           exisitngUser.setStatus(userRequestDTO.getStatus());

           //3>Save to repository
        User savedUser=userRepository.save(exisitngUser);
        //4>Return User details to the client
        return new UserResponseDTO(
                savedUser.getUserId(),
                savedUser.getFirstName(),
                savedUser.getEmail(),
                savedUser.getStatus()
        );
    }

    @Override
    public List<UserResponseDTO> getAllUser() {
        return userRepository.findAll().stream().map(
                findAll -> new UserResponseDTO(
                        findAll.getUserId(),
                        findAll.getFirstName(),
                        findAll.getEmail(),
                        findAll.getStatus()
                )
        ).toList();
    }


    @Override
    public UserResponseDTO getSingleUser(long id) {
        return userRepository.findById(id)
                .map(getSingleUser->new UserResponseDTO(
                        getSingleUser.getUserId(),
                        getSingleUser.getFirstName(),
                        getSingleUser.getEmail(),
                        getSingleUser.getStatus()
                )).orElseThrow(()->new NOTFOUNDEXCEPTION("User details not found by id"+id));
    }


    @Override
    public void deleteUser(long id) {
        //1>check if the user to be deleted is there or not to avoid error
        User existingUser=userRepository.findById(id)
                .orElseThrow(()->new NOTFOUNDEXCEPTION("User details not found to be deleted"+id));
        //2>User details found to be deleted, just delete it...
         userRepository.deleteById(id);
    }


}






