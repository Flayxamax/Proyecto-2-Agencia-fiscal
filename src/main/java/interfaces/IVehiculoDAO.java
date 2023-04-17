
package interfaces;

import com.itson.dominio.Automovil;
import com.itson.dominio.Persona;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 * Interfaz que maneja las operaciones realizadas de los Vehiculos
 * @author ildex
 */
public interface IVehiculoDAO {
    /**
     * Metodo que se encarga de registrar el vehiculo a la persona
     * @param auto que se va a registrar
     * @param persona el propietario que quiere registrar el vehiculo
     */
    public void registrarVehiculoPersona(Automovil auto, Persona persona);

    /**
     * Este método realiza una consulta de vehículos en base a los parámetros proporcionados.
     * @param configPaginado Objeto de tipo ConfiguracionPaginado que contiene información de paginación y ordenamiento para la consulta.
     * @param persona Objeto de tipo Persona que contiene información de la persona para la que se desea realizar la consulta.
     * @return Lista de objetos Automovil que cumplen con los parámetros de consulta proporcionados.

     */
    public List<Automovil> consultaVehiculos(ConfiguracionPaginado configPaginado, Persona persona);
}
