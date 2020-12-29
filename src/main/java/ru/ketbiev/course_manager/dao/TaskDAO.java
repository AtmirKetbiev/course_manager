//package ru.ketbiev.course_manager.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import ru.ketbiev.course_manager.entity.Task;
//
//import java.util.List;
//
//public class TaskDAO implements InterfaceDAO<Task> {
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List getAll() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<Task> query = session.createQuery("from Task", Task.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public void save(Task task) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(task);
//    }
//
//    @Override
//    public Task get(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Task task = session.get(Task.class, id);
//        return task;
//    }
//
//    @Override
//    public void delete(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Task task = session.get(Task.class, id);
//        session.delete(task);
//    }
//}
