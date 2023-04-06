
package com.itson.implementaciones;
import com.itson.dominio.Automovil;
import com.itson.dominio.Placa;
import com.itson.dominio.TipoPlaca;
import com.itson.dominio.Persona;
import com.itson.dominio.TipoAutomovil;
import interfaces.IPlacaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Calendar;
/**
 *
 * @author aracelyC
 */
public class PlacaDAO {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_ProyectoBDA_jar_1.0-SNAPSHOTPU");
    EntityManager em = emFactory.createEntityManager();
    
    public void insertarTramitePlacas(String rfc, TipoPlaca tipo, Automovil automovil, TipoAutomovil tipoAuto, int tipoPlacas, int tipoAutomovil ){
        try{
            TypedQuery<Persona> queryPersona = em.createQuery("select p from Persona p where p.rfc = :rfc", Persona.class);
            queryPersona.setParameter("rfc", rfc);
            Persona persona = queryPersona.getSingleResult();
            
            Placa placa = new Placa();
            if(tipoPlacas==1){
                placa.setTipo(tipo.VIGENTE);
            }else{
                placa.setTipo(tipo.NoVIGENTE);
            }
            
            Automovil auto = new Automovil();
            if(tipoAutomovil == 1){
                automovil.setTipoAuto(tipoAuto.NUEVO);
            }else{
                automovil.setTipoAuto(tipoAuto.USADO);
            }
            placa.setPersona(persona);
            placa.setFechaEmision(Calendar.getInstance());
            placa.setFechaRecepcion(Calendar.getInstance());
            
            em.getTransaction().begin();
            em.persist(placa);
            em.getTransaction().commit();
            
        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
            em.close();
        }
    }
}
