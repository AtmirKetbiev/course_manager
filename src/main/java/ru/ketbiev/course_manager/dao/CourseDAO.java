//package ru.ketbiev.course_manager.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import ru.ketbiev.course_manager.entity.Course;
//
//import java.util.List;
//
//public class CourseDAO implements InterfaceDAO<Course> {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List<Course> getAll() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<Course> query = session.createQuery("from Course", Course.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public void save(Course course) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(course);
//    }
//
//    @Override
//    public Course get(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Course course = session.get(Course.class, id);
//        return course;
//    }
//
//    @Override
//    public void delete(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Course course = session.get(Course.class, id);
//        session.delete(course);
//    }
//}
