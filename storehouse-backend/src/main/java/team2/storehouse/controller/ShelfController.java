package team2.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.dto.PlaceDto;
import team2.storehouse.data.dto.ShelfDto;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.service.PlaceService;
import team2.storehouse.data.service.ShelfService;

@Controller
@RequestMapping("storehouse")
public class ShelfController {
    @Autowired
    ShelfService shelfService;

    @PostMapping("/shelf/addShelf")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ShelfDto> createNewShelf(@RequestBody ShelfDto shelfDto) {
        return ResponseEntity.ok(shelfService.addShelf(shelfDto));
    }


}
