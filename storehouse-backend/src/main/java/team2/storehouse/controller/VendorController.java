package team2.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team2.storehouse.data.dto.VendorDto;
import team2.storehouse.data.service.VendorService;

import java.util.List;

@Controller
@RequestMapping("storehouse")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @GetMapping("/vendor")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<VendorDto> getVendor(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(vendorService.getVendor(name));
    }

    @GetMapping("/vendorsName")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<String>> getVendorName() {
        return ResponseEntity.ok(vendorService.getVendorsName());
    }
}
