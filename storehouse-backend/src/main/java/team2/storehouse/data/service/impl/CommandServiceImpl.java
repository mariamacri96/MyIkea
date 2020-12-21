package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.*;
import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.dto.ElementDto;
import team2.storehouse.data.dto.ShoppingCartDto;
import team2.storehouse.data.entities.Command;
import team2.storehouse.data.entities.Ordered;
import team2.storehouse.data.entities.PutInside;
import team2.storehouse.data.service.CommandService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    ShoppingCartDao shoppingCartDao;

    @Autowired
    PutInsideDao putInsideDao;

    @Autowired
    CommandDao commandDao;

    @Autowired
    UserDao userDao;

    @Autowired
    OrderedDao orderedDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CommandDto addCommand(ShoppingCartDto shoppingCartDto, Long userId) {
        Command command = new Command();
        command.setUser(userDao.findById(userId).orElseThrow(() -> new RuntimeException("user " + userId + " not found")));
        command.setState(Command.State.TRANSMITTED);
        command = commandDao.save(command);

        CommandDto commandDto = new CommandDto();
        commandDto.setUser(command.getUser());
        commandDto.setState(command.getState());
        for(PutInside putInside : putInsideDao.findAllByShoppingCart(shoppingCartDao.findById(userId).orElseThrow(() -> new RuntimeException("shopping cart " + userId + " not found")))) {
            Ordered ordered = new Ordered();
            ordered.setCommand(command);
            ordered.setProduct(putInside.getProduct());
            ordered.setQuantity(putInside.getQuantity());
            orderedDao.save(ordered);
            putInsideDao.delete(putInside);
            commandDto.getElements().add(new ElementDto(ordered.getProduct(), ordered.getQuantity()));
        }
        return commandDto;
    }

    @Override
    public List<CommandDto> getCommands(Long userId) {
        List<CommandDto> commands = new ArrayList<>();
        for(Command command : commandDao.findAllByUser(userDao.findById(userId).orElseThrow(() -> new RuntimeException("user " + userId + " not found")))) {
            CommandDto commandDto = new CommandDto();
            commandDto.setUser(command.getUser());
            commandDto.setState(command.getState());
            for(Ordered ordered : orderedDao.findAllByCommand(command)) {
                commandDto.getElements().add(new ElementDto(ordered.getProduct(), ordered.getQuantity()));
            }
            commands.add(commandDto);
        }
        return commands;
    }
}
