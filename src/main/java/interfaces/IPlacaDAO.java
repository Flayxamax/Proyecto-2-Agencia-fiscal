
package interfaces;

import com.itson.dominio.Automovil;
import com.itson.dominio.Persona;
import java.util.List;

/**
 * Interaz que define los metodos necesarios para realizar operaciones relacionadas
 * a placas con la base de datos
 * @author aracelyC
 */
public interface IPlacaDAO {
    /**
     * Metodo que genera una nueva placa para un automovil
     * @return la placa generada
     */
    public String generarPlaca();
    /**
     * Metodo que valida la placa segun su formato
     * @param placa que se va a validar
     * @return la placa si es valida o no 
     */
    public boolean validarPlaca(String placa);
    /**
     * Metodo que inserta las placas a un nuevo automovil para una persona
     * @param persona a a la que se le asignara el automovil
     * @param automovil que se va a registrar
     * @param placaI la placa del automovil
     * @param costo de las placas para el automovil nuevo
     */
    public void insertarTramitePlacasNuevo(Persona persona, Automovil automovil, String placaI, Double costo);
    /**
     * Metodo que valida si la persona tiene un automovil asociado con las placas registradas
     * @param persona el propietario del auto
     * @return si la persona tiene un autmovil registrado
     */
    public boolean validaPersonaPlacas(Persona persona);
    /**
     * Metodo que busca los autmoviles registrados mediante su placa
     * @param placa del autmovil a buscar
     * @param persona el propietario del automovil
     * @return la lista de los autos encontrados 
     */
    public List<Automovil> buscarPlacaAutomovilL(String placa, Persona persona);
    /**
     * Metodo que busca la placa de un automovil que esten asociadas con el propietario
     * @param placa del automovil a buscar
     * @param persona que es propietario del automovil
     * @return el automovil encontrado
     */
    public Automovil buscarPlacaAutomovil(String placa, Persona persona);

    /**
     * Metodo que se encarga de insertar un nuevo tramite de placas al automovil usado
     * @param persona que representa el propietario del automovil
     * @param automovil que este registrado en el tramite
     * @param placaI que representa la nueva a registrar
     * @param costo el costo del tramite
     */

    public void insertarTramitePlacasUsado(Persona persona, Automovil automovil, String placaI, Double costo);
}
