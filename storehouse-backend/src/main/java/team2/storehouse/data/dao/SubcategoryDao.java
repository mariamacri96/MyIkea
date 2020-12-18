package team2.storehouse.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team2.storehouse.data.entities.Subcategory;

import java.util.Optional;

@Repository
public interface SubcategoryDao extends JpaRepository<Subcategory, Long> {
    Optional<Subcategory> findByName(String name);
}
