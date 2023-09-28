/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;


import java.util.List;
import mx.desarrollo.delegate.DelegateProfesor;
import mx.desarrollo.entidad.Profesor;

/**
 *
 * @author Valer
 */
public class FacadeProfesor {
    
    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }
    
    public void guardarProfesor(Profesor profesor){
        delegateProfesor.saveProfesor(profesor);
    }
    
    public List<Profesor> mostrarProfesor(){
    return delegateProfesor.MostrarProfesor();
    }
    
     public List<Integer> listaID(){
    return delegateProfesor.listaID();
    }
     
    public List<String> listaRFC(){
    return delegateProfesor.listaRFC();
    }
    
    public List<Integer> busquedaE(String b){
    return delegateProfesor.busquedaE(b);
    }
    
    public void bajasProfesor(Profesor profesor){
        delegateProfesor.BajasProfesor(profesor);
    }
    
}