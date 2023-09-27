/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.helper.ProfesorHelper;

/**
 *
 * @author Valer
 */
@ManagedBean(name = "ProfesorUI")
@SessionScoped
    public class ProfesorBeanUI implements Serializable{
    private ProfesorHelper profesorHelper;
    private Profesor profesor;
    private List<Profesor> listaProfesor = new ArrayList<>();
    private Profesor Profesorfiltrado;
    private Profesor ProfesorSeleccion;
   // private List<UnidadAprendizaje> seleccion = new ArrayList<>();
   // private List<Integer> seleccionId = new ArrayList<>();

    public List<Profesor> getListaProfesor() {
        return listaProfesor;
    }

    public void setListaProfesor(List<Profesor> listaProfesor) {
        this.listaProfesor = listaProfesor;
    }

    public Profesor getProfesorSeleccion() {
        return ProfesorSeleccion;
    }

    public void setProfesorSeleccion(Profesor ProfesorSeleccion) {
        this.ProfesorSeleccion = ProfesorSeleccion;
    }

    public Profesor getProfesorfiltrado() {
        return Profesorfiltrado;
    }

    public void setProfesorfiltrado(Profesor Profesorfiltrado) {
        this.Profesorfiltrado = Profesorfiltrado;
    }
    
    
    

   /* public List<UnidadAprendizaje> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<UnidadAprendizaje> seleccion) {
        this.seleccion = seleccion;
    } */
    
    
    
    public ProfesorBeanUI() {
        profesorHelper = new ProfesorHelper();
        profesor = new Profesor();
        listaProfesor = profesorHelper.Mostrar();
        ProfesorSeleccion = new Profesor();
      
        List<Profesor> Prueba = new ArrayList();
        Prueba = listaProfesor;
        for(int x = 0; x <listaProfesor.size()- 1;x++){
            System.out.println(Prueba.get(x));
        }
       /* for(UnidadAprendizaje UA: seleccion){
        seleccionId.add(UA.getIdUnidadAprendizaje());
        }*/
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    public void guardar(){
    profesorHelper.Altas(profesor.getIdProfesor(), profesor.getNombre(), profesor.getApP(), profesor.getApM(), profesor.getRfc());
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Con Éxito", "Registrado correctamente"));
    profesor = new Profesor();
    
    }
    
    public void bajas(){
    profesorHelper.Bajas(ProfesorSeleccion);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Con Éxito", "Se eliminó correctamente"));
    listaProfesor = profesorHelper.Mostrar();
    ProfesorSeleccion = new Profesor();
    }
    
   

}