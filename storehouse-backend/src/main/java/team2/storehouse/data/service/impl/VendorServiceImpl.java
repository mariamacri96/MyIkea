package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.VendorDao;
import team2.storehouse.data.dto.VendorDto;
import team2.storehouse.data.entities.Vendor;
import team2.storehouse.data.service.VendorService;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    VendorDao vendorDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public VendorDto getVendor(String name) {
        return modelMapper.map(vendorDao.findByName(name).orElseThrow(
                () -> new RuntimeException("vendor " + name + " not found")), VendorDto.class);
    }

    @Override
    public List<String> getVendorsName() {
        List<Vendor> vendors = vendorDao.findAll();
        List<String> names = new ArrayList<>();
        for(Vendor vend : vendors) {
            names.add(vend.getName());
        }
        return names;
    }
}
