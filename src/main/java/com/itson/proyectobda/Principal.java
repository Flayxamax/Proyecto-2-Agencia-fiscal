
package com.itson.proyectobda;

import com.itson.dominio.Persona;
import static com.itson.dominio.TipoTramite.LICENCIA;
import com.itson.interfaz.Aplicacion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aracelyC
 */
public class Principal {

    public static void main(String[] args) {
       Aplicacion ap = new Aplicacion();
       ap.setVisible(true);
    }
}
