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
import mx.desarrollo.entidad.Profesor;
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

    public List<Profesor> getListaProfesor() {
        return listaProfesor;
    }

    public void setListaProfesor(List<Profesor> listaProfesor) {
        this.listaProfesor = listaProfesor;
    }
    
    public ProfesorBeanUI() {
        profesorHelper = new ProfesorHelper();
        profesor = new Profesor();
        listaProfesor = profesorHelper.Mostrar();
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    public void guardar(){
    profesorHelper.Altas(profesor.getIdProfesor(), profesor.getNombre(), profesor.getApP(), profesor.getApM(), profesor.getRfc());
    }
    
   
    

}
