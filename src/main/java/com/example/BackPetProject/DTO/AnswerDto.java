package com.example.BackPetProject.DTO;

import com.example.BackPetProject.Collections.Answer;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnswerDto {

    private String id;
    @NotBlank
    private String userId;
    @NotBlank
    private String parentId;
    @NotBlank
    private String answerBody;
    private Integer score;
    private Map<String, Integer> votes;

    public AnswerDto(){

    }

    public AnswerDto(String id, String userId, String parentId, String answerBody,
                     Integer score){
        this.id = id;
        this.userId = userId;
        this.parentId = parentId;
        this.answerBody = answerBody;
        this.score = score;
        this.votes = new HashMap<>();
    }

    public AnswerDto(String id, String userId, String parentId, String answerBody,
                     Integer score, Map<String, Integer> votes){
        this.id = id;
        this.userId = userId;
        this.parentId = parentId;
        this.answerBody = answerBody;
        this.score = score;
        this.votes = votes;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getParentId() {
        return parentId;
    }

    public String getAnswerBody() {
        return answerBody;
    }

    public Integer getScore() {
        return score;
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

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setAnswerBody(String answerBody) {
        this.answerBody = answerBody;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setVotes(Map<String, Integer> votes) {
        this.votes = votes;
    }
}
