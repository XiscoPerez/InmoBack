package mx.com.realstate.administration.dto;

import javax.validation.constraints.NotNull;

import mx.com.realstate.administration.utils.RealStateUtils;

public class ZonaActualizacionDto {

    @NotNull
    private Integer idZona;

    @NotNull
    private String codigoZona;

    @NotNull
    private String nombreZona;

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(final Integer idZona) {
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

    @Override
    public String toString() {
        return RealStateUtils.requestJson(this);
    }

}
