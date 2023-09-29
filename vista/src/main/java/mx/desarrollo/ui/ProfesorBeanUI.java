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
    private List<Profesor> Profesorfiltrado = new ArrayList<>() ;
    private String b;
    private Profesor ProfesorSeleccion;
    private List<Integer> listaID = new ArrayList<>();
    private List<String> listaRFC = new ArrayList<>();
    private List<String> seleccion = new ArrayList<>();
    private List<Integer> seleccionId = new ArrayList<>();

    public List<Profesor> getProfesorfiltrado() {
        return Profesorfiltrado;
    }

    public void setProfesorfiltrado(List<Profesor> Profesorfiltrado) {
        this.Profesorfiltrado = Profesorfiltrado;
    }

    
    
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    
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

    public List<String> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<String> seleccion) {
        this.seleccion = seleccion;
    }
 
    
    public ProfesorBeanUI() {
        inicializar();
        /*b = "Calculo";
        List<Integer> Prueba = new ArrayList();
        Prueba = profesorHelper.busquedaB(b);
        for(int x = 0; x <Prueba.size();x++){
            System.out.println(Prueba.get(x));
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
                AsignarUnidades();
                profesorHelper.Altas(profesor.getIdProfesor(), profesor.getNombre(), profesor.getApP(), profesor.getApM(), profesor.getRfc(), profesor.getUnidadAprendizajeList());
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
        int i=0;
        boolean aux = true;
        for(int z: listaID){        
            if(z == profesor.getIdProfesor()){
                i++;                   
                aux= false;
            }
        }
        for(String y: listaRFC){
            if(y.equals(profesor.getRfc())){ 
                i=i+2;                                 
                aux= false;
            }                         
        }
        if (profesor.getRfc() != null && profesor.getRfc().length() != 13) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "El RFC debe de contener 13 caracteres"));
        i=i+4;                                 
        aux = false;
    }
        
        switch(i) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Ese ID ya se encuentra en uso"));                      
                break;
            case 2:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Ese RFC ya se encuentra registrado"));                       
                break;
            case 3:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Esos ID y RFC ya se encuentran registrados"));                       
                break;
            case 4:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "El RFC debe de contener 13 caracteres"));
                break;
            case 5:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "El ID se encuentra repetido y el RFC debe de contener 13 caracteres"));
                break;
        }
        return aux;
} 
   public void inicializar() {
       
        profesor = new Profesor();
        listaProfesor = profesorHelper.Mostrar();
        ProfesorSeleccion = new Profesor();
        listaID = profesorHelper.listaID();
        listaRFC = profesorHelper.listaRFC();
         
   }

   public void AsignarUnidades(){
       List<UnidadAprendizaje> unidad = new ArrayList<>();
   for(String x: seleccion){
   unidad.add(new UnidadAprendizaje(Integer.parseInt(x)));
   }
   profesor.setUnidadAprendizajeList(unidad);
   }
   
   
   public void Modificar(){
   profesorHelper.Modificar(ProfesorSeleccion);
   }
   
   
}