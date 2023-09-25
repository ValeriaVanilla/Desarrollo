/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import java.util.ArrayList;
import java.util.List;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.integracion.ServiceLocator;

/**
 *
 * @author Valer
 */

public class DelegateProfesor {
      /**
     * Metodo de ejemplo para guardar Profesor
     * @param profesor
     */
    public void saveProfesor(Profesor profesor){
        ServiceLocator.getInstanceProfesorDAO().save(profesor);
}
    
    public List<Profesor> MostrarProfesor(){
           return ServiceLocator.getInstanceProfesorDAO().findAll();
              
}
    
    public void BajasProfesor(Profesor profesor){
    ServiceLocator.getInstanceProfesorDAO().delete(profesor);
    }
}