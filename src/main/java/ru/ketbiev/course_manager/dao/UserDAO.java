package ru.ketbiev.course_manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ketbiev.course_manager.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
