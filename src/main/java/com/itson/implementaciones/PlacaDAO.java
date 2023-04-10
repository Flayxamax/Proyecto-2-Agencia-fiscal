package com.itson.implementaciones;

import com.itson.dominio.Automovil;
import com.itson.dominio.Placa;
import com.itson.dominio.Persona;
import com.itson.dominio.TipoPlaca;
import interfaces.IPlacaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.List;
import javax.persistence.TypedQuery;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author aracelyC
 */
public class PlacaDAO implements IPlacaDAO {

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
        boolean valida = false;
        try {
            TypedQuery<Long> query = em.createQuery("select count(p) from Placa p where p.placa = :placa", Long.class);
            query.setParameter("placa", placa);
            valida = query.getSingleResult() > 0;
        } catch (Exception e) {
            e.getMessage();
        }
        return valida;
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
            placa.setEstado(TipoPlaca.Activa);
            placa.setPlaca(placaI);
            em.getTransaction().begin();
            em.persist(placa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void insertarTramitePlacasUsado(Persona persona, Automovil automovil, String placaI, Double costo) {
        try {
            Placa placa = new Placa();
            placa.setPersona(persona);
            placa.setFechaEmision(Calendar.getInstance());
            placa.setFechaRecepcion(Calendar.getInstance());
            placa.setAutomovil(automovil);
            placa.setCosto(costo);
            placa.setEstado(TipoPlaca.Activa);
            placa.setPlaca(placaI);
            for (Placa p : automovil.getPlaca()) {
                p.setEstado(TipoPlaca.Desactivada);
            }
            em.getTransaction().begin();
            em.persist(placa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public boolean validaPersonaPlacas(Persona persona) {
        boolean valida = false;
        try {
            TypedQuery<Long> query = em.createQuery(""
                    + "select count(a) from Automovil a "
                    + "inner join a.placa p "
                    + "where a.persona = :persona", Long.class);
            query.setParameter("persona", persona);
            valida = query.getSingleResult() > 0;
        } catch (Exception e) {
            e.getMessage();
        }
        return valida;
    }

//    public boolean validaPlacaPersonaExiste(String placa, Persona persona) {
//        boolean valida = false;
//        try {
//            TypedQuery<Long> query = em.createQuery("select count(a) from Automovil a where a.placa = :placa and a.persona = :persona", Long.class);
//            query.setParameter("placa", placa);
//            query.setParameter("persona", persona);
//            valida = query.getSingleResult() > 0;
//        } catch (Exception e) {
//            e.getMessage();
//        }
//        return valida;
//    }

    public List<Automovil> buscarPlacaAutomovilL(String placa, Persona persona) {
        try {
            TypedQuery<Automovil> query = em.createQuery(
                    "select a from Automovil a "
                    + "inner join a.placa p "
                    + "where p.placa = :placa and a.persona = :persona and p.estado = :estado",
                    Automovil.class);
            query.setParameter("placa", placa);
            query.setParameter("persona", persona);
            query.setParameter("estado", TipoPlaca.Activa);
            return query.getResultList();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public Automovil buscarPlacaAutomovil(String placa, Persona persona) {
        try {
            TypedQuery<Automovil> query = em.createQuery(
                    "select a from Automovil a "
                    + "inner join a.placa p "
                    + "where p.placa = :placa and a.persona = :persona and p.estado = :estado",
                    Automovil.class);
            query.setParameter("placa", placa);
            query.setParameter("persona", persona);
            query.setParameter("estado", TipoPlaca.Activa);
            return query.getSingleResult();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
