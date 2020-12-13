package ru.ketbiev.course_manager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ketbiev.course_manager.entity.Student;

import java.util.List;

public class StudentDAO implements InterfaceDAO<Student> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery("from Student", Student.class);
        return query.getResultList();
    }

    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public Student get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        return student;
    }


    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        session.delete(student);
    }
}
