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
import java.util.Objects;
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
    private ProfesorHelper profesorHelper = new ProfesorHelper();
    private Profesor profesor;
    private List<Profesor> listaProfesor = new ArrayList<>();
    private Profesor Profesorfiltrado;
    private Profesor ProfesorSeleccion;
    private List<Integer> listaID = new ArrayList<>();
    private List<String> listaRFC = new ArrayList<>();
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
        inicializar();
        //List<Profesor> Prueba = new ArrayList();
        //Prueba = listaProfesor;
        /*for(int x = 0; x <listaID.size();x++){
            System.out.println(listaID.get(x));
        }*/
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
        if(validarAltas()) {            
                profesorHelper.Altas(profesor.getIdProfesor(), profesor.getNombre(), profesor.getApP(), profesor.getApM(), profesor.getRfc());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Con Éxito", "Registrado correctamente"));
                inicializar();             
        }                 
    }
    
    public void bajas(){
    profesorHelper.Bajas(ProfesorSeleccion);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Con Éxito", "Se eliminó correctamente"));
    inicializar();
    }

    
    public boolean validarAltas(){        
        for(int z: listaID){        
            if(z == profesor.getIdProfesor()){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Ese ID ya se encuentra en uso"));                         
                return false;
            }
        }
        for(String y: listaRFC){
            if(y.equals(profesor.getRfc())){ 
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Ese RFC ya se encuentra registrado"));                                        
                return false;
            }                         
        }
        return true;
} 
   public void inicializar() {
        profesor = new Profesor();
        listaProfesor = profesorHelper.Mostrar();
        ProfesorSeleccion = new Profesor();
        listaID = profesorHelper.listaID();
        listaRFC = profesorHelper.listaRFC();
   }

}