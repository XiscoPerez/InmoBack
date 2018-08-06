package mx.com.realstate.administration.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.realstate.administration.persistence.model.Privilege;

@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege, String> {

}
