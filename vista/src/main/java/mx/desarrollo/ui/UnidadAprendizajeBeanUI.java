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
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.helper.UnidadAprendizajeHelper;

/**
 *
 * @author Valer
 */
@ManagedBean(name = "UnidadAprendizajeUI")
@SessionScoped
    public class UnidadAprendizajeBeanUI implements Serializable{
    private UnidadAprendizajeHelper unidadAprendizajeHelper;
    private UnidadAprendizaje unidadAprendizaje;
    private List<UnidadAprendizaje> listaUnidad = new ArrayList<>();

    public List<UnidadAprendizaje> getListaUnidad() {
        return listaUnidad;
    }

    public void setListaUnidad(List<UnidadAprendizaje> listaUnidad) {
        this.listaUnidad = listaUnidad;
    }
    
    public UnidadAprendizajeBeanUI() {
        unidadAprendizajeHelper = new UnidadAprendizajeHelper();
        unidadAprendizaje = new UnidadAprendizaje();
        listaUnidad = unidadAprendizajeHelper.Mostrar();
    }

    public UnidadAprendizaje getUnidadAprendizaje() {
        return unidadAprendizaje;
    }

    public void setProfesor(UnidadAprendizaje unidadAprendizaje) {
        this.unidadAprendizaje = unidadAprendizaje;
    }
    
    public void guardar(){
    unidadAprendizajeHelper.Altas(unidadAprendizaje.getIdUnidadAprendizaje(), unidadAprendizaje.getNombreUnidad(), unidadAprendizaje.getHoraC(), unidadAprendizaje.getHoraT() ,unidadAprendizaje.getHoraL());
    }
}