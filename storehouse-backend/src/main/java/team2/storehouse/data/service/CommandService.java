package team2.storehouse.data.service;

import team2.storehouse.data.dto.BillDto;
import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.dto.ShoppingCartDto;

import java.util.List;

public interface CommandService {
    CommandDto createEmptyCommand(Long userId);
    CommandDto createCommandFromShoppingCart(Long userId);
    CommandDto updateCommand(CommandDto commandDto);
    BillDto confirmCommand(Long commandId);
    List<CommandDto> getCommands(Long userId);
    void deleteCommand(Long commandId);
}
