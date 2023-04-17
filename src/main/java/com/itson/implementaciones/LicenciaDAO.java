
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
 * Esta clase implementa la interfaz ILicenciaDAO y se encarga de realizar operaciones
 * de acceso a datos relacionados con la entidad licencia
 * @author ildex
 */
public class LicenciaDAO implements ILicenciaDAO {
    /**
     * Objeto que se utiliza para crear instancias de entity manager y realiza las operacciones
     * de persistencia en la base de datos
     */
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_ProyectoBDA_jar_1.0-SNAPSHOTPU");
    EntityManager em = emFactory.createEntityManager();
    /**
     * Metodo que permite insertar un nuevo trámite de licencia en la base de datos
     * @param persona objeto persona que es el propietario de la licencia
     * @param costo de la licencia
     * @param vigencia la duracion de la vigencia 
     * @param estadoDiscapacidad si la persona es discapacitada tendra un diferente costo
     * a la persona que no es discapacitada
     */
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
    /**
     * Metodo que verifica si existe una licencia vigente ccon el RFC 
     * @param rfc de la persona
     * @return en caso de no existir lanza un mensaje y retorna la vigencia
     */
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
    /**
     * Metodo que reliza la consulta a la base de datos para obtener la licencia de la persona
     * @param configPaginado es la configuracion del paginado para limitar la cantidad de resultados
     * @param persona a la que se le consultan las licencias
     * @return la lista del obejto de tipo licencia que pertencen a la persona
     */
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
