package team2.storehouse.controller;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import team2.storehouse.data.dao.ProductDao;
import team2.storehouse.data.dto.CommandDto;
import team2.storehouse.data.dto.ElementDto;
import team2.storehouse.data.entities.Bill;
import team2.storehouse.data.entities.Category;
import team2.storehouse.data.entities.Invoice;
import team2.storehouse.data.entities.Product;
import team2.storehouse.data.service.InvoiceService;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Element;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("storehouse/api/document")
public class JasperController {
    @Autowired
    InvoiceService invoiceService;


    @PostMapping()
    public void getDocument(HttpServletResponse response, @RequestBody CommandDto commandDto, @RequestParam String nameClient, @RequestParam String addressClient, @RequestParam String paymentMethodClient) throws IOException, JRException, SQLException {
        Connection con = null;
        try {
            //conn
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3307/ikea", "root", "aSz1*x35");

            Invoice invoice = invoiceService.fromOrderToInvoice(commandDto,nameClient,addressClient,paymentMethodClient);

            JasperReport jasperReport = JasperCompileManager.compileReport(JasperFillManager.class.getClassLoader().getResourceAsStream("Invoice.jrxml"));
            HashMap<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("order_id", invoice.getOrder_id());
            parameters.put("order", invoice.getOrder_id());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
        } catch (JRException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }


}