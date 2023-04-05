/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.itson.dominio.Persona;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ildex
 */
public interface IPersonaDAO {
    public void insertarPersonas();
    public long contarPersonas();
    public List<Persona> buscarPersonas(String rfc, String nombre, Integer ano);
    public Persona buscarPersonasRFC(String rfc);
    public boolean validarPersonaRFC(String rfc);
}
