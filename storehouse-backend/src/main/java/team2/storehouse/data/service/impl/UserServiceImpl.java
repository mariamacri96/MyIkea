package team2.storehouse.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.UserDao;
import team2.storehouse.data.entities.User;
import team2.storehouse.data.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {    // in theory we better use DTO, maybe later

    @Autowired
    private UserDao userDao;

    @Transactional    // add it in methods that write in the database
    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }
}
