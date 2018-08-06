package mx.com.realstate.administration.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.realstate.administration.persistence.model.UserRole;
import mx.com.realstate.administration.persistence.model.UserRolePK;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, UserRolePK> {

}
