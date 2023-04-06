
package interfaces;

import com.itson.dominio.Automovil;
import com.itson.dominio.TipoAutomovil;
import com.itson.dominio.TipoPlaca;

/**
 *
 * @author aracelyC
 */
public interface IPlacaDAO {
    public void insertarTramitePlaca( Automovil automovil, TipoPlaca tipo, TipoAutomovil tipoAuto);
}
