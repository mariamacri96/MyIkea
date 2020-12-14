package team2.storehouse.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.entities.User;
import team2.storehouse.data.service.UserService;
import team2.storehouse.exceptions.WrongPasswordException;

@Service
public class LogIn {

    @Autowired
    private UserService userservice;

    public User verify(String username, String password) {   // can be just a method of userService
        User user = userservice.getUser(username);
        if(user.getPassword() != password) {
            throw new WrongPasswordException(username);
        }
        return user;
    }
}
