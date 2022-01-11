package com.example.BackPetProject.UseCases.QuestionUseCases;

import com.example.BackPetProject.Collections.Answer;
import com.example.BackPetProject.Collections.Question;
import com.example.BackPetProject.Mappers.QuestionMapper;
import com.example.BackPetProject.Repositories.AnswerRepository;
import com.example.BackPetProject.Repositories.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteQuestionByIdUseCaseTest {

    QuestionRepository questionRepository;
    DeleteQuestionByIdUseCase deleteQuestionByIdUseCase;
    AnswerRepository answerRepository;

    @BeforeEach
    public void setUp(){
        questionRepository = mock(QuestionRepository.class);
        answerRepository = mock(AnswerRepository.class);
        deleteQuestionByIdUseCase = new DeleteQuestionByIdUseCase(questionRepository, answerRepository);
    }

    @Test
    void deleteQuestionById(){

        var question = new Question();
        question.setId("123");

        var answer = new Answer();
        answer.setId("xxxx");

        when(answerRepository.deleteAllByParentId("123")).thenReturn(Mono.empty());
        when(questionRepository.deleteById("123")).thenReturn(Mono.empty());

        StepVerifier.create(deleteQuestionByIdUseCase.deleteQuestionById(question.getId()))
                .verifyComplete();

        verify(answerRepository).deleteAllByParentId("123");
        verify(questionRepository).deleteById("123");
    }

}