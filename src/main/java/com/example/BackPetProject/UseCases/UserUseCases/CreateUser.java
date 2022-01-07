package com.example.BackPetProject.UseCases.UserUseCases;

import com.example.BackPetProject.DTO.UserDto;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateUser {
    public Mono<UserDto> createUser(UserDto userDto);
}
