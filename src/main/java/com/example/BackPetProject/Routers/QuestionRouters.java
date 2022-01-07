package com.example.BackPetProject.Routers;

import com.example.BackPetProject.DTO.QuestionDto;
import com.example.BackPetProject.DTO.UserDto;
import com.example.BackPetProject.UseCases.QuestionUseCases.CreateQuestionUseCase;
import com.example.BackPetProject.UseCases.UserUseCases.CreateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class QuestionRouters {

    @Bean
    public RouterFunction<ServerResponse> createQuestion(CreateQuestionUseCase createQuestionUseCase){
        return route(POST("/preguntas/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(QuestionDto.class)
                        .flatMap(createQuestionUseCase::createQuestion)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result))
        );
    }
}
