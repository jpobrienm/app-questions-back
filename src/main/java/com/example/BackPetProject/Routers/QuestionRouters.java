package com.example.BackPetProject.Routers;

import com.example.BackPetProject.DTO.QuestionDto;
import com.example.BackPetProject.UseCases.QuestionUseCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
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

    @Bean
    public RouterFunction<ServerResponse> findQuestionById(FindQuestionByIdUseCase findQuestionByIdUseCase){
        return route(GET("/preguntas/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findQuestionByIdUseCase
                                .findQuestionById(request.pathVariable("id")), QuestionDto.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findAllQuestionByUserId(FindAllQuestionsByUserIdUseCase findAllQuestionsByUserIdUseCase){
        return route(GET("/preguntas/usuario/{userId}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findAllQuestionsByUserIdUseCase
                                .findAllByUserId(request.pathVariable("userId")), QuestionDto.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findAllQuestions(FindAllQuestionsUseCase findAllQuestionsUseCase){
        return route(GET("/preguntas").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findAllQuestionsUseCase
                                .findAllQuestions(), QuestionDto.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deleteQuestionById(DeleteQuestionByIdUseCase deleteQuestionByIdUseCase){
        return route(DELETE("preguntas/eliminar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(deleteQuestionByIdUseCase
                                .deleteQuestionById(request.pathVariable("id")), Void.class)));
    }
}
