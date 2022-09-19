package com.bubble_dog.Services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bubble_dog.Models.UserModel;

public class UserServices {
    
    // Atributos abrimos una session de la BD
    private SessionFactory factory;

    public UserServices () {
        factory = new Configuration()
            .configure("cfg.xml")
            .addAnnotatedClass(UserModel.class)
            .buildSessionFactory();
    }

    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();

        return session;
    }

    public StatusService create(UserModel newUser) {
        Session session = openSession();

        try {
            session.persist(newUser);
            session.getTransaction().commit();
            
            session.close();
            return StatusService.USER_CREATED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StatusService.USER_ALREADY_EXISTS;
    }
}
