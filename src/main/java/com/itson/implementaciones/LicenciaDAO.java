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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import utils.ConfiguracionPaginado;

/**
 *
 * @author ildex
 */
public class LicenciaDAO implements ILicenciaDAO {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_ProyectoBDA_jar_1.0-SNAPSHOTPU");
    EntityManager em = emFactory.createEntityManager();

    @Override
    public void insertarTramiteLicencia(Persona persona, Double costo, int vigencia, int estadoDiscapacidad) {
        try {
            Licencia licencia = new Licencia();
            if (estadoDiscapacidad == 1) {
                licencia.setTipoLicencia(TipoLicencia.Discapacitado);
            } else {
                licencia.setTipoLicencia(TipoLicencia.Normal);
            }
            licencia.setVigencia(vigencia);
            licencia.setCosto(costo);
            licencia.setFechaEmision(Calendar.getInstance());
            licencia.setPersona(persona);

            em.getTransaction().begin();
            em.persist(licencia);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean validarLicenciaVigente(String rfc) {
        boolean vigencia = false;
        try {
            TypedQuery<Licencia> queryLicencia = em.createQuery("select l from Licencia l "
                    + "inner join l.persona p "
                    + "where p.rfc = :rfc "
                    + "order by l.fechaEmision desc", Licencia.class);
            queryLicencia.setParameter("rfc", rfc);
            queryLicencia.setMaxResults(1);
            Licencia licencia = queryLicencia.getSingleResult();
            Calendar fechaVencimiento = Calendar.getInstance();
            fechaVencimiento.add(Calendar.YEAR, licencia.getVigencia());
            Calendar fechaActual = Calendar.getInstance();
            if (fechaVencimiento.after(fechaActual)) {
                vigencia = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No tiene o no se encontró una licencia vigente para la persona con el RFC " + rfc, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return vigencia;
    }

    public List<Licencia> consultaLicencias(ConfiguracionPaginado configPaginado, Persona persona) {
        try {
            TypedQuery<Licencia> query = em.createQuery(
                    "select l from Licencia l "
                    + "where l.persona = :persona",
                    Licencia.class);
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
