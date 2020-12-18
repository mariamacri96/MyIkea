package team2.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team2.storehouse.data.dto.ProfileDto;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.User;
import team2.storehouse.data.service.UserService;
import team2.storehouse.data.service.impl.LogIn;

import java.util.List;

@Controller
@RequestMapping("storehouse")
public class UserController {

    @Autowired
    LogIn logInService;

    @Autowired
    UserService userService;

    @PostMapping("/users/registration")     // in testing..
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserDto> createAccount(@RequestBody UserDto userDto,
                                                 @RequestBody ProfileDto profileDto,
                                                 @RequestBody User.Type type){ ;
        return ResponseEntity.ok(userService.addUser(userDto, profileDto, type));
    }

    @GetMapping("/users/login")    // works
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserDto> login(@RequestParam(name="username", defaultValue = "marcoBellizzi") String username,
                                         @RequestParam(name="password",defaultValue = "password123") String password){
        return ResponseEntity.ok(logInService.verify(username,password));
    }

    @GetMapping("/users")    // works
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<UserDto>> all(){
        return ResponseEntity.ok(userService.getUsers());
    }

}
