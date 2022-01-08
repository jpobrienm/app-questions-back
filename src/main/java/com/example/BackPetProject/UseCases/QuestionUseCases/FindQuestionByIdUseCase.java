package com.example.BackPetProject.UseCases.QuestionUseCases;

import com.example.BackPetProject.DTO.QuestionDto;
import com.example.BackPetProject.Mappers.QuestionMapper;
import com.example.BackPetProject.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class FindQuestionByIdUseCase implements FindQuestionById{

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Autowired
    public FindQuestionByIdUseCase(QuestionRepository questionRepository, QuestionMapper questionMapper){
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }


    @Override
    public Mono<QuestionDto> findQuestionById(String id) {
        return questionRepository.findById(id)
                .map(questionMapper.mapToQuestionDto());
    }
}
