//package ru.ketbiev.course_manager.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import ru.ketbiev.course_manager.dao.TeacherDAO;
//import ru.ketbiev.course_manager.entity.Teacher;
//
//import java.util.List;
//
//@Service
//public class TeacherService implements InterfaceService<Teacher> {
//
//    @Autowired
//    TeacherDAO teacherDAO;
//
//    @Override
//    @Transactional
//    public List<Teacher> getAll() {
//        return teacherDAO.getAll();
//    }
//
//    @Override
//    @Transactional
//    public void save(Teacher teacher) {
//
//    }
//
//    @Override
//    @Transactional
//    public Teacher get(int id) {
//        return null;
//    }
//
//    @Override
//    @Transactional
//    public void delete(int id) {
//
//    }
//}
