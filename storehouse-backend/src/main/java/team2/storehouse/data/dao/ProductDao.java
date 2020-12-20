package team2.storehouse.data.dao;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import team2.storehouse.data.entities.Product;
import team2.storehouse.data.entities.Subcategory;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    class Filter {
        private String name;
        private String brand;
        private String color;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    //cerca in base al nome
    Optional<Product> findProductByName(String name);

    //cerca in base al nome
    default Specification<Product> hasName(String name) {
        return (product, cq, cb) -> cb.equal(product.get("name"), name);
    }

    //cerca in base alla sottocategoria
    default Specification<Product> filterBySubCategory(String name) {
        return (Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
            root.join("subcategory");

            CriteriaQuery<?> cq = criteriaQuery.where(criteriaBuilder.or(root.get("subcategory").isNull(),
                    criteriaBuilder.equal(root.get("subcategory").get("name"), name)));
            return (Predicate) cq;


        };
    }


    //cerca in base a brand,color,name ritorna i risultati raggruppati e ordinati per nome prodotto
    default Specification<Product> withFilter(Filter filter) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (filter.getName() != null)
                    predicates.add(criteriaBuilder.equal(root.get("name"), filter.getName()));
                if (filter.getBrand() != null)
                    predicates.add(criteriaBuilder.equal(root.get("brand"), filter.getBrand()));
                if (filter.getColor() != null)
                    predicates.add(criteriaBuilder.equal(root.get("color"), filter.getColor()));

                if (predicates.isEmpty())
                    predicates.add(criteriaBuilder.equal(root.get("id"), -1L));

                return criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])))//
                        .distinct(true) //
                        .orderBy(criteriaBuilder.desc(root.get("name")))//
                        .getRestriction();
            }
        };
    }


}
