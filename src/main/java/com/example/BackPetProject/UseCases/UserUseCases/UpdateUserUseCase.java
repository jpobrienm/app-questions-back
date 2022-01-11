package com.example.BackPetProject.UseCases.UserUseCases;

import com.example.BackPetProject.DTO.UserDto;
import com.example.BackPetProject.Mappers.UserMapper;
import com.example.BackPetProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UpdateUserUseCase implements UpdateUser{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UpdateUserUseCase(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public Mono<UserDto> updateUser(UserDto userDto) {
        return userRepository.save(userMapper.mapToUser().apply(userDto))
                .map(userMapper.mapToUserDto());
    }
}
