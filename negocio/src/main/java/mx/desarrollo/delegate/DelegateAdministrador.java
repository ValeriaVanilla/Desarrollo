/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import mx.desarrollo.entidad.Administrador;
import mx.desarrollo.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateAdministrador {
    
    /**
     * Metodo de ejemplo para guardar Administrador
     * @param Administrador de tipo usuario con id 0 para que se cree un id nuevo
     */
    public void saveAdministrador(Administrador administrador){
        ServiceLocator.getInstanceAdministradorDAO().save(administrador);
    }
    
}
