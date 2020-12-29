package ru.ketbiev.course_manager.service;

import org.springframework.transaction.annotation.Transactional;
import ru.ketbiev.course_manager.entity.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
