package com.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author aracelyC
 */
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_persona", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RFC", nullable = false, length = 13)
    private String rfc;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "Apellido_Paterno", nullable = false, length = 100)
    private String apellidoPaterno;

    @Column(name = "Apellido_Materno", nullable = false, length = 100)
    private String apellidoMaterno;

    @Column(name = "Telefono", nullable = false, length = 10)
    private String telefono;

    @Column(name = "Fecha_Nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    @OneToMany(mappedBy = "persona")
    private Vehiculo vehiculo;

    @OneToMany(mappedBy = "persona")
    private Tramite tramite;

    public String getRfc() {
        return rfc;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", rfc=" + rfc + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", telefono=" + telefono + '}';
    }

}
