/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.itson.dominio.Persona;
import com.itson.dominio.TipoTramite;
import com.itson.dominio.Tramite;
import java.util.Date;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author ildex
 */
public interface ITramiteDAO {
    public List<Tramite> buscarTramites(ConfiguracionPaginado configPaginado, Persona persona, TipoTramite tipo, Date fechaDesde, Date fechaHasta);
}
