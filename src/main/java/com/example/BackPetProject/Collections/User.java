package com.example.BackPetProject.Collections;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(value="users")
public class User {

    @Id
    private String id;
    private String userName;
    private String firstNames;
    private String lastNames;
    private String photo;
    private String email;
    private Set<String> favourites;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<String> favourites) {
        this.favourites = favourites;
    }
}
