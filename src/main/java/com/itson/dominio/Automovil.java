package com.itson.dominio;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author aracelyC
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_vehiculo_automovil")
@Table(name = "vehiculo_automovil")
public class Automovil extends Vehiculo {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_automovil", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "automovil", targetEntity = Placa.class)
    private List<Placa> placa;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public List<Placa> getPlaca() {
        return placa;
    }

    public void setPlaca(List<Placa> placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Automovil{" + "id=" + id + ", placa=" + placa + '}';
    }

}
