package com.example.BackPetProject.UseCases.AnswerUseCases;

import com.example.BackPetProject.Collections.Answer;
import com.example.BackPetProject.Collections.Question;
import com.example.BackPetProject.Collections.User;
import com.example.BackPetProject.DTO.AnswerDto;
import com.example.BackPetProject.Enums.Categories;
import com.example.BackPetProject.Enums.Types;
import com.example.BackPetProject.Mappers.AnswerMapper;
import com.example.BackPetProject.Mappers.QuestionMapper;
import com.example.BackPetProject.Repositories.AnswerRepository;
import com.example.BackPetProject.Repositories.QuestionRepository;
import com.example.BackPetProject.Repositories.UserRepository;
import com.example.BackPetProject.UseCases.QuestionUseCases.FindQuestionByIdUseCase;
import com.example.BackPetProject.UseCases.UserUseCases.CreateUserUseCase;
import com.example.BackPetProject.UseCases.Utils.SendEmailUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateAnswerUseCaseTest {

    AnswerRepository answerRepository;
    AnswerMapper answerMapper;
    FindAllByParentIdUseCase findAllByParentIdUseCase;
    SendEmailUseCase sendEmailUseCase;
    UserRepository userRepository;
    QuestionRepository questionRepository;
    QuestionMapper questionMapper;
    FindQuestionByIdUseCase findQuestionByIdUseCase;
    CreateAnswerUseCase createAnswerUseCase;

    @BeforeEach
    public void setUp(){
        answerMapper = new AnswerMapper();
        answerRepository = mock(AnswerRepository.class);
        findAllByParentIdUseCase = new FindAllByParentIdUseCase(answerRepository, answerMapper);
        sendEmailUseCase = new SendEmailUseCase();
        userRepository = mock(UserRepository.class);
        questionRepository = mock(QuestionRepository.class);
        questionMapper = new QuestionMapper();
        findQuestionByIdUseCase = new FindQuestionByIdUseCase(questionRepository, questionMapper);
        createAnswerUseCase = new CreateAnswerUseCase(answerRepository, answerMapper, sendEmailUseCase, findQuestionByIdUseCase, userRepository, questionRepository, questionMapper, findQuestionByIdUseCase);
    }

    @Test
    void createAnswerUseCase(){

        var answer = new Answer();
        answer.setId("xxxx");
        answer.setUserId("xxxx");
        answer.setAnswerBody("Esta es una respuesta de prueba");
        answer.setParentId("1234");
        answer.setScore(0);

        var answerDto = new AnswerDto();
        answerDto.setId("xxxx");
        answerDto.setUserId("xxxx");
        answerDto.setAnswerBody("Esta es una respuesta de prueba");
        answerDto.setParentId("1234");
        answerDto.setScore(0);

        var user = new User();
        user.setId("xxxx");
        user.setUserName("Cata");
        user.setFirstNames("Catalina");
        user.setLastNames("Álvarez");
        user.setEmail("cata@gmail.com");
        user.setPhoto("url");

        var question = new Question();
        question.setId("123");
        question.setUserId("xxxx");
        question.setTypes(Types.OPEN);
        question.setCategory(Categories.LANGUAGE);
        question.setQuestionBody("¿Es esta una pregunta de prueba?");

        when(userRepository.findById((String) any())).thenReturn(Mono.just(user));
        when(questionRepository.findById((String) any())).thenReturn(Mono.just(question));
        when(answerRepository.save(any()).thenReturn(Mono.just(answer)));
        when(questionRepository.save(any())).thenReturn(Mono.just(question));

        StepVerifier.create(createAnswerUseCase.createAnswer(answerDto))
                .expectNextMatches(response-> {
                    assert response.equals("Correo enviado");
                    return true;
                })
                .verifyComplete();





    }

}