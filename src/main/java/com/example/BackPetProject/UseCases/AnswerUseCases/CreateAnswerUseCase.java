package com.example.BackPetProject.UseCases.AnswerUseCases;

import com.example.BackPetProject.DTO.AnswerDto;
import com.example.BackPetProject.Mappers.AnswerMapper;
import com.example.BackPetProject.Repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateAnswerUseCase implements CreateAnswer{

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    @Autowired
    public CreateAnswerUseCase(AnswerRepository answerRepository, AnswerMapper answerMapper){
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
    }


    @Override
    public Mono<AnswerDto> createAnswer(AnswerDto answerDto) {
        return answerRepository.save(answerMapper.mapToNewAnswer().apply(answerDto))
                .map(answerMapper.mapToAnswerDto());
    }
}
