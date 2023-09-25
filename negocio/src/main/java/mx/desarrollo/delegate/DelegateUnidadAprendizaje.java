/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import java.util.List;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.integracion.ServiceLocator;
/**
 *
 * @author Valer
 */
public class DelegateUnidadAprendizaje {
      /**
     * Metodo de ejemplo para guardar Unidad de Aprendizaje
     * @param UnidadAprendizaje
     */
    public void saveUnidadAprendizaje(UnidadAprendizaje unidadaprendizaje){
        ServiceLocator.getInstanceUnidadAprendizajeDAO().save(unidadaprendizaje);
}
    
    public List<UnidadAprendizaje> MostrarUnidadAprendizaje(){
    return ServiceLocator.getInstanceUnidadAprendizajeDAO().findAll();
    }
 }
