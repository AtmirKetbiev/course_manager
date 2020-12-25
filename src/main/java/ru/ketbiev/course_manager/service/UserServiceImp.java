package ru.ketbiev.course_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
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

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getOne(1L));
        user.setRoles(roles);
        userDAO.save(user);
    }

    @Override
    public User findByUsername(String username) {
        System.out.println("UserService 1");
        System.out.println(username);
        User a = userDAO.findByUsername(username);
        System.out.println(a.getUsername());
        return a;
    }
}
