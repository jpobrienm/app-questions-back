package com.example.BackPetProject.UseCases.UserUseCases;

import com.example.BackPetProject.DTO.UserDto;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindUserById {
    public Mono<UserDto> findUserById(String id);
}
