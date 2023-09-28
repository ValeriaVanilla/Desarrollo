/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Valer
 */
@Entity
@Table(name = "unidad_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadAprendizaje.findAll", query = "SELECT u FROM UnidadAprendizaje u")
    , @NamedQuery(name = "UnidadAprendizaje.findByIdUnidadAprendizaje", query = "SELECT u FROM UnidadAprendizaje u WHERE u.idUnidadAprendizaje = :idUnidadAprendizaje")
    , @NamedQuery(name = "UnidadAprendizaje.findByNombreUnidad", query = "SELECT u FROM UnidadAprendizaje u WHERE u.nombreUnidad = :nombreUnidad")
    , @NamedQuery(name = "UnidadAprendizaje.findByHoraC", query = "SELECT u FROM UnidadAprendizaje u WHERE u.horaC = :horaC")
    , @NamedQuery(name = "UnidadAprendizaje.findByHoraT", query = "SELECT u FROM UnidadAprendizaje u WHERE u.horaT = :horaT")
    , @NamedQuery(name = "UnidadAprendizaje.findByHoraL", query = "SELECT u FROM UnidadAprendizaje u WHERE u.horaL = :horaL")})
public class UnidadAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Unidad_Aprendizaje")
    private Integer idUnidadAprendizaje;
    @Basic(optional = false)
    @Column(name = "Nombre_Unidad")
    private String nombreUnidad;
    @Column(name = "Hora_C")
    private Integer horaC;
    @Column(name = "Hora_T")
    private Integer horaT;
    @Column(name = "Hora_L")
    private Integer horaL;
    @ManyToMany(mappedBy = "unidadAprendizajeList")
    private List<Profesor> profesorList;

    public UnidadAprendizaje() {
    }

    public UnidadAprendizaje(Integer idUnidadAprendizaje, String nombreUnidad, Integer horaC, Integer horaT, Integer horaL) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
        this.nombreUnidad = nombreUnidad;
        this.horaC = horaC;
        this.horaT = horaT;
        this.horaL = horaL;
    }

    public UnidadAprendizaje(Integer idUnidadAprendizaje, String nombreUnidad, Integer horaC, Integer horaT, Integer horaL, List<Profesor> profesorList) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
        this.nombreUnidad = nombreUnidad;
        this.horaC = horaC;
        this.horaT = horaT;
        this.horaL = horaL;
        this.profesorList = profesorList;
    }
    
    
    
    public UnidadAprendizaje(Integer idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public UnidadAprendizaje(Integer idUnidadAprendizaje, String nombreUnidad) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
        this.nombreUnidad = nombreUnidad;
    }

    public Integer getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(Integer idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public Integer getHoraC() {
        return horaC;
    }

    public void setHoraC(Integer horaC) {
        this.horaC = horaC;
    }

    public Integer getHoraT() {
        return horaT;
    }

    public void setHoraT(Integer horaT) {
        this.horaT = horaT;
    }

    public Integer getHoraL() {
        return horaL;
    }

    public void setHoraL(Integer horaL) {
        this.horaL = horaL;
    }

    @XmlTransient
    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadAprendizaje != null ? idUnidadAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadAprendizaje)) {
            return false;
        }
        UnidadAprendizaje other = (UnidadAprendizaje) object;
        if ((this.idUnidadAprendizaje == null && other.idUnidadAprendizaje != null) || (this.idUnidadAprendizaje != null && !this.idUnidadAprendizaje.equals(other.idUnidadAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreUnidad;
    }
    
}
