package com.example.BackPetProject.UseCases.AnswerUseCases;

import com.example.BackPetProject.Collections.Answer;
import com.example.BackPetProject.Mappers.AnswerMapper;
import com.example.BackPetProject.Repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class DeleteAnswerByIdUseCase implements DeleteAnswerById{

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    @Autowired
    public DeleteAnswerByIdUseCase(AnswerRepository answerRepository, AnswerMapper answerMapper){
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
    }

    @Override
    public Mono<Void> deleteAnswerById(String id) {
        return answerRepository.deleteById(id);
    }
}
