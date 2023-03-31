/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author ildex
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_tramite_licencia")
@Table(name = "tramite_licencia")
public class Licencia extends Tramite {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_licencia", nullable = false)
    private Long id;

    @Column(name = "Tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoLicencia tipo;

    @Column(name = "Vigencia", nullable = false)
    private Integer vigencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTipo(TipoLicencia tipo) {
        this.tipo = tipo;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", tipo=" + tipo + ", vigencia=" + vigencia + '}';
    }

}
