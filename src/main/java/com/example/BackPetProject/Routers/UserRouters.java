package com.example.BackPetProject.Routers;

import com.example.BackPetProject.DTO.UserDto;
import com.example.BackPetProject.UseCases.UserUseCases.CreateUserUseCase;
import com.example.BackPetProject.UseCases.UserUseCases.FindUserByIdUseCase;
import com.example.BackPetProject.UseCases.UserUseCases.FindUserByNameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserRouters {

    @Bean
    public RouterFunction<ServerResponse> createUser(CreateUserUseCase createUserUseCase){
        return route(POST("/usuarios/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UserDto.class)
                        .flatMap(createUserUseCase::createUser)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findUserById(FindUserByIdUseCase findUserByIdUseCase){
        return route(GET("/usuario/id={id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findUserByIdUseCase
                                .findUserById(request.pathVariable("id")), UserDto.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findUserByName(FindUserByNameUseCase findUserByNameUseCase){
        return route(GET("/usuario/nombre={nombre}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findUserByNameUseCase
                                .findByName(request.pathVariable("nombre")), UserDto.class))
        );
    }
}
