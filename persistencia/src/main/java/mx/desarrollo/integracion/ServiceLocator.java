/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.integracion;

import mx.desarrollo.DAO.ProfesorDAO;
import mx.desarrollo.DAO.UnidadAprendizajeDAO;


/**
 *
 * @author total
 */
public class ServiceLocator {
    
 
    private static ProfesorDAO profesorDAO;
    private static UnidadAprendizajeDAO unidadaprendizajeDAO;
    
    /**
     * se crea la instancia de ProfesorDAO si esta no existe
     */
    public static ProfesorDAO getInstanceProfesorDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO();
            return profesorDAO;
        } else{
            return profesorDAO;
        }
    }
    
    /**
     * se crea la instancia de UnidadAprendizajeDAO si esta no existe
     */
    public static UnidadAprendizajeDAO getInstanceUnidadAprendizajeDAO(){
        if(unidadaprendizajeDAO == null){
            unidadaprendizajeDAO = new UnidadAprendizajeDAO();
            return unidadaprendizajeDAO;
        } else{
            return unidadaprendizajeDAO;
        }
    }
    
}
