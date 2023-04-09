/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.itson.dominio.Automovil;
import com.itson.dominio.Persona;

/**
 *
 * @author ildex
 */
public interface IVehiculoDAO {
    public void registrarVehiculoPersona(Automovil auto, Persona persona);
}
