package team2.storehouse.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import team2.storehouse.data.entities.Invoice;

public interface InvoiceDao extends JpaRepository<Invoice, Long> {

}
