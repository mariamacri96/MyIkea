package team2.storehouse.data.service.impl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.BillDao;
import team2.storehouse.data.dto.BillDto;
import team2.storehouse.data.entities.Bill;
import team2.storehouse.data.service.BillService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService{
    @Autowired
    BillDao billDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public BillDto addBill(BillDto billDto) {
        Bill bill = modelMapper.map(billDto,Bill.class);
        return modelMapper.map(billDao.save(bill), BillDto.class);
    }

    @Override
    public List<BillDto> getBills() {
        List<Bill> bills =  billDao.findAll();
        return  bills.stream()
                .map(bill -> modelMapper
                        .map(bill, BillDto.class))
                .collect(Collectors.toList());
    }
}
