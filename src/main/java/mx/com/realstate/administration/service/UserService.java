package mx.com.realstate.administration.service;

import java.util.Optional;

import mx.com.realstate.administration.exception.BusinessException;
import mx.com.realstate.administration.persistence.model.User;

public interface UserService {

    User save(User user) throws BusinessException;

    boolean exist(String username);

    Optional<User> findById(String username);
}
