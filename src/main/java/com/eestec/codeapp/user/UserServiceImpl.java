package com.eestec.codeapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> fetchAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> fetchOne(Long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> save(UserDto userDto) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(userDto.email));
        User user = optionalUser.orElse(new User(userDto));
        userRepository.save(user);
        return Optional.ofNullable(user); //TODO: refactor
    }


    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
