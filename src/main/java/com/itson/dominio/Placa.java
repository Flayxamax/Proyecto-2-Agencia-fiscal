/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ildex
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_tramite_placa")
@DiscriminatorValue("Placa")
@Table(name = "tramite_placa")
public class Placa extends Tramite {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_placa", nullable = false)
    private Long id;

    @Column(name = "Placa", nullable = false, length = 7)
    private String placa;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_recepcion")
    private Calendar fechaRecepcion;

    @Column(name = "Estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPlaca estado;

    @ManyToOne
    @JoinColumn(name = "id_automovil", nullable = false)
    private Automovil automovil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPlaca getEstado() {
        return estado;
    }

    public void setEstado(TipoPlaca estado) {
        this.estado = estado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    public Placa() {

    }

    @Override
    public String toString() {
        return "Placa{" + "id=" + id + ", placa=" + placa + ", fechaRecepcion=" + fechaRecepcion + ", estado=" + estado + ", automovil=" + automovil + '}';
    }

}
