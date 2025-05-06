package com.kevin.gestionscolaire.services;

import com.kevin.gestionscolaire.dtos.CreateUserDto;
import com.kevin.gestionscolaire.dtos.UserDto;
import com.kevin.gestionscolaire.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAllUsers();
    Optional<UserDto> getUserById(Long id);
    Optional<UserDto> createUser(CreateUserDto createUserDto);
    Optional<UserDto> updateUser(UserDto userDto);
    void deleteUser(Long id);
    UserDto convertUserToUserDto(User user);
    User convertUserDtoToUser(UserDto userDto);
    User convertCreateUserDTOToUser(CreateUserDto createUserDto);
}
