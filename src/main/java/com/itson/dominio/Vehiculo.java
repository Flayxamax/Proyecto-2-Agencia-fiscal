package com.itson.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author aracelyC
 */
@Entity
@Table(name = "vehiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo", nullable = false)
    private Long id;

    @Column(name = "Modelo", nullable = false, length = 10)
    private Integer modelo;

    @Column(name = "Serie", nullable = false, length = 7)
    private String serie;

    @Column(name = "Color", nullable = false, length = 100)
    private String color;

    @Column(name = "Linea", nullable = false, length = 100)
    private String linea;

    @Column(name = "Marca", nullable = false, length = 100)
    private String marca;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", modelo=" + modelo + ", serie=" + serie + ", color=" + color + ", linea=" + linea + ", marca=" + marca + '}';
    }
}
