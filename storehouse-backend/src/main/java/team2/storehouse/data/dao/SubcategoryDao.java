package team2.storehouse.data.dao;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import team2.storehouse.data.entities.Product;
import team2.storehouse.data.entities.Subcategory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubcategoryDao extends JpaRepository<Subcategory, Long> , JpaSpecificationExecutor<Subcategory> {
    Optional<Subcategory> findByName(String name);

    public static Specification<Subcategory> findByCategory(Long id) {
        return (Root<Subcategory> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
            root.join("category");
            CriteriaQuery<?> cq = criteriaQuery.where(criteriaBuilder.equal(root.get("category").get("id"), id));
            return cq.getRestriction();
        };
    }

}
