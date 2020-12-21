package team2.storehouse.data.service;

import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.dto.ShoppingCartDto;

import java.util.List;

public interface CommandService {
    CommandDto addCommand(ShoppingCartDto shoppingCartDto, Long userId);
    List<CommandDto> getCommands(Long userId);
}
