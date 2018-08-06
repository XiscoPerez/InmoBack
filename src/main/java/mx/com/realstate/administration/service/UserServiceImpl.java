package mx.com.realstate.administration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.realstate.administration.persistence.model.User;
import mx.com.realstate.administration.persistence.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(final User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean exist(final String username) {
        return userRepository.findById(username).isPresent();
    }

    @Override
    public Optional<User> findById(final String username) {
        return userRepository.findById(username);
    }
}
