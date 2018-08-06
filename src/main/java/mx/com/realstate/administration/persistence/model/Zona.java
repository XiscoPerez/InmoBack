package mx.com.realstate.administration.persistence.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zonas")
@NamedQuery(name = "Zona.findAll", query = "SELECT z FROM Zona z")
public class Zona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idZona;

    private String codigoZona;

    private String nombreZona;

    @OneToMany(mappedBy = "zona")
    private List<Colonia> colonias;

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(final int idZona) {
        this.idZona = idZona;
    }

    public String getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(final String codigoZona) {
        this.codigoZona = codigoZona;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(final String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public List<Colonia> getColonias() {
        return colonias;
    }

    public void setColonias(final List<Colonia> colonias) {
        this.colonias = colonias;
    }

}
