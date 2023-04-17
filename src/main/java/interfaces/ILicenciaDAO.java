
package interfaces;

import com.itson.dominio.Persona;

/**
 * Interfaz que define los metodos que deben implementarse para realizar operaciones relacionadas con las 
 * Licencias de Conducir en una aplicación
 * @author ildex
 */
public interface ILicenciaDAO {
    /**
     * Metodo metodo se encarga de insertar un nuevo tramite de licencia para una persona, 
     * especificando el costo, la vigencia y el estado de discapacidad de la persona
     * @param persona a la que se le asignara la licencia
     * @param costo del tramite de la licencia
     * @param vigencia de la licencia
     * @param estadoDiscapacidad  de la persona
     */
    public void insertarTramiteLicencia(Persona persona, Double costo, int vigencia, int estadoDiscapacidad);
    /**
     * Metodo se encarga de validar si una licencia de conducir asociada a un RFC especifico se encuentra vigente
     * @param rfc de la persona
     * @return si indica que licencia esta vigente 
     */
    public boolean validarLicenciaVigente(String rfc);
}
