/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.implementaciones;

import com.itson.dominio.Encriptacion;
import com.itson.dominio.Persona;
import interfaces.IPersonaDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author ildex
 */
public class PersonaDAO implements IPersonaDAO {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_ProyectoBDA_jar_1.0-SNAPSHOTPU");
    EntityManager em = emFactory.createEntityManager();

    @Override
    public void insertarPersonas() {
        Persona persona1 = new Persona("JUAG8609081W1", "Juan", "González", "Pérez", "6441234567", 1986, Calendar.SEPTEMBER, 8);
        Persona persona2 = new Persona("PEAH8805206G4", "Pedro", "Alvarez", "Hernández", "6449876543", 1988, Calendar.MAY, 20);
        Persona persona3 = new Persona("GARA9907039K9", "Gabriela", "Ramírez", "Sánchez", "6445555555", 1999, Calendar.JULY, 3);
        Persona persona4 = new Persona("VALC7807153Z2", "Verónica", "Alcántara", "López", "6441112233", 1978, Calendar.JULY, 15);
        Persona persona5 = new Persona("CASR8306297R7", "Carlos", "Santos", "Rodríguez", "6444445566", 1983, Calendar.JUNE, 29);
        Persona persona6 = new Persona("JIMG9406056S5", "Jimena", "Gómez", "Torres", "6442223344", 1994, Calendar.FEBRUARY, 4);
        Persona persona7 = new Persona("MOLP7705147H6", "María", "Olivera", "Pérez", "6446667777", 1977, Calendar.MAY, 14);
        Persona persona8 = new Persona("ALOT8911224W8", "Alfonso", "López", "Téllez", "6447778888", 1989, Calendar.NOVEMBER, 22);
        Persona persona9 = new Persona("CARF8107019X1", "Carlos", "Fuentes", "Herrera", "6442223333", 1981, Calendar.JULY, 1);
        Persona persona10 = new Persona("RICM8902163J4", "Ricardo", "Martínez", "Castañeda", "6446667977", 1989, Calendar.FEBRUARY, 16);
        Persona persona11 = new Persona("LALP7103239N0", "Laura", "López", "Pérez", "6445551212", 1971, Calendar.MARCH, 23);
        Persona persona12 = new Persona("MANP8704127T0", "María", "Pérez", "Ramírez", "6444443322", 1987, Calendar.APRIL, 12);
        Persona persona13 = new Persona("JOSE8210254V7", "José", "Sánchez", "González", "6443332211", 1982, Calendar.OCTOBER, 25);
        Persona persona14 = new Persona("ISAP7903056F8", "Isabel", "Sandoval", "Pérez", "6448889999", 1979, Calendar.MARCH, 5);
        Persona persona15 = new Persona("ERIJ8906093Z8", "Eric", "Jiménez", "Pérez", "6441112222", 1989, Calendar.JUNE, 9);
        Persona persona16 = new Persona("LANL900825HMC", "Laura", "Nava", "Lopez", "6445512582", 1990, Calendar.AUGUST, 25);
        Persona persona17 = new Persona("GARB930902HMC", "Bernardo", "Garcia", "Rios", "6445552851", 1993, Calendar.SEPTEMBER, 2);
        Persona persona18 = new Persona("HEGG921003HMC", "Gabriela", "Hernandez", "Gomez", "644231902", 1992, Calendar.OCTOBER, 3);
        Persona persona19 = new Persona("SAMM951125HMC", "Ricardo", "Santos", "Mendoza", "6448472901", 1995, Calendar.NOVEMBER, 25);
        Persona persona20 = new Persona("GOML940204HMC", "Luis", "Gonzalez", "Martinez", "6448390173", 1994, Calendar.FEBRUARY, 4);
        Persona[] personas = new Persona[]{persona1, persona2, persona3, persona4, persona5, persona6, persona7, persona8, persona9, persona10, persona11, persona12, persona13, persona14, persona15, persona16, persona17, persona18, persona19, persona20};

        em.getTransaction().begin();
        for (int i = 0; i < personas.length; i++) {
            Persona persona = personas[i];
            em.persist(persona);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public long contarPersonas() {
        Query query = em.createQuery("select count(p) from Persona p");
        return (long) query.getSingleResult();
    }

    @Override
    public List<Persona> buscarPersonas(String rfc, String nombre, Integer ano) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> root = cq.from(Persona.class);
        List<Predicate> parametros = new ArrayList<>();

        if (nombre != null) {
            String[] espacio = nombre.split("\\s+");
            for (String part : espacio) {
                parametros.add(cb.or(
                        cb.like(root.get("nombre"), "%" + part + "%"),
                        cb.like(root.get("apellidoPaterno"), "%" + part + "%"),
                        cb.like(root.get("apellidoMaterno"), "%" + part + "%")
                ));
            }
        }

        if (rfc != null) {
            parametros.add(cb.like(root.get("rfc"), "%" + rfc + "%"));
        }

        if (ano != 0) {
            parametros.add(cb.equal(cb.function("YEAR", Integer.class, root.get("fechaNacimiento")), ano));
        }

        cq.select(root).where(parametros.toArray(new Predicate[]{}));
        TypedQuery<Persona> query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Persona buscarPersonasRFC(String rfc) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> root = cq.from(Persona.class);
        List<Predicate> parametros = new ArrayList<>();

        if (rfc != null) {
            parametros.add(cb.equal(root.get("rfc"), rfc));
        }

        cq.select(root).where(parametros.toArray(new Predicate[]{}));
        TypedQuery<Persona> query = em.createQuery(cq);
        return query.getSingleResult();
    }

    @Override
    public boolean validarPersonaRFC(String rfc) {
        TypedQuery<Long> query = em.createQuery("select count(p) from Persona p where p.rfc = :rfc", Long.class);
        query.setParameter("rfc", rfc);
        return query.getSingleResult() > 0;
    }
}
