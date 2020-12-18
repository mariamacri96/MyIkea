package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.ProfileDao;
import team2.storehouse.data.dao.ShoppingCartDao;
import team2.storehouse.data.dao.UserDao;
import team2.storehouse.data.dto.ProfileDto;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.Profile;
import team2.storehouse.data.entities.ShoppingCart;
import team2.storehouse.data.entities.User;
import team2.storehouse.data.service.UserService;
import team2.storehouse.exceptions.UserAlredyExistException;
import team2.storehouse.exceptions.UserNotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProfileDao profileDao;

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public UserDto addUser(UserDto userDto, ProfileDto profileDto, User.Type type) {
        User user = modelMapper.map(userDto, User.class);
        user.setProfile(profileDao.save(modelMapper.map(profileDto, Profile.class)));
        user.setType(type);
        user.setShoppingCart(shoppingCartDao.save(new ShoppingCart()));
        return modelMapper.map(userDao.save(user), UserDto.class);
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
