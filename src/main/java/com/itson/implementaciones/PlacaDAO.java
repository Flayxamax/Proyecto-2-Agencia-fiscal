package com.itson.implementaciones;

import com.itson.dominio.Automovil;
import com.itson.dominio.Placa;
import com.itson.dominio.Persona;
import com.itson.dominio.TipoPlaca;
import com.itson.dominio.TipoTramite;
import interfaces.IPlacaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import javax.persistence.TypedQuery;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author aracelyC
 */
public class PlacaDAO implements IPlacaDAO{

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_ProyectoBDA_jar_1.0-SNAPSHOTPU");
    EntityManager em = emFactory.createEntityManager();
    
    @Override
    public String generarPlaca() {
        String placa = null;
        boolean placaExistente = true;
        while (placaExistente == true) {
            String caracteres = RandomStringUtils.randomAlphabetic(3).toUpperCase();
            String numeros = RandomStringUtils.randomNumeric(3);
            placa = caracteres + "-" + numeros;
            boolean placaIgual = this.validarPlaca(placa);
            if (placaIgual == false) {
                placaExistente = false;
            }
        }
        return placa;
    }
    
    @Override
    public boolean validarPlaca(String placa) {
        TypedQuery<Long> query = em.createQuery("select count(p) from Placa p where p.placa = :placa", Long.class);
        query.setParameter("placa", placa);
        return query.getSingleResult() > 0;
    }
    
    @Override
    public void insertarTramitePlacasNuevo(Persona persona, Automovil automovil, String placaI, Double costo) {
        try {
            Placa placa = new Placa();
            placa.setPersona(persona);
            placa.setFechaEmision(Calendar.getInstance());
            placa.setFechaRecepcion(Calendar.getInstance());
            placa.setAutomovil(automovil);
            placa.setCosto(costo);
            placa.setTipo(TipoTramite.Placa);
            placa.setTipo(TipoPlaca.Activa);
            placa.setPlaca(placaI);

            em.getTransaction().begin();
            em.persist(placa);
            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }
}
