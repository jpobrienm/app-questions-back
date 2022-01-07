package com.example.BackPetProject.DTO;

import com.example.BackPetProject.Enums.Categories;
import jdk.jfr.Category;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import javax.validation.constraints.NotBlank;
import java.util.*;

public class QuestionDto {

    private String id;
    @NotBlank
    private String userId;
    @NotBlank
    private String questionBody;
    @NotBlank
    private Categories category;
    private Integer score;
    @NotBlank
    private Date dateOf;
    private Map<String, Integer> votes;

    public QuestionDto(){

    }

    public QuestionDto(String id, String userId, String body, Categories category, Integer score, Date dateOf){
        this.id = id;
        this.userId = userId;
        this.questionBody = body;
        this.category = category;
        this.score = score;
        this.dateOf = dateOf;
        this.votes = new HashMap<>();
    }

    public QuestionDto(String id, String userId, String body, Categories category, Integer score,
                       Date dateOf, Map<String, Integer> votes){
        this.id = id;
        this.userId = userId;
        this.questionBody = body;
        this.category = category;
        this.score = score;
        this.dateOf = dateOf;
        this.votes = votes;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public Categories getCategory() {
        return category;
    }

    public Integer getScore() {
        return score;
    }

    public Date getDateOf() {
        return dateOf;
    }

    public Map<String, Integer> getVotes() {
        return votes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setDateOf(Date dateOf) {
        this.dateOf = dateOf;
    }

    public void setVotes(Map<String, Integer> votes) {
        this.votes = votes;
    }
}
