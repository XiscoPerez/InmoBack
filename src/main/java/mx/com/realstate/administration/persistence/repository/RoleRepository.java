package mx.com.realstate.administration.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.realstate.administration.persistence.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {

}
