//package ru.ketbiev.course_manager.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class ProgressDAO implements InterfaceDAO<Process> {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List getAll() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<Process> query = session.createQuery("from Process", Process.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public void save(Process process) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(process);
//    }
//
//    @Override
//    public Process get(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Process process = session.get(Process.class, id);
//        return process;
//    }
//
//    @Override
//    public void delete(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Process process = session.get(Process.class, id);
//        session.delete(process);
//    }
//}
