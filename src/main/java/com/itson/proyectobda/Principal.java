/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.itson.proyectobda;

import com.itson.dominio.Persona;
import static com.itson.dominio.TipoTramite.LICENCIA;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aracelyC
 */
public class Principal {

    public static void main(String[] args) throws SQLException {
       EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.proyectobda");
       EntityManager entityManager= emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Persona persona1 = new Persona();
        persona1.setNombre("Maria");
        persona1.setApellidoPaterno("Lopez");
        persona1.setApellidoMaterno("Mendez");
        persona1.setRfc("MARIA12354C");
        persona1.setTelefono("1234567890");
        persona1.setTramite(LICENCIA);
        entityManager.persist(persona1);
        entityManager.getTransaction().commit();

       

    }
}
