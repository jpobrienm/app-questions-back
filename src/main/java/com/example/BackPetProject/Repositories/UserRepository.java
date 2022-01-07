package com.example.BackPetProject.Repositories;

import com.example.BackPetProject.Collections.User;
import com.example.BackPetProject.DTO.UserDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> findByUserName(String name);
}
