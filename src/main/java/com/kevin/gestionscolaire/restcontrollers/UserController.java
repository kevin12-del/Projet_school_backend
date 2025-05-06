package com.kevin.gestionscolaire.restcontrollers;

import com.kevin.gestionscolaire.dtos.CreateUserDto;
import com.kevin.gestionscolaire.dtos.UserDto;
import com.kevin.gestionscolaire.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kevin.gestionscolaire.entities.User;
import com.kevin.gestionscolaire.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        users.forEach(user -> userDtos.add(userService.convertUserToUserDto(user)));
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<UserDto>> getAllUsersByRole(@PathVariable String role){
        List<User> users = userRepository.findByRole(User.Role.valueOf(role));
        List<UserDto> userDtos = new ArrayList<>();

        users.forEach(user -> userDtos.add(userService.convertUserToUserDto(user)));
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id : " + id));
        return ResponseEntity.ok(userService.convertUserToUserDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(userService.convertUserToUserDto(userRepository.save(userService.convertCreateUserDTOToUser(createUserDto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(userDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Failed to update user data."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

