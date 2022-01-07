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
public class FindUserByIdUseCase implements FindUserById{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public FindUserByIdUseCase(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public Mono<UserDto> findUserById(String id) {
        return userRepository.findById(id)
                .map(userMapper.mapToUserDto());
    }
}
