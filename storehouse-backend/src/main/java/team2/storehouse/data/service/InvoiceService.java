package team2.storehouse.data.service;

import org.springframework.web.bind.annotation.RequestParam;
import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.entities.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice fromOrderToInvoice(Invoice invoice);
    List< Invoice > all();
}
