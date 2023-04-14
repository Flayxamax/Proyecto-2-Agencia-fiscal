/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.implementaciones;

import com.itson.dominio.Automovil;
import com.itson.dominio.Persona;
import interfaces.IVehiculoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import utils.ConfiguracionPaginado;

/**
 *
 * @author ildex
 */
public class VehiculoDAO implements IVehiculoDAO {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_ProyectoBDA_jar_1.0-SNAPSHOTPU");
    EntityManager em = emFactory.createEntityManager();

    @Override
    public void registrarVehiculoPersona(Automovil auto, Persona persona) {
        try {
            em.getTransaction().begin();
            auto.setPersona(persona);
            em.persist(auto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public List<Automovil> consultaVehiculos(ConfiguracionPaginado configPaginado, Persona persona) {
        try {
            TypedQuery<Automovil> query = em.createQuery(
                    "select a from Automovil a "
                    + "where a.persona = :persona",
                    Automovil.class);
            query.setParameter("persona", persona);
            query.setFirstResult(configPaginado.getElementosASaltar());
            query.setMaxResults(configPaginado.getElementosPagina());
            return query.getResultList();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
