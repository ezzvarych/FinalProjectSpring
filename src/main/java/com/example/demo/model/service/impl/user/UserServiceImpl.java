package com.example.demo.model.service.impl.user;

import com.example.demo.model.entity.user.User;
import com.example.demo.model.repository.user.UserRepository;
import com.example.demo.model.service.user.UserService;
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
    public Optional<User> getByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginOrEmailAndPassword(login, login, password);
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

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public Optional<User> delete(long id) {
        return Optional.empty();
    }
}
