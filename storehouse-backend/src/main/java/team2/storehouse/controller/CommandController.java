package team2.storehouse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.dto.ShoppingCartDto;
import team2.storehouse.data.service.CommandService;

import java.util.List;

@Controller
@RequestMapping("storehouse")
public class CommandController {

    @Autowired
    CommandService commandService;

    @PostMapping("/command/add/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CommandDto> addCommand(@RequestBody ShoppingCartDto shoppingCartDto,
                                                 @PathVariable(name = "id") Long userId) {
        return ResponseEntity.ok(commandService.addCommand(shoppingCartDto, userId));

    }

    @GetMapping("/commands/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<CommandDto>> getCommands(@PathVariable(name = "id") Long userId) {
        return ResponseEntity.ok(commandService.getCommands(userId));
    }

}
