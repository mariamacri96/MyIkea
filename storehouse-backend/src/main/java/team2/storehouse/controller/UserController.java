package team2.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team2.storehouse.data.dto.UserDto;
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

   /* @PostMapping("/registration/account")
    public ResponseEntity<UserDto> createAccount(@RequestBody UserDto profileDto){
        UserDto userDto=logInService.createAccount(profileDto) ;
        return ResponseEntity.ok(userDto);

    }*/

    @GetMapping("/users")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<List<UserDto>> all(){
        List<UserDto> users= userService.getUsers();
        return ResponseEntity.ok(users);
    }

}
