package com.example.BackPetProject.UseCases.AnswerUseCases;

import com.example.BackPetProject.DTO.AnswerDto;
import com.example.BackPetProject.Mappers.AnswerMapper;
import com.example.BackPetProject.Mappers.QuestionMapper;
import com.example.BackPetProject.Repositories.AnswerRepository;
import com.example.BackPetProject.Repositories.QuestionRepository;
import com.example.BackPetProject.Repositories.UserRepository;
import com.example.BackPetProject.UseCases.QuestionUseCases.FindQuestionById;
import com.example.BackPetProject.UseCases.QuestionUseCases.FindQuestionByIdUseCase;
import com.example.BackPetProject.UseCases.Utils.SendEmailUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateAnswerUseCase implements CreateAnswer {

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final FindQuestionByIdUseCase findQuestionByIdUseCase;
    private final SendEmailUseCase sendEmailUseCase;
    private final QuestionMapper questionMapper;

    public CreateAnswerUseCase(AnswerRepository answerRepository, AnswerMapper answerMapper, SendEmailUseCase sendEmailUseCase, FindQuestionById findQuestionById, UserRepository userRepository, QuestionRepository questionRepository, QuestionMapper questionMapper, FindQuestionByIdUseCase findQuestionByIdUseCase) {
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
        this.sendEmailUseCase = sendEmailUseCase;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
        this.findQuestionByIdUseCase = findQuestionByIdUseCase;
    }


    @Override
    public Mono<String> createAnswer(AnswerDto answerDto) {

        return userRepository.findById(questionRepository.findById(answerDto.getParentId())
                        .map(question -> question.getUserId()))
                .flatMap(user -> {
                    return answerRepository.save(answerMapper.mapToAnswer().apply(answerDto))
                            .flatMap(answer -> {
                                return findQuestionByIdUseCase.findQuestionById(answer.getParentId())
                                        .flatMap(questionDTO -> {
                                            sendEmailUseCase.sendMail(
                                                    user.getEmail(),
                                                    "Han respondido a tu pregunta",
                                                    "Pregunta: \n" + questionDTO.getQuestionBody() +
                                                            " \nRespuesta: \n" + answerDto.getAnswerBody());
                                            return Mono.just("Correo enviado");
                                        });
                            });

                });
    }
}
