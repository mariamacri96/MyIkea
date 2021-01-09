package team2.storehouse.data.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.ShelfDao;
import team2.storehouse.data.dao.ShoppingCartDao;
import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.dto.ShelfDto;
import team2.storehouse.data.entities.Command;
import team2.storehouse.data.entities.Shelf;
import team2.storehouse.data.service.ShelfService;
import org.modelmapper.ModelMapper;

@Service
public class ShelfServiceImpl implements ShelfService {

    @Autowired
    ShelfDao shelfDao;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public ShelfDto addShelf(ShelfDto shelf) {
        Shelf shelf1 = new Shelf();
        return modelMapper.map(shelfDao.save(shelf1), ShelfDto.class);

    }
}
