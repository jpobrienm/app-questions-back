package com.example.BackPetProject.Mappers;

import com.example.BackPetProject.Collections.Question;
import com.example.BackPetProject.DTO.QuestionDto;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.function.Function;

@Component
public class QuestionMapper {

    public Function<QuestionDto, Question> mapToQuestion(){
        return questionDto -> {
            Question question = new Question();
            question.setId(questionDto.getId());
            question.setUserId(questionDto.getUserId());
            question.setQuestionBody(questionDto.getQuestionBody());
            question.setCategory(questionDto.getCategory());
            question.setTypes(questionDto.getType());
            question.setScore(questionDto.getScore());
            question.setDateOf(questionDto.getDateOf());
            return question;
        };
    }

    public Function<QuestionDto, Question> mapToNewQuestion(){
        return questionDto -> {
            Question question = new Question();
            question.setId(questionDto.getId());
            question.setUserId(questionDto.getUserId());
            question.setQuestionBody(questionDto.getQuestionBody());
            question.setCategory(questionDto.getCategory());
            question.setTypes(questionDto.getType());
            question.setScore(0);
            question.setDateOf(Date.from(Instant.now()));
            return question;
        };
    }

    public Function<Question, QuestionDto> mapToQuestionDto(){
        return question -> new QuestionDto(
                question.getId(),
                question.getUserId(),
                question.getQuestionBody(),
                question.getCategory(),
                question.getTypes(),
                question.getScore(),
                question.getDateOf(),
                question.getVotes()
        );
    }

}
