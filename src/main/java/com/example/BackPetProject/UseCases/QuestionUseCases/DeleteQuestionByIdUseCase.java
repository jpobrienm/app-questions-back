package com.example.BackPetProject.UseCases.QuestionUseCases;

import com.example.BackPetProject.Mappers.QuestionMapper;
import com.example.BackPetProject.Repositories.AnswerRepository;
import com.example.BackPetProject.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class DeleteQuestionByIdUseCase implements DeleteQuestionById{

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public DeleteQuestionByIdUseCase(QuestionRepository questionRepository, AnswerRepository answerRepository){
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }


    @Override
    public Mono<Void> deleteQuestionById(String id) {
        return questionRepository.deleteById(id)
                .and(answerRepository.deleteAllByParentId(id));
    }

}
