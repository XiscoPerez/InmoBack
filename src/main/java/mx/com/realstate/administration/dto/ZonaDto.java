package mx.com.realstate.administration.dto;

import javax.validation.constraints.NotNull;

import mx.com.realstate.administration.utils.RealStateUtils;

public class ZonaDto {
    @NotNull
    private String codigoZona;

    @NotNull
    private String nombreZona;

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
