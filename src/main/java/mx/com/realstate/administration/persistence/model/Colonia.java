package mx.com.realstate.administration.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "colonias")
@NamedQuery(name = "Colonia.findAll", query = "SELECT c FROM Colonia c")
public class Colonia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idColonia;

    private String nombre;

    @ManyToOne
    private Zona zona;

    public int getIdColonia() {
        return idColonia;
    }

    public void setIdColonia(final int idColonia) {
        this.idColonia = idColonia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(final Zona zona) {
        this.zona = zona;
    }

}
