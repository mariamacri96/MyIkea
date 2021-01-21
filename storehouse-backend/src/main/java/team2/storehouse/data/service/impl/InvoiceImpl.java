package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.InvoiceDao;
import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.dto.ElementDto;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.entities.Bill;
import team2.storehouse.data.entities.Invoice;
import team2.storehouse.data.entities.Product;
import team2.storehouse.data.service.CommandService;
import team2.storehouse.data.service.InvoiceService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InvoiceImpl implements InvoiceService {
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    CommandService commandService;
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    @Override
    public Invoice fromOrderToInvoice(Invoice invoice) {
        double totalOrder = 0.00;
        double iva = 0.22;
        double taxes = 0.0;
        double totalAmountAndTaxes;



        CommandDto commandDto= commandService.findCommandById( invoice.getOrder_id());
        Set<Product> products = new HashSet<Product>();
        for (ElementDto element : commandDto.getElements()
        ) {
            products.add(element.getProduct());
            totalOrder += element.getQuantity() * element.getProduct().getPrice();
            for (int i = 0; i < element.getQuantity(); i++) {
                taxes += element.getProduct().getPrice() * iva;
            }
        }

        totalAmountAndTaxes = totalOrder + taxes;

        //pagamento
        invoice.setStatusPayment(Invoice.Status.COMPLETED);
        invoice.setMethodPayment(Invoice.Method.POSTEPAY);
        invoice.setBankName("Banca Unicredit");

        //fattura
        invoice.setTotalDocument(roundAvoid(totalOrder, 2));
        invoice.setTotalTaxes(roundAvoid(taxes, 2));
        invoice.setTotalTaxable(roundAvoid(totalAmountAndTaxes, 2));
        invoice.setNetToPay(roundAvoid(totalAmountAndTaxes, 2));
        return invoiceDao.save(invoice);


    }

    @Override
    public List< Invoice > all() {
        List<Invoice> invoices = invoiceDao.findAll();
        return invoices;
    }


}
