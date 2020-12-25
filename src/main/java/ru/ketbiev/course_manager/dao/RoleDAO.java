package ru.ketbiev.course_manager.dao;

import org.springframework.stereotype.Repository;
import ru.ketbiev.course_manager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RoleDAO extends JpaRepository<Role,Long> {
}
