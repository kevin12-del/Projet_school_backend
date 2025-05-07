package com.kevin.gestionscolaire.services.javaclass.user;

import com.kevin.gestionscolaire.repositories.userrepos.BaseUserRepository;
import com.kevin.gestionscolaire.services.Interface.user.BaseUserService;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseUserServiceImpl implements BaseUserService {

    @Autowired
    BaseUserRepository baseUserRepository;

    @Autowired
    ModelMapper modelMapper;

    /*public List<BaseUserDto> getAllUsers() {
        return baseUserRepository.findAll().stream()
                .map(user -> convertUserToUserDto(user))
                .collect(Collectors.toList());
    }


    public Optional<BaseUserDto> getUserById(Long id) {
        return baseUserRepository.findById(id)
                .map(user -> convertUserToUserDto(user));
    }

    public Optional<BaseUserDto> createUser(CreateUserDto createUserDto) {
        BaseUser baseUser = convertCreateUserDTOToUser(createUserDto);
        BaseUser savedBaseUser = baseUserRepository.save(baseUser);
        BaseUserDto baseUserDto = convertUserToUserDto(savedBaseUser);
        return Optional.ofNullable(baseUserDto);
    }

    public Optional<BaseUserDto> updateUser(BaseUserDto baseUserDto) {
        Optional<BaseUser> user = baseUserRepository.findById(baseUserDto.getId());
        if (user.isPresent()) {
            return Optional.of(convertUserToUserDto(baseUserRepository.save(convertUserDtoToUser(baseUserDto))));
        } else {
            throw new EntityNotFoundException("BaseUser not found");
        }
    }

    public void deleteUser(Long id){
        Optional<BaseUser> user = baseUserRepository.findById(id);
        if (user.isPresent()) {
            baseUserRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("BaseUser not found");
        }
    }



    public BaseUser convertCreateUserDTOToUser(CreateUserDto createUserDto){
        BaseUser baseUser = new BaseUser();

        baseUser.setNom(createUserDto.getNom());
        baseUser.setPrenom(createUserDto.getPrenom());
        baseUser.setEmail(createUserDto.getEmail());
        baseUser.setRole(BaseUser.Role.valueOf(createUserDto.getRole()));
        return baseUser;
    }

    public BaseUserDto convertUserToUserDto(BaseUser baseUser){
        BaseUserDto baseUserDto = new BaseUserDto();

        baseUserDto.setId(baseUser.getId());
        baseUserDto.setNom(baseUser.getNom());
        baseUserDto.setPrenom(baseUser.getPrenom());
        baseUserDto.setEmail(baseUser.getEmail());
        baseUserDto.setRole(baseUser.getRole().toString());
        return baseUserDto;
    }

    public BaseUser convertUserDtoToUser(BaseUserDto baseUserDto){
        BaseUser baseUser = new BaseUser();

        baseUser.setId(baseUserDto.getId());
        baseUser.setNom(baseUserDto.getNom());
        baseUser.setPrenom(baseUserDto.getPrenom());
        baseUser.setEmail(baseUserDto.getEmail());
        baseUser.setRole(BaseUser.Role.valueOf(baseUserDto.getRole()));
        return baseUser;
    }*/

}

