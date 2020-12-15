package team2.storehouse.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dto.ProfileDto;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.User;
import team2.storehouse.data.service.UserService;
import team2.storehouse.exceptions.UserAlredyExistException;
import team2.storehouse.exceptions.WrongPasswordException;

@Service
public class LogIn {

    @Autowired
    private UserService userservice;


    public UserDto createAccount(UserDto profileDto) {
        UserDto userDto = userservice.getUserByEmail(profileDto.getEmail());
        return userservice.addUser(profileDto);
    }

    public UserDto verify(String username, String password) {   // can be just a method of userService
        UserDto userDto = userservice.getUser(username);
        if(userDto.getPassword() != password) {
            throw new WrongPasswordException(username);
        }
        return userDto;
    }
}
