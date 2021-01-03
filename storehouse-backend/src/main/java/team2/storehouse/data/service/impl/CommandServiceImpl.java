package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.*;
import team2.storehouse.data.dto.BillDto;
import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.dto.ElementDto;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.entities.Bill;
import team2.storehouse.data.entities.User;
import team2.storehouse.data.entities.Command;
import team2.storehouse.data.entities.Ordered;
import team2.storehouse.data.entities.PutInside;
import team2.storehouse.data.service.CommandService;

import java.time.LocalDate;
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
    BillDao billDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CommandDto createEmptyCommand(Long userId) {
        Command command = new Command();
        command.setUser(userDao.findById(userId).orElseThrow(() -> new RuntimeException("user " + userId + " not found")));
        command.setState(Command.State.NOT_TRANSMITTED);
        return modelMapper.map(commandDao.save(command), CommandDto.class);
    }
    @Override
    public CommandDto placeCommand(CommandDto commandDto){
        Command command= modelMapper.map(commandDto,Command.class);
        command.setState(Command.State.TRANSMITTED);
        command.setUser(userDao.findByUsername(commandDto.getUser().getUsername()).orElseThrow(() -> new RuntimeException("user "  + " not found")));
        command=commandDao.save(command);
        for (ElementDto element: commandDto.getElements()
             ) {
            Ordered ordered = new Ordered();
            ordered.setCommand(command);
            ordered.setQuantity(element.getQuantity());
            ordered.setProduct(element.getProduct());
            orderedDao.save(ordered);

        }
        commandDto =modelMapper.map(commandDao.save(command), CommandDto.class);
        commandDto.setElementsfromOrdered(orderedDao.findAllByCommand(command));
        return commandDto;
    }

    @Override
    public CommandDto createCommandFromShoppingCart(Long userId) {
        Command command = new Command();
        command.setUser(userDao.findById(userId).orElseThrow(() -> new RuntimeException("user " + userId + " not found")));
        command.setState(Command.State.TRANSMITTED);
        command = commandDao.save(command);

        CommandDto commandDto = new CommandDto();
        commandDto.setId(command.getId());
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
    public List<CommandDto> getCommands() {
        List<CommandDto> commands = new ArrayList<>();
        for(Command command : commandDao.findAll()) {
            CommandDto commandDto = new CommandDto();
            commandDto.setId(command.getId());
            commandDto.setUser(command.getUser());
            commandDto.setState(command.getState());
            for(Ordered ordered : orderedDao.findAllByCommand(command)) {
                commandDto.getElements().add(new ElementDto(ordered.getProduct(), ordered.getQuantity()));
            }
            commands.add(commandDto);
        }
        return commands;
    }

    @Override
    public List<CommandDto> getCommands(Long userId) {
        List<CommandDto> commands = new ArrayList<>();
        for(Command command : commandDao.findAllByUser(userDao.findById(userId).orElseThrow(() -> new RuntimeException("user " + userId + " not found")))) {
            CommandDto commandDto = new CommandDto();
            commandDto.setId(command.getId());
            commandDto.setUser(command.getUser());
            commandDto.setState(command.getState());
            for(Ordered ordered : orderedDao.findAllByCommand(command)) {
                commandDto.getElements().add(new ElementDto(ordered.getProduct(), ordered.getQuantity()));
            }
            commands.add(commandDto);
        }
        return commands;
    }

    @Override
    public CommandDto updateCommand(CommandDto commandDto) {
        Command command = commandDao.findById(commandDto.getId()).orElseThrow(() -> new RuntimeException("command " + commandDto.getId() + " not found"));
        command.setState(commandDto.getState());
        commandDao.save(command);

        for(Ordered ordered : orderedDao.findAllByCommand(command)) {
            orderedDao.delete(ordered);
        }
        for(ElementDto elementDto : commandDto.getElements()) {
            Ordered ordered = new Ordered();
            ordered.setCommand(command);
            ordered.setProduct(elementDto.getProduct());
            ordered.setQuantity(elementDto.getQuantity());
            orderedDao.save(ordered);
        }
        return commandDto;
    }
    public CommandDto confirmCommandPayment(Long commandId) {
        Command command = commandDao.findById(commandId).orElseThrow(() -> new RuntimeException("command " + commandId + " not found"));
        command.setState(Command.State.CONFIRMED);
        CommandDto commandDto = modelMapper.map(commandDao.save(command), CommandDto.class);
        commandDto.setElementsfromOrdered(orderedDao.findAllByCommand(command));
        return commandDto;
    }
    @Override
    public BillDto confirmCommand(Long commandId) {
        Command command = commandDao.findById(commandId).orElseThrow(() -> new RuntimeException("command " + commandId + " not found"));
        command.setState(Command.State.CONFIRMED);
        commandDao.save(command);

        BillDto billDto = new BillDto();
        billDto.setCommand(command);
        billDto.setDate(LocalDate.of(2020, 12, 22));  // retrieve it dynamically

        double total = 0;
        for(Ordered ordered : orderedDao.findAllByCommand(command)) {
            billDto.getElements().add(new ElementDto(ordered.getProduct(), ordered.getQuantity()));
            total += ordered.getProduct().getPrice() * ordered.getQuantity();
        }
        billDto.setTotal(total);

        Bill bill = billDao.save(modelMapper.map(billDto, Bill.class));
        billDto.setId(bill.getId());
        return billDto;
    }

    @Override
    public void deleteCommand(Long commandId) {
        Command command = commandDao.findById(commandId).orElseThrow(() -> new RuntimeException("command " + commandId + " not found"));
        for(Ordered ordered : orderedDao.findAllByCommand(command)) {
            orderedDao.delete(ordered);
        }
        commandDao.delete(command);
    }
}
