/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.implementaciones;

import com.itson.dominio.Persona;
import com.itson.dominio.TipoTramite;
import com.itson.dominio.Tramite;
import java.util.Date;
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
public class TramiteDAO {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_ProyectoBDA_jar_1.0-SNAPSHOTPU");
    EntityManager em = emFactory.createEntityManager();

    public List<Tramite> buscarTramites(ConfiguracionPaginado configPaginado, Persona persona, TipoTramite tipo, Date fechaDesde, Date fechaHasta) {
        try {
            TypedQuery<Tramite> query = em.createQuery(
                    "select t from Tramite t "
                    + "where t.persona = :persona "
                    + "and t.fechaEmision between :fechaDesde and :fechaHasta and t.tipo = :tipo", Tramite.class);
            query.setParameter("persona", persona);
            query.setParameter("fechaDesde", fechaDesde);
            query.setParameter("fechaHasta", fechaHasta);
            query.setParameter("tipo", tipo);
            query.setFirstResult(configPaginado.getElementosASaltar());
            query.setMaxResults(configPaginado.getElementosPagina());
            return query.getResultList();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
