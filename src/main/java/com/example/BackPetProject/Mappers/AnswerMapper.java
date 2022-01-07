package com.example.BackPetProject.Mappers;

import com.example.BackPetProject.Collections.Answer;
import com.example.BackPetProject.DTO.AnswerDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AnswerMapper {

    public Function<AnswerDto, Answer> mapToAnswer(){
        return answerDto -> {
            Answer answer = new Answer();
            answer.setId(answerDto.getId());
            answer.setUserId(answerDto.getUserId());
            answer.setParentId(answerDto.getParentId());
            answer.setAnswerBody(answerDto.getAnswerBody());
            answer.setScore(answerDto.getScore());
            return answer;
        };
    }

    public Function<AnswerDto, Answer> mapToNewAnswer(){
        return answerDto -> {
            Answer answer = new Answer();
            answer.setId(answerDto.getId());
            answer.setUserId(answerDto.getUserId());
            answer.setParentId(answerDto.getParentId());
            answer.setAnswerBody(answerDto.getAnswerBody());
            answer.setScore(0);
            return answer;
        };
    }


    public Function<Answer, AnswerDto> mapToNewAnswerDto(){
        return answer -> new AnswerDto(
                answer.getId(),
                answer.getUserId(),
                answer.getParentId(),
                answer.getAnswerBody(),
                answer.getScore()
        );
    }

    public Function<Answer, AnswerDto> mapToAnswerDto(){
        return answer -> new AnswerDto(
                answer.getId(),
                answer.getUserId(),
                answer.getParentId(),
                answer.getAnswerBody(),
                answer.getScore(),
                answer.getVotes()
        );
    }
}
