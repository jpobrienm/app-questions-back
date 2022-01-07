package com.example.BackPetProject.Mappers;

import com.example.BackPetProject.Collections.User;
import com.example.BackPetProject.DTO.UserDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserMapper {

    public Function<UserDto, User> mapToUser(){
        return userDto -> {
            User user = new User();
            user.setId(userDto.getId());
            user.setUserName(userDto.getUserName());
            user.setPassword(userDto.getPassword());
            user.setEmail(userDto.getEmail());
            return user;
        };
    }

    public Function<User, UserDto> mapToUserDto(){
        return user -> new UserDto(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail()
        );
    }

}
