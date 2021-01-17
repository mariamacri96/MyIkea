package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.PlaceDao;
import team2.storehouse.data.dto.PlaceDto;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.dto.ShelfDto;
import team2.storehouse.data.entities.Place;
import team2.storehouse.data.entities.Product;
import team2.storehouse.data.entities.Shelf;
import team2.storehouse.data.service.PlaceService;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<PlaceDto> getPlaces() {
        List<Place> places = placeDao.findAll();
        System.out.println(places.toString());
        return places.stream()
                .map(place -> modelMapper
                        .map(place, PlaceDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        placeDao.deleteById(id);
    }

    @Override
    public PlaceDto addPlace(PlaceDto place) {
        Place place1 = new Place();
        place1.setShelf(place.getShelf());
        return modelMapper.map(placeDao.save(place1), PlaceDto.class);

    }

}
