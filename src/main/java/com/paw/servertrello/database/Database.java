package com.paw.servertrello.database;

import com.paw.servertrello.models.BoardModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Database 
{
    private static SessionFactory sessionFactory;
    static{
        sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();
    }
    public static Session openSession() throws Exception
    {
        return sessionFactory.openSession();
    }

    public static long persist(Object entity) throws Exception {
        Session session = Database.openSession();
        Transaction tx = session.beginTransaction();
        long id = (long) session.save(entity);
        tx.commit();
        session.close();
        return id;
    }

    public static void delete(Class clazz, long id) throws Exception {
        Session session = Database.openSession();
        Transaction tx = session.beginTransaction();
        Object obj= session.load(clazz,id);
        session.delete(obj);
        tx.commit();
        session.close();
    }

    public static void update(Object entity) throws Exception {
        Session session = Database.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        session.close();
    }

    public static <T> T get(Class<T> clazz, long id) throws Exception {
        Session session = Database.openSession();
        Transaction tx = session.beginTransaction();
        T obj = (T) session.get(clazz, id);
        tx.commit();
        session.close();
        return obj;
    }
}
