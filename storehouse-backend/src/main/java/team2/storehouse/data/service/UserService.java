package team2.storehouse.data.service;

import team2.storehouse.data.dto.ProfileDto;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.Profile;
import team2.storehouse.data.entities.User;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto, ProfileDto profile);
    UserDto getUser(String username);
    UserDto verify(String username, String password);
    List<UserDto> getUsers();
    void deleteUser(Long id);
    UserDto updateUser(UserDto userDto);

}
