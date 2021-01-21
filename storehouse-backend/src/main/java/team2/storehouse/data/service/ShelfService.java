package team2.storehouse.data.service;

import team2.storehouse.data.dto.ShelfDto;

import java.util.List;

public interface ShelfService {

    ShelfDto addShelf(ShelfDto shelf);

    List<ShelfDto> getAll();
}
