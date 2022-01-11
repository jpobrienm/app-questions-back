package com.example.BackPetProject.UseCases.AnswerUseCases;

import com.example.BackPetProject.DTO.AnswerDto;
import com.example.BackPetProject.Mappers.AnswerMapper;
import com.example.BackPetProject.Repositories.AnswerRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Service
@Validated
public class FindAllGivenSetOfParentIdUseCase implements FindAllGivenSetOfParentId{

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    public FindAllGivenSetOfParentIdUseCase(AnswerRepository answerRepository, AnswerMapper answerMapper) {
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
    }

    @Override
    public Flux<AnswerDto> findAllGivenSetOfParentId(Set<String> idSet) {
        Flux<AnswerDto> flux = Flux.just();
        for (String id:idSet){
            flux.concat(answerRepository.findAllByParentId(id)
                    .map(answerMapper.mapToAnswerDto()));
        }
        return flux;
    }
}
