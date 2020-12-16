package team2.storehouse.data.service;

import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.Profile;
import team2.storehouse.data.entities.User;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto, Profile profile, User.Type type);
    UserDto getUser(String username);
    //UserDto getUserByEmail(String email);
    List<UserDto> getUsers();

}
