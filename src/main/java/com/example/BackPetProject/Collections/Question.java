package com.example.BackPetProject.Collections;

import com.example.BackPetProject.Enums.Categories;
import com.example.BackPetProject.Enums.Types;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;
import java.util.Set;

@Document(value="questions")
public class Question {

    @Id
    private String id;
    private String userId;
    private String questionBody;
    private Categories category;
    private Types type;
    private Integer score;
    private Date dateOf;
    private Map<String, Integer> votes;

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

    public Types getTypes() {
        return type;
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

    public void setTypes(Types types) {
        this.type = types;
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
