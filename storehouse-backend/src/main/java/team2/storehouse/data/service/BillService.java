package team2.storehouse.data.service;

import team2.storehouse.data.dto.BillDto;
import team2.storehouse.data.entities.Bill;

import java.util.List;

public interface BillService {
    BillDto addBill(BillDto billDto);
    List<BillDto> getBills();
}
