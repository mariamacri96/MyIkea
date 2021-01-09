package team2.storehouse.data.service;

import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.entities.Invoice;

public interface InvoiceService {
    Invoice fromOrderToInvoice(CommandDto commandDto);
}
