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
        if(findByUserName(user.getUserName()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        userRepository.save(user);
        return user;
    }

    public Optional<User> updateUser( String username, User updateduser) {
        Optional<User> maybeUser = userRepository.findByUserName(username);
        if(maybeUser.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        User user = maybeUser.get();
        user.setPassword(updateduser.getPassword());
        user.setRole(updateduser.getRole());
        userRepository.save(user);
        return Optional.of(user);


    }

}
