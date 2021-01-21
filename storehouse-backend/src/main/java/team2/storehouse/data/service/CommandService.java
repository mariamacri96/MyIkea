package team2.storehouse.data.service;

import team2.storehouse.data.dto.BillDto;
import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.dto.ShoppingCartDto;

import java.util.List;

public interface CommandService {
    CommandDto createEmptyCommand(Long userId);
    CommandDto createCommandFromShoppingCart(Long userId);
    CommandDto placeCommand(CommandDto commandDto);
    CommandDto updateCommand(CommandDto commandDto);
    CommandDto confirmCommandPayment(Long commandId);
    BillDto confirmCommand(Long commandId);
    List<CommandDto> getCommands(Long userId);
    List<CommandDto> getCommands();
    void deleteCommand(Long commandId);
    CommandDto closeCommand(Long commandId);
    CommandDto findCommandById(Long id);

}
