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
public class FindUserByNameUseCase implements FindUserByName{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public FindUserByNameUseCase(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Mono<UserDto> findByName(String name) {
        return userRepository.findByUserName(name)
                .map(userMapper.mapToUserDto());
    }
}
