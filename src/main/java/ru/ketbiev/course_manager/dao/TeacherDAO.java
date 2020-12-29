//package ru.ketbiev.course_manager.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import ru.ketbiev.course_manager.entity.Teacher;
//
//import java.util.List;
//
//@Repository
//public class TeacherDAO implements InterfaceDAO<Teacher> {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List<Teacher> getAll() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<Teacher> query = session.createQuery("from Teacher", Teacher.class);
//        System.out.println(query);
//        return query.getResultList();
//    }
//
//    @Override
//    public void save(Teacher teacher) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(teacher);
//    }
//
//    @Override
//    public Teacher get(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Teacher teacher = session.get(Teacher.class, id);
//        return teacher;
//    }
//
//    @Override
//    public void delete(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Teacher teacher = session.get(Teacher.class, id);
//        session.delete(teacher);
//    }
//}
//
//
//
