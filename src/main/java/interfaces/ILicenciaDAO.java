/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.itson.dominio.Persona;

/**
 *
 * @author ildex
 */
public interface ILicenciaDAO {
    public void insertarTramiteLicencia(Persona persona, Double costo, int vigencia, int estadoDiscapacidad);
    public boolean validarLicenciaVigente(String rfc);
}
