package mx.com.realstate.administration.dto;

import javax.validation.constraints.NotNull;

import mx.com.realstate.administration.utils.RealStateUtils;

public class ColoniaDto {
    @NotNull
    private String nombre;
    @NotNull
    private String codigoZona;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(final String codigoZona) {
        this.codigoZona = codigoZona;
    }

    @Override
    public String toString() {
        return RealStateUtils.requestJson(this);
    }

}
