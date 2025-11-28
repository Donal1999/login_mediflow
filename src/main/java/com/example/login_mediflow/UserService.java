package com.example.login_mediflow;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User createUser(User user) {
       User user1 = userRepository.save(user);
       return user1;
    }
}
