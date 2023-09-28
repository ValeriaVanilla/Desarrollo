/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import mx.desarrollo.DAO.ProfesorDAO;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.DAO.UnidadAprendizajeDAO;
import mx.desarrollo.entidad.UnidadAprendizaje;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
            
        List<Profesor> listaProfesor = new ArrayList<>();
        ProfesorDAO profesorDAo = new ProfesorDAO();
        listaProfesor = profesorDAo.findAll();
        
        for(Profesor pr : listaProfesor){
            System.out.println("Id: " + pr.getIdProfesor() + " Nombre: " + pr.getNombre() + " " + pr.getApP()+ " " + pr.getApM());
        }
        }
    }

