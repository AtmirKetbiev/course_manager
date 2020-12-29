package ru.ketbiev.course_manager.service;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);

}
