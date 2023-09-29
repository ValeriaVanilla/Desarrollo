package mx.desarrollo.ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.helper.UnidadAprendizajeHelper;

/**
 *
 * @author Valer
 */
@ManagedBean(name = "UnidadAprendizajeUI")
@RequestScoped
public class UnidadAprendizajeBeanUI implements Serializable {

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

    public void guardar() {
        String mensaje = "";
        
        if(!validarID()){
        mensaje = "ID Repetido, ";
        } if(!validarNomUA()){
        mensaje += "Nombre de unidad repetido, ";
        }if(!validarHra(unidadAprendizaje.getHoraC())){
        mensaje += "Horas clase no puede ser menor a 0, ";
        }if (!validarHra(unidadAprendizaje.getHoraT())) {
             mensaje += "Horas taller no puede ser menor a 0, ";
        }if (!validarHra(unidadAprendizaje.getHoraL())) {
            mensaje += "Horas laboratorio no puede ser menor a 0, ";
        }

        if (validarID() && validarNomUA() && validarHra(unidadAprendizaje.getHoraC()) && validarHra(unidadAprendizaje.getHoraT()) && validarHra(unidadAprendizaje.getHoraL()) ) {
            unidadAprendizajeHelper.Altas(unidadAprendizaje.getIdUnidadAprendizaje(), unidadAprendizaje.getNombreUnidad(), unidadAprendizaje.getHoraC(), unidadAprendizaje.getHoraT(), unidadAprendizaje.getHoraL());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Con Éxito", "Registrado correctamente"));
            unidadAprendizaje = new UnidadAprendizaje();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR",mensaje));
        }
    }

    public boolean validarID() {
        for (UnidadAprendizaje ua : listaUnidad) { 
            if (Objects.equals(ua.getIdUnidadAprendizaje(), unidadAprendizaje.getIdUnidadAprendizaje())) {
                return false;
            }
        }

        return true;
    }
    public boolean validarNomUA() {
        for (UnidadAprendizaje ua : listaUnidad) {
            if (ua.getNombreUnidad().equalsIgnoreCase(unidadAprendizaje.getNombreUnidad())) {
                return false;
            }
        }

        return true;
    }
    
    public boolean validarHra(int hr){
        
    return hr>=0;
    }
    
    
}
