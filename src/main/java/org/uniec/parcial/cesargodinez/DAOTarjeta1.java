/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uniec.parcial.cesargodinez;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author ghosbyte
 */
public class DAOTarjeta1 {
    public SessionFactory sessionFactory;
    public Session session;
    public Transaction transaction;
    public DAOTarjeta1(){
        sessionFactory= HibernateUtilidades.getSessionFactory();
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
    }
private void cerrarTodo(){
    transaction.commit();
    session.close();
    }    

public void guardar(Tarjeta1 reservacion) throws Exception{
    session.save(reservacion);
    cerrarTodo();
    }
    
}
