package com.hexaware.cinemax.services;

import com.hexaware.cinemax.dto.UserDTO;

public interface IUserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(int userId);

    // Add more methods as needed for updating, deleting, or retrieving users
}
