package com.example.BackPetProject.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.Set;

@Document(value="answers")
public class Answer {

    @Id
    private String id;
    private String userId;
    private String parentId;
    private String answerBody;
    private Integer score;
    private Map<String, Integer> votes;

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
