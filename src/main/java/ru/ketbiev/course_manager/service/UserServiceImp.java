package ru.ketbiev.course_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ketbiev.course_manager.dao.RoleDAO;
import ru.ketbiev.course_manager.dao.UserDAO;
import ru.ketbiev.course_manager.entity.Role;
import ru.ketbiev.course_manager.entity.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(user.getPassword());
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.findOne(1L));
        user.setRoles(roles);
        userDAO.saveAndFlush(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
