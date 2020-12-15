package team2.storehouse.data.service;

import team2.storehouse.data.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);
    UserDto getUser(String username);
    //UserDto getUserByEmail(String email);
    List<UserDto> getUsers();

}
