package com.kevin.gestionscolaire.restcontrollers.user;

import com.kevin.gestionscolaire.repositories.userrepos.BaseUserRepository;
import com.kevin.gestionscolaire.services.Interface.user.BaseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/base-users")
@RequiredArgsConstructor
public class BaseUserController {
    private final BaseUserRepository baseUserRepository;
    BaseUserService baseUserService;

    /*@GetMapping
    public ResponseEntity<List<BaseUserDto>> getAllUsers(){
        List<BaseUser> baseUsers = baseUserRepository.findAll();
        List<BaseUserDto> baseUserDtos = new ArrayList<>();

        baseUsers.forEach(user -> baseUserDtos.add(baseUserService.convertUserToUserDto(user)));
        return ResponseEntity.ok(baseUserDtos);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<BaseUserDto>> getAllUsersByRole(@PathVariable String role){
        List<BaseUser> baseUsers = baseUserRepository.findByRole(BaseUser.Role.valueOf(role));
        List<BaseUserDto> baseUserDtos = new ArrayList<>();

        baseUsers.forEach(user -> baseUserDtos.add(baseUserService.convertUserToUserDto(user)));
        return ResponseEntity.ok(baseUserDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseUserDto> getUserById(@PathVariable Long id) {
        BaseUser baseUser = baseUserRepository.findById(id).orElseThrow(() -> new RuntimeException("BaseUser not found with id : " + id));
        return ResponseEntity.ok(baseUserService.convertUserToUserDto(baseUser));
    }

    @PostMapping
    public ResponseEntity<BaseUserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(baseUserService.convertUserToUserDto(baseUserRepository.save(baseUserService.convertCreateUserDTOToUser(createUserDto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseUserDto> updateUser(@PathVariable Long id, @RequestBody BaseUserDto baseUserDto) {
        return baseUserService.updateUser(baseUserDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Failed to update user data."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        baseUserRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }*/
}

