package com.kevin.gestionscolaire.services;

import com.kevin.gestionscolaire.dtos.CreateUserDto;
import com.kevin.gestionscolaire.dtos.UserDto;
import com.kevin.gestionscolaire.entities.User;
import com.kevin.gestionscolaire.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> convertUserToUserDto(user))
                .collect(Collectors.toList());
    }


    public Optional<UserDto> getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> convertUserToUserDto(user));
    }

    public Optional<UserDto> createUser(CreateUserDto createUserDto) {
        User user = convertCreateUserDTOToUser(createUserDto);
        User savedUser = userRepository.save(user);
        UserDto userDto = convertUserToUserDto(savedUser);
        return Optional.ofNullable(userDto);
    }

    public Optional<UserDto> updateUser(UserDto userDto) {
        Optional<User> user = userRepository.findById(userDto.getId());
        if (user.isPresent()) {
            return Optional.of(convertUserToUserDto(userRepository.save(convertUserDtoToUser(userDto))));
        } else {
            throw new EntityNotFoundException("User not found");
        }
    }

    public void deleteUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User not found");
        }
    }



    public User convertCreateUserDTOToUser(CreateUserDto createUserDto){
        User user = new User();

        user.setNom(createUserDto.getNom());
        user.setPrenom(createUserDto.getPrenom());
        user.setEmail(createUserDto.getEmail());
        user.setRole(User.Role.valueOf(createUserDto.getRole()));
        return user;
    }

    public UserDto convertUserToUserDto(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setNom(user.getNom());
        userDto.setPrenom(user.getPrenom());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole().toString());
        return userDto;
    }

    public User convertUserDtoToUser(UserDto userDto){
        User user = new User();

        user.setId(userDto.getId());
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setEmail(userDto.getEmail());
        user.setRole(User.Role.valueOf(userDto.getRole()));
        return user;
    }

}

