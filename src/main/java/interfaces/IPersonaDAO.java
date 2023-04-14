/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.itson.dominio.Persona;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author ildex
 */
public interface IPersonaDAO {
    public void insertarPersonas();
    public long contarPersonas();
    public List<Persona> buscarPersonas(ConfiguracionPaginado configPaginado, String rfc, String nombre, String ano);
    public Persona buscarPersonasRFC(String rfc);
    public boolean validarPersonaRFC(String rfc);
}
