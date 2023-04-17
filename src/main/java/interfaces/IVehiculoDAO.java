
package interfaces;

import com.itson.dominio.Automovil;
import com.itson.dominio.Persona;

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
}
