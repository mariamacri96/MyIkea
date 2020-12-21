package team2.storehouse.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team2.storehouse.data.entities.Command;
import team2.storehouse.data.entities.Ordered;

import java.util.List;

@Repository
public interface OrderedDao extends JpaRepository<Ordered, Long> {
    List<Ordered> findAllByCommand(Command command);
}
