/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.integracion.ServiceFacadeLocator;
/**
 *
 * @author Valer
 */
public class ProfesorHelper implements Serializable{
    

    /**
     * Metodo para hacer Altas llamara a la instancia de ProfesorFacade
     */
    public void Altas(int IdProfesor, String nombre, String apP, String apM, String rfc){     
        Profesor profesor = new Profesor(IdProfesor,nombre, apP, apM, rfc);
        ServiceFacadeLocator.getInstanceFacadeProfesor().guardarProfesor(profesor); 
    }
       
    public List<Profesor> Mostrar(){
        return ServiceFacadeLocator.getInstanceFacadeProfesor().mostrarProfesor();
        }
    
    public void Bajas(Profesor profesor){
        ServiceFacadeLocator.getInstanceFacadeProfesor().bajasProfesor(profesor);
    }
    }
    
