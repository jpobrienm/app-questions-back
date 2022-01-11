package com.example.BackPetProject.UseCases.QuestionUseCases;

import com.example.BackPetProject.Collections.Question;
import com.example.BackPetProject.Enums.Categories;
import com.example.BackPetProject.Enums.Types;
import com.example.BackPetProject.Mappers.QuestionMapper;
import com.example.BackPetProject.Repositories.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class FindAllQuestionsUseCaseTest {

    QuestionRepository questionRepository;
    FindAllQuestionsUseCase findAllQuestionsUseCase;

    @BeforeEach
    public void setUp(){
        QuestionMapper questionMapper = new QuestionMapper();
        questionRepository = mock(QuestionRepository.class);
        findAllQuestionsUseCase = new FindAllQuestionsUseCase(questionRepository, questionMapper);
    }

    @Test
    void findAllQuestionUseCase(){
        var question = new Question();
        question.setId("123");
        question.setUserId("xxxx");
        question.setTypes(Types.OPEN);
        question.setCategory(Categories.LANGUAGE);
        question.setQuestionBody("¿Es esta una pregunta de prueba?");

        when(questionRepository.findAll()).thenReturn(Flux.just(question));

        StepVerifier.create(findAllQuestionsUseCase.findAllQuestions())
                .expectNextMatches(questionR-> {
                    assert questionR.getUserId().equals("xxxx");
                    assert questionR.getCategory().equals(Categories.LANGUAGE);
                    assert questionR.getQuestionBody().equals("¿Es esta una pregunta de prueba?");
                    assert questionR.getType().equals(Types.OPEN);
                    return true;
                })
                .verifyComplete();

        verify(questionRepository).findAll();

    }

}