package com.example.BackPetProject.Routers;

import com.example.BackPetProject.DTO.AnswerDto;
import com.example.BackPetProject.DTO.QuestionDto;
import com.example.BackPetProject.Mappers.AnswerMapper;
import com.example.BackPetProject.UseCases.AnswerUseCases.CreateAnswerUseCase;
import com.example.BackPetProject.UseCases.AnswerUseCases.FindAllByParentIdUseCase;
import com.example.BackPetProject.UseCases.QuestionUseCases.CreateQuestionUseCase;
import com.example.BackPetProject.UseCases.QuestionUseCases.FindQuestionById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class AnswerRouters {

    @Bean
    public RouterFunction<ServerResponse> createAnswer(CreateAnswerUseCase createAnswerUseCase){
        return route(POST("/respuestas/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(AnswerDto.class)
                        .flatMap(createAnswerUseCase::createAnswer)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findByParentId(FindAllByParentIdUseCase findAllByParentIdUseCase){
        return route(GET("/respuestas/parentId/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findAllByParentIdUseCase
                                .findAllByParentId(request.pathVariable("id")), AnswerDto.class))
        );
    }
}
