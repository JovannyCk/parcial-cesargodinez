package org.uniec.parcial.cesargodinez;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * @author Ck
 * DAO es un patron de diseño que sus siglas son
 * Data Acces Objet y sirvenpara acceder a las operaciones CRUD
 * de una tabla atravez de un objeto JAVA previamente mapeado
 */
public class DAOAnimal {
    private static SessionFactory sesionFactory;
    private static Session sesion;
    private static Transaction tranza;
    public DAOAnimal(){
        sesionFactory=HibernateUtilidades.getSessionFactory();
        sesion=sesionFactory.openSession();
        tranza=sesion.beginTransaction();
    }
    public void cerrarTodo(){
        tranza.commit();
        sesion.close();
    }

    public void guardar(Animal a)throws Exception{
        sesion.save(a);
        cerrarTodo();
    }
    public ArrayList<Animal> buscarTodos()throws Exception{
        ArrayList<Animal>animales=(ArrayList<Animal>) sesion.createCriteria(Animal.class).list();
        cerrarTodo();
        return animales;
    }
    public Animal buscarPorId(Integer id)throws Exception{
        Animal a= (Animal) sesion.createCriteria(Animal.class)
                .add(Restrictions.idEq(id)).uniqueResult();
        cerrarTodo();
        return a;
    }
    public void actalizar(Animal a)throws Exception{
        sesion.update(a);
        cerrarTodo();
    }
    public void borrar(Integer id)throws Exception{
        sesion.delete(id);
        cerrarTodo();
    }
}
