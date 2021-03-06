package team2.storehouse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team2.storehouse.data.dto.BillDto;
import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.service.CommandService;

import java.util.List;

@Controller
@RequestMapping("storehouse")
public class CommandController {

    @Autowired
    CommandService commandService;

    @PostMapping("/command/create/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CommandDto> createEmptyCommand(@PathVariable(name = "id") Long userId) {
        return ResponseEntity.ok(commandService.createEmptyCommand(userId));
    }
    @PostMapping("/command/placeOrder")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CommandDto> placeNewOrder(@RequestBody CommandDto commandDto) {
        return ResponseEntity.ok(commandService.placeCommand(commandDto));
    }

    @PostMapping("/command/createFromSC/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CommandDto> createCommandFromShoppingCart(@PathVariable(name = "id") Long userId) {
        return ResponseEntity.ok(commandService.createCommandFromShoppingCart(userId));
    }

    @GetMapping("/commands/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<CommandDto>> getCommands(@PathVariable(name = "id") Long userId) {
        return ResponseEntity.ok(commandService.getCommands(userId));
    }

    @GetMapping("/commands")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<CommandDto>> getCommands() {
        return ResponseEntity.ok(commandService.getCommands());
    }

    @PutMapping("/command/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CommandDto> updateCommand(@RequestBody CommandDto commandDto) {
        return ResponseEntity.ok(commandService.updateCommand(commandDto));
    }
    @GetMapping("/command/confirmPayment")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CommandDto> confirmCommandPayment(@RequestParam(name = "commandId") Long commandId) {
        return ResponseEntity.ok(commandService.confirmCommandPayment(commandId));
    }
    @PostMapping("/command/confirm")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<BillDto> confirmCommand(@RequestParam(name = "commandId") Long commandId) {
        return ResponseEntity.ok(commandService.confirmCommand(commandId));
    }

    @DeleteMapping("/command/delete")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity delete(@RequestParam(name = "commandId") Long commandId) {
        commandService.deleteCommand(commandId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/command/close")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CommandDto> close(@RequestParam(name = "commandId") Long commandId) {
        return ResponseEntity.ok(commandService.closeCommand(commandId));
    }


}
