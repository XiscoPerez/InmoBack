package mx.com.realstate.administration.service;

import java.util.Optional;

import mx.com.realstate.administration.exception.BusinessException;
import mx.com.realstate.administration.persistence.model.Zona;

public interface ZonaService {

    Zona save(Zona zona) throws BusinessException;

    Optional<Zona> findByCodigoZona(String codigoZona);

}
