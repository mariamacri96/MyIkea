package team2.storehouse.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team2.storehouse.data.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
