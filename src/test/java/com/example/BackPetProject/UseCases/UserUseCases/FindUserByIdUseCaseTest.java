package com.example.BackPetProject.UseCases.UserUseCases;

import com.example.BackPetProject.Collections.User;
import com.example.BackPetProject.Mappers.UserMapper;
import com.example.BackPetProject.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FindUserByIdUseCaseTest {

    UserRepository userRepository;
    UserMapper userMapper;
    FindUserByIdUseCase findUserByIdUseCase;

    @BeforeEach
    public void setUp(){
        UserMapper userMapper = new UserMapper();
        userRepository = mock(UserRepository.class);
        findUserByIdUseCase = new FindUserByIdUseCase(userRepository, userMapper);
    }

    @Test
    void findUserById(){
        var user = new User();
        user.setId("xxxx");

        when(userRepository.findById("xxxx")).thenReturn(Mono.just(user));

        StepVerifier.create(findUserByIdUseCase.findUserById("xxxx"))
                .expectNextMatches(userDto1-> {
                    assert userDto1.getId().equals("xxxx");
                    return true;
                })
                .verifyComplete();

        verify(userRepository).findById("xxxx");

    }

}