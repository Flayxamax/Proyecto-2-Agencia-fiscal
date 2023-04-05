/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.implementaciones;

import com.itson.dominio.Licencia;
import com.itson.dominio.Persona;
import com.itson.dominio.TipoLicencia;
import interfaces.ILicenciaDAO;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author ildex
 */
public class LicenciaDAO implements ILicenciaDAO {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_ProyectoBDA_jar_1.0-SNAPSHOTPU");
    EntityManager em = emFactory.createEntityManager();

    @Override
    public void insertarTramiteLicencia(String rfc, Double costo, int vigencia, int estadoDiscapacidad) {
        try {
            TypedQuery<Persona> queryPersona = em.createQuery("select p from Persona p where p.rfc = :rfc", Persona.class);
            queryPersona.setParameter("rfc", rfc);
            Persona persona = queryPersona.getSingleResult();

            Licencia licencia = new Licencia();
            if (estadoDiscapacidad == 1) {
                licencia.setTipo(TipoLicencia.DISCAPACITADO);
            } else {
                licencia.setTipo(TipoLicencia.NORMAL);
            }
            licencia.setVigencia(vigencia);
            licencia.setCosto(costo);
            licencia.setFechaEmision(Calendar.getInstance());
            licencia.setPersona(persona);

            em.getTransaction().begin();
            em.persist(licencia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }
}
