package team2.storehouse.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team2.storehouse.data.entities.Vendor;

import java.util.Optional;

@Repository
public interface VendorDao extends JpaRepository<Vendor, Long> {
    Optional<Vendor> findByName(String name);
}
