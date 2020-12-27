package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.PlaceDao;
import team2.storehouse.data.dto.PlaceDto;
import team2.storehouse.data.entities.Place;
import team2.storehouse.data.service.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceDao placeDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PlaceDto getPlace(Long id) {
        return modelMapper.map(placeDao.findById(id).orElseThrow(
                () -> new RuntimeException("place " + id + " not found")), PlaceDto.class);
    }
}
