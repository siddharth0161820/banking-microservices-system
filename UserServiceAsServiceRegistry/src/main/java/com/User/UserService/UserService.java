package com.User.UserService;



import com.common.dto.UserRequestDTO;
import com.common.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO);
    public UserResponseDTO updateUser( UserRequestDTO userRequestDTO,long userId);
    public List<UserResponseDTO>getAllUser();
    public UserResponseDTO getSingleUser(long id);
    public void deleteUser(long id);
}