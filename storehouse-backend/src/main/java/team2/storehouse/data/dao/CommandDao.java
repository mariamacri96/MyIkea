package team2.storehouse.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team2.storehouse.data.entities.Command;
import team2.storehouse.data.entities.User;

import java.util.List;

@Repository
public interface CommandDao extends JpaRepository<Command, Long> {
    List<Command> findAllByUser(User user);
}
