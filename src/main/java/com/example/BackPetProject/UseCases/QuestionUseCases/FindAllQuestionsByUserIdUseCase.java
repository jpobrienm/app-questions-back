package com.example.BackPetProject.UseCases.QuestionUseCases;

import com.example.BackPetProject.DTO.QuestionDto;
import com.example.BackPetProject.Mappers.QuestionMapper;
import com.example.BackPetProject.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class FindAllQuestionsByUserIdUseCase implements FindAllQuestionsByUserId{

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Autowired
    public FindAllQuestionsByUserIdUseCase(QuestionRepository questionRepository, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }

    @Override
    public Flux<QuestionDto> findAllByUserId(String id) {
        return questionRepository.findAllByUserId(id)
                .map(questionMapper.mapToQuestionDto());
    }
}
