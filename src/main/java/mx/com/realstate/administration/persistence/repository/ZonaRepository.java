package mx.com.realstate.administration.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.realstate.administration.persistence.model.Zona;

@Repository
public interface ZonaRepository extends CrudRepository<Zona, Integer> {

    Optional<Zona> findByCodigoZona(String codigoZona);
}
