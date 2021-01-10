package team2.storehouse.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.InvoiceDao;
import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.dto.ElementDto;
import team2.storehouse.data.entities.Bill;
import team2.storehouse.data.entities.Invoice;
import team2.storehouse.data.entities.Product;
import team2.storehouse.data.service.InvoiceService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InvoiceImpl implements InvoiceService {
    @Autowired
    InvoiceDao invoiceDao;

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    @Override
    public Invoice fromOrderToInvoice(CommandDto commandDto,String nameClient,String addressClient,String paymentMethod) {
        double totalOrder = 0.00;
        double iva = 0.22;
        double taxes = 0.0;
        double totalAmountAndTaxes;
        Invoice invoice = new Invoice();
        invoice.setOrder_id(commandDto.getId());

        List<ElementDto> list = commandDto.getElements();
        Set<Product> products = new HashSet<Product>();
        for (ElementDto element : list
        ) {
            products.add(element.getProduct());
            totalOrder += element.getQuantity() * element.getProduct().getPrice();
            for (int i = 0; i < element.getQuantity(); i++) {
                taxes += element.getProduct().getPrice() * iva;
            }
        }

        totalAmountAndTaxes = totalOrder + taxes;
        //invoice where order_id=id
        Long id = commandDto.getId();
        invoice.setOrder_id(id);
        invoice.setProductList(products);




        //user
        invoice.setUserName(nameClient);
        //invoice.setUserVATNumber("09032310154");
        invoice.setUserAddress(addressClient);
       // invoice.setUserCap(commandDto.getUser().getProfile().getCap());
        //invoice.setUserCity(commandDto.getUser().getProfile().getCity());
        //invoice.setUserProvince(commandDto.getUser().getProfile().getProvince());
        //pagamento
        invoice.setStatusPayment(Invoice.Status.COMPLETED);
        invoice.setMethodPayment(Invoice.Method.CASH);
        invoice.setBankName("Banca dal Fucino2");
        invoice.setDate(LocalDate.now());
        invoice.setIban("IT19F031240321000000231647");
        //fattura
        invoice.setTotal(roundAvoid(totalOrder, 2));
        invoice.setTaxes(roundAvoid(taxes, 2));
        invoice.setTotalTaxable(roundAvoid(totalAmountAndTaxes, 2));
        invoice.setNetToPay(roundAvoid(totalAmountAndTaxes, 2));
        return invoiceDao.save(invoice);


    }
}
