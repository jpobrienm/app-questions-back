package com.example.BackPetProject.UseCases.AnswerUseCases;

import com.example.BackPetProject.Collections.Answer;
import com.example.BackPetProject.Enums.Categories;
import com.example.BackPetProject.Enums.Types;
import com.example.BackPetProject.Mappers.AnswerMapper;
import com.example.BackPetProject.Repositories.AnswerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FindAllByParentIdUseCaseTest {

    AnswerRepository answerRepository;
    AnswerMapper answerMapper;
    FindAllByParentIdUseCase findAllByParentIdUseCase;

    @BeforeEach
    public void setUp(){
        answerMapper = new AnswerMapper();
        answerRepository = mock(AnswerRepository.class);
        findAllByParentIdUseCase = new FindAllByParentIdUseCase(answerRepository, answerMapper);
    }

    @Test
    void findAllbyParentId(){

        var answer = new Answer();
        answer.setId("xxxx");
        answer.setAnswerBody("Esta es una respuesta de prueba");
        answer.setParentId("1234");
        answer.setScore(0);

        when(answerRepository.findAllByParentId("1234")).thenReturn(Flux.just(answer));

        StepVerifier.create(findAllByParentIdUseCase.findAllByParentId("1234"))
                .expectNextMatches(answerDto-> {
                    assert answerDto.getId().equals("xxxx");
                    assert answerDto.getAnswerBody().equals("Esta es una respuesta de prueba");
                    assert answerDto.getParentId().equals("1234");
                    assert answerDto.getScore().equals(0);
                    return true;
                })
                .verifyComplete();

        verify(answerRepository).findAllByParentId("1234");
    }
}