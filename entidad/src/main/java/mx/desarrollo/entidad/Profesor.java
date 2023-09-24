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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
    , @NamedQuery(name = "Profesor.findByIdProfesor", query = "SELECT p FROM Profesor p WHERE p.idProfesor = :idProfesor")
    , @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Profesor.findByApP", query = "SELECT p FROM Profesor p WHERE p.apP = :apP")
    , @NamedQuery(name = "Profesor.findByApM", query = "SELECT p FROM Profesor p WHERE p.apM = :apM")
    , @NamedQuery(name = "Profesor.findByRfc", query = "SELECT p FROM Profesor p WHERE p.rfc = :rfc")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Profesor")
    private Integer idProfesor;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Ap_P")
    private String apP;
    @Column(name = "Ap_M")
    private String apM;
    @Column(name = "RFC")
    private String rfc;
    @JoinTable(name = "imparte", joinColumns = {
        @JoinColumn(name = "Id_PR", referencedColumnName = "Id_Profesor")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_UA", referencedColumnName = "Id_Unidad_Aprendizaje")})
    @ManyToMany
    private List<UnidadAprendizaje> unidadAprendizajeList;

    public Profesor() {
    }

    public Profesor(Integer idProfesor, String nombre, String apP, String apM, String rfc) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apP = apP;
        this.apM = apM;
        this.rfc = rfc;
    }

    public Profesor(Integer idProfesor, String nombre, String apP, String apM, String rfc, List<UnidadAprendizaje> unidadAprendizajeList) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apP = apP;
        this.apM = apM;
        this.rfc = rfc;
        this.unidadAprendizajeList = unidadAprendizajeList;
    }

    
    
    
    public Profesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApP() {
        return apP;
    }

    public void setApP(String apP) {
        this.apP = apP;
    }

    public String getApM() {
        return apM;
    }

    public void setApM(String apM) {
        this.apM = apM;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @XmlTransient
    public List<UnidadAprendizaje> getUnidadAprendizajeList() {
        return unidadAprendizajeList;
    }

    public void setUnidadAprendizajeList(List<UnidadAprendizaje> unidadAprendizajeList) {
        this.unidadAprendizajeList = unidadAprendizajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesor != null ? idProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idProfesor == null && other.idProfesor != null) || (this.idProfesor != null && !this.idProfesor.equals(other.idProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idProfesor=" + idProfesor + " ]";
    }
    
}
