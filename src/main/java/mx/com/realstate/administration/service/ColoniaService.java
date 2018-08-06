package mx.com.realstate.administration.service;

import java.util.Optional;

import mx.com.realstate.administration.exception.BusinessException;
import mx.com.realstate.administration.persistence.model.Colonia;

public interface ColoniaService {

    void save(Colonia colonia) throws BusinessException;

    Optional<Colonia> findById(int id);
}
