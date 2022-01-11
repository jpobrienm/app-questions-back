package com.example.BackPetProject.UseCases.AnswerUseCases;

import com.example.BackPetProject.Collections.Answer;
import com.example.BackPetProject.Mappers.AnswerMapper;
import com.example.BackPetProject.Mappers.QuestionMapper;
import com.example.BackPetProject.Repositories.AnswerRepository;
import com.example.BackPetProject.Repositories.QuestionRepository;
import com.example.BackPetProject.UseCases.QuestionUseCases.CreateQuestionUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DeleteAnswerByIdUseCaseTest {

    AnswerRepository answerRepository;
    AnswerMapper answerMapper;
    DeleteAnswerByIdUseCase deleteAnswerByIdUseCase;

    @BeforeEach
    public void setUp(){
        answerMapper = new AnswerMapper();
        answerRepository = mock(AnswerRepository.class);
        deleteAnswerByIdUseCase = new DeleteAnswerByIdUseCase(answerRepository, answerMapper);
    }

    @Test
    void deleteAnswerById(){

        var answer = new Answer();
        answer.setId("xxxx");

        when(answerRepository.deleteById("xxxx")).thenReturn(Mono.empty());

        StepVerifier.create(deleteAnswerByIdUseCase.deleteAnswerById(answer.getId()))
                .verifyComplete();

        verify(answerRepository).deleteById("xxxx");
    }

}