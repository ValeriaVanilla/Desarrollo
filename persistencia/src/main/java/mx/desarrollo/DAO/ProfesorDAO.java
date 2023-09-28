/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.DAO;


import java.util.List;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.persistencia.AbstractDAO;
import mx.desarrollo.persistencia.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;


/**
 *
 * @author Valer
 */
public class ProfesorDAO extends AbstractDAO<Integer, Profesor> {

    public void find(Profesor p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      @Override
    public List<Profesor> findAll() {
        System.out.println("FindAll ----------");
        List<Profesor> objects = null;
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            Query query = HibernateUtil.getSession().createQuery("FROM Profesor AS p ORDER BY p.nombre");
            objects = query.list();

        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return objects;
    }
   
      public List<Integer> findID() {
        System.out.println("FindID ----------");
        List<Integer> objects = null;
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            Query query = HibernateUtil.getSession().createQuery("SELECT p.idProfesor FROM Profesor p");
            objects = query.list();

        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return objects;
    }
      
      
      public List<String> findRFC() {
        System.out.println("FindRFC ----------");
        List<String> objects = null;
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            Query query = HibernateUtil.getSession().createQuery("SELECT p.rfc FROM Profesor p");
            objects = query.list();

        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return objects;
    }
      
    public List<Integer> busquedaE(String b) {
        System.out.println("busquedaE ----------");
        List<Integer> objects = null;
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            Query query = HibernateUtil.getSession().createQuery("SELECT p.Id_Profesor FROM profesor AS p JOiN imparte as i ON p.Id_Profesor = i.Id_PR JOIN unidad_aprendizaje AS ua ON ua.Id_Unidad_Aprendizaje = i.Id_UA WHERE ua.Nombre_Unidad LIKE '" + b+"%'" );
            objects = query.list();

        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return objects;
    }
      
}



