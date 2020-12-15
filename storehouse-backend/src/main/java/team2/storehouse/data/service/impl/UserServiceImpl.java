package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.UserDao;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.User;
import team2.storehouse.data.service.UserService;
import team2.storehouse.exceptions.UserAlredyExistException;
import team2.storehouse.exceptions.UserNotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {    // in theory we better use DTO, maybe later

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional// add it in methods that write in the database
    @Override
    public UserDto addUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User user1 =  userDao.save(user);
        UserDto userDto1 = modelMapper.map(user, UserDto.class);
        return userDto1 ;

    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userDao.findAll();
        return users.stream()
                .map(user -> modelMapper
                        .map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUser(String username) {
        User user = userDao.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
        UserDto userDto =modelMapper.map(user, UserDto.class);
        return userDto;
    }
    /*
    @Override
    public UserDto getUserByEmail(String email) {
        Optional<User> user = null;
        if(emailValidator(email))
        {
            throw new UserAlredyExistException(email);
        }

    }

    public boolean emailValidator( String email){

        boolean isPresent = true;
        Optional<User> user = userDao.findByEmail(email);
        if(user.isEmpty())
            isPresent = false;

        return isPresent;


    }*/
}
