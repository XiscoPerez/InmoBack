package mx.com.realstate.administration.dto;

import java.util.List;

public class ZonaColoniasDto extends ZonaDto {
    private int idZona;
    List<ColoniaResponseDto> colonias;

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(final int idZona) {
        this.idZona = idZona;
    }

    public List<ColoniaResponseDto> getColonias() {
        return colonias;
    }

    public void setColonias(final List<ColoniaResponseDto> colonias) {
        this.colonias = colonias;
    }

}
