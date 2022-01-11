package com.example.BackPetProject.UseCases.UserUseCases;

import com.example.BackPetProject.Collections.User;
import com.example.BackPetProject.DTO.UserDto;
import com.example.BackPetProject.Mappers.UserMapper;
import com.example.BackPetProject.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FindUserByNameUseCaseTest {

    UserRepository userRepository;
    UserMapper userMapper;
    FindUserByNameUseCase findUserByNameUseCase;

    @BeforeEach
    public void setUp(){
        UserMapper userMapper = new UserMapper();
        userRepository = mock(UserRepository.class);
        findUserByNameUseCase = new FindUserByNameUseCase(userRepository, userMapper);
    }

    @Test
    void findUserByName(){
        var user = new User();
        user.setId("xxxx");
        user.setUserName("Cata");
        user.setFirstNames("Catalina");
        user.setLastNames("Álvarez");
        user.setEmail("cata@gmail.com");
        user.setPhoto("url");

        when(userRepository.findByUserName(any())).thenReturn(Mono.just(user));

        StepVerifier.create(findUserByNameUseCase.findByName("Cata"))
                .expectNextMatches(userDto1-> {
                    assert userDto1.getId().equals("xxxx");
                    assert userDto1.getUserName().equals("Cata");
                    assert userDto1.getFirstNames().equals("Catalina");
                    assert userDto1.getLastNames().equals("Álvarez");
                    assert userDto1.getPhoto().equals("url");
                    assert userDto1.getEmail().equals("cata@gmail.com");

                    return true;
                })
                .verifyComplete();


        verify(userRepository).findByUserName(any());
    }


}