package team2.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team2.storehouse.data.dto.AccountDto;
import team2.storehouse.data.dto.ProfileDto;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.User;
import team2.storehouse.data.service.UserService;

import java.util.List;

@Controller
@RequestMapping("storehouse")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/registration")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        UserDto userDto = accountDto.getUserDto();
        ProfileDto profileDto = accountDto.getProfileDto();
        userService.addUser(userDto, profileDto);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/users/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserDto> login(@RequestParam(name="username", defaultValue = "marcoBellizzi") String username,
                                         @RequestParam(name="password",defaultValue = "password123") String password){
        return ResponseEntity.ok(userService.verify(username,password));
    }

    @GetMapping("/users")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<UserDto>> all(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @DeleteMapping("/user/delete")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity deleteUser (@RequestParam(name = "id") Long id) {
        System.out.println(id);
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/user/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.updateUser(userDto));
    }

}
