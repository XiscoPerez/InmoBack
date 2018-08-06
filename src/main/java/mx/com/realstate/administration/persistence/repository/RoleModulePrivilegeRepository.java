package mx.com.realstate.administration.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.realstate.administration.persistence.model.RoleModulePrivilege;
import mx.com.realstate.administration.persistence.model.RoleModulePrivilegePK;

@Repository
public interface RoleModulePrivilegeRepository extends CrudRepository<RoleModulePrivilege, RoleModulePrivilegePK> {

	@Query(value = "SELECT RMP.* FROM ROLE_MODULE_PRIVILEGES RMP INNER JOIN USER_ROLES UR ON RMP.ROLE= UR.ROLE INNER JOIN USERS U ON U.USERNAME = UR.USERNAME AND U.USERNAME= ?1", nativeQuery = true)
	List<RoleModulePrivilege> findByUsername(String username);

}
