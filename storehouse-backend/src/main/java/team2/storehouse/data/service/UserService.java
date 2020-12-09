package team2.storehouse.data.service;

import team2.storehouse.data.entities.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getUsers();
}
