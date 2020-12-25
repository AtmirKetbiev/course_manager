package ru.ketbiev.course_manager.service;

import ru.ketbiev.course_manager.entity.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
