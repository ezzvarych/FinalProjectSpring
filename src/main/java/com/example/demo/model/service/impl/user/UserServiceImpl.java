package com.example.demo.model.service.impl.user;

import com.example.demo.exception.RepeatedUserException;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.repository.user.UserRepository;
import com.example.demo.model.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void create(User entity) {
        Optional<User> fromDB = getByLoginOrEmail(entity.getLogin(), entity.getEmail());
        if (fromDB.isPresent()) {
            throw new RepeatedUserException(entity);
        }
        userRepository.save(entity);
    }

    @Override
    public void update(User entity) {
        userRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getByLoginOrEmail(String login, String email) {
        return userRepository.findByLoginOrEmail(login, email);
    }
}
