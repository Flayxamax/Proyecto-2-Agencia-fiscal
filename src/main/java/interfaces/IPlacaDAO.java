
package interfaces;

import com.itson.dominio.Automovil;
import com.itson.dominio.Persona;
import java.util.List;

/**
 *
 * @author aracelyC
 */
public interface IPlacaDAO {
    public String generarPlaca();
    public boolean validarPlaca(String placa);
    public void insertarTramitePlacasNuevo(Persona persona, Automovil automovil, String placaI, Double costo);
    public boolean validaPersonaPlacas(Persona persona);
    public List<Automovil> buscarPlacaAutomovilL(String placa, Persona persona);
    public Automovil buscarPlacaAutomovil(String placa, Persona persona);
//    public boolean validaPlacaPersonaExiste(String placa, Persona persona);
    public void insertarTramitePlacasUsado(Persona persona, Automovil automovil, String placaI, Double costo);
}
