package com.bubble_dog.Services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bubble_dog.Models.ClienteModel;

public class ClienteService {
    
    /*ATRIBUTOS */
    private SessionFactory factory;

    //Contructores
    public ClienteService() {
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(ClienteModel.class)
        .buildSessionFactory();
    }
    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();

        return session;
    }

    /**
     * Metodo para Agregar clientes
     * @param cliente
     * @return
     */
    public String create(ClienteModel cliente){

        String message = "";
        Session session = openSession();

        try {
            session.persist(cliente);
            session.getTransaction().commit();

            message = "Cliente creado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }

        session.close();
        return message;

    }

    /**
     * Obtener o mostrar cliente X cedula
     * @param cedula
     * @return
     */

    public ClienteModel getClienteByCedula(Long cedula) {
        ClienteModel cliente = new ClienteModel();
        Session session = openSession();
        try {
            cliente = session.find(ClienteModel.class, cedula);
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        session.close();
        return cliente;
    }

    /**
     * Metodo para listar todos los clientes
     * @return
     */
    public List<ClienteModel> obtenerClientes() {
        List<ClienteModel> clientes = new ArrayList<>();
        Session session = openSession();
        try {
            clientes = session.createQuery("from ClienteModel", ClienteModel.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    }

    /**
     * Metodo para Actualizar un cliente
     * @param cliente
     * @return   
    */ 
    public String actualizarCliente(ClienteModel cliente) {
        String message = "";
        Session session = openSession();

        try {
            session.merge(cliente);
            session.getTransaction().commit();
            message = "Cliente actualizado con exito!";
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }

        return message;
    }

    /**
     * Metodo para eliminar un cliente por cedula
     * @param cedula
     * @return
     */
    public String borrarCliente(Long cedula) {
        String message = "";
        Session session = openSession();

        try {
            ClienteModel cliente = getClienteByCedula(cedula);
            session.remove(cliente);
            session.getTransaction().commit();
            message = "Cliente elimado con exito!";
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }

        return message;
    }
}
