/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.itson.proyectobda;

import com.itson.interfaz.Aplicacion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aracelyC
 */
public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_ProyectoBDA_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = emFactory.createEntityManager();
        
        Aplicacion ap = new Aplicacion();
        ap.setVisible(true);
    }
}
