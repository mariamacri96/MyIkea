package team2.storehouse.data.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import team2.storehouse.data.entities.Category;

@Repository
public interface CategoryDao extends PagingAndSortingRepository<Category, Category>,JpaRepository<Category, Category> {
    //Page<Category> findAll(Specification<Category>spec,Pageable pageable);

}
