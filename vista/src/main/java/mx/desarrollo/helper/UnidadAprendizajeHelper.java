/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

/**
 *
 * @author Valer
 */
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.integracion.ServiceFacadeLocator;
/**
 *
 * @author Valer
 */
public class UnidadAprendizajeHelper implements Serializable{
    

    /**
     * Metodo para hacer Altas llamara a la instancia de ProfesorFacade
     */
    public void Altas(int Id, String nombre, int horaC, int horaT, int horaL ){
        UnidadAprendizaje unidadAprendizaje = new UnidadAprendizaje(Id,nombre, horaC, horaT, horaL);
        ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().guardarUnidadAprendizaje(unidadAprendizaje); 
    }
}
