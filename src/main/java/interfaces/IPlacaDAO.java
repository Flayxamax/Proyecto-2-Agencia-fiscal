
package interfaces;

import com.itson.dominio.Automovil;
import com.itson.dominio.Persona;

/**
 *
 * @author aracelyC
 */
public interface IPlacaDAO {
    public String generarPlaca();
    public boolean validarPlaca(String placa);
    public void insertarTramitePlacasNuevo(Persona persona, Automovil automovil, String placaI, Double costo);
}
