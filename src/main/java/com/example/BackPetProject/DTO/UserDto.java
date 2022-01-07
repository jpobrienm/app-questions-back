package com.example.BackPetProject.DTO;

import javax.validation.constraints.NotBlank;

public class UserDto {

    private String id;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @NotBlank
    private String email;


    public UserDto(){

    }

    public UserDto(String id, String userName, String password, String email){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public UserDto(String userName, String password, String email){
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
