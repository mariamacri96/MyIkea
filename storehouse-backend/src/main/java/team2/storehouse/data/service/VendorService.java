package team2.storehouse.data.service;

import team2.storehouse.data.dto.VendorDto;

import java.util.List;

public interface VendorService {
    VendorDto getVendor(String name);
    List<String> getVendorsName();
}
