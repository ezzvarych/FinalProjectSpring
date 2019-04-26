package com.example.demo.model.service.impl.user;

import com.example.demo.exception.NotFoundByIdException;
import com.example.demo.exception.RepeatedUserException;
import com.example.demo.model.entity.user.User;
import com.example.demo.model.repository.user.UserRepository;
import com.example.demo.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundByIdException(User.class, id));
    }

    @Override
    public User create(User entity) {
        Optional<User> fromDB = getByLoginOrEmail(entity.getLogin(), entity.getEmail());
        if (fromDB.isPresent()) {
            throw new RepeatedUserException(entity);
        }
        return userRepository.save(entity);
    }

    //Hardcode, how to change??????
    @Override
    public User update(User entity) {
        User fromDB = getById(entity.getId());
        fromDB.setEmail(entity.getEmail());
        fromDB.setFullName(entity.getFullName());
        fromDB.setRole(entity.getRole());
        return userRepository.save(fromDB);
    }

    @Override
    public void delete(long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundByIdException(User.class, id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getByLoginOrEmail(String login, String email) {
        logger.warn("Login: " + login + ", email: " + email);
        return userRepository.findByLoginOrEmail(login, email);
    }
}
