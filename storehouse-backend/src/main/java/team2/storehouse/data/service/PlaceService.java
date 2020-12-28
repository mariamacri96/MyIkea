package team2.storehouse.data.service;

import team2.storehouse.data.dto.PlaceDto;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.entities.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceService {
    PlaceDto getPlace(Long id);
    List<PlaceDto> getPlaces();
}
