package team2.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team2.storehouse.data.dto.PlaceDto;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.service.PlaceService;

import java.util.List;

@Controller
@RequestMapping("storehouse")
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @GetMapping("/places")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<PlaceDto>> all() {
        List<PlaceDto> places = placeService.getPlaces();
        return ResponseEntity.ok(places);
    }

    @GetMapping("/place")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<PlaceDto> getPlace(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(placeService.getPlace(id));
    }

    @DeleteMapping("/place/delete")
    public ResponseEntity delete (@RequestParam(name = "id") Long id) {
        placeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
