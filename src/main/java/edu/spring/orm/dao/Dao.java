package edu.spring.orm.dao;

import edu.spring.orm.entity.Aircraft;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Dao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<Aircraft> listAircraft() {
        final var session = sessionFactory.getCurrentSession();
        return session.createQuery("from Aircraft").list();
    }
}
