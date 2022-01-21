package com.fsk.hoxify.service;

import com.fsk.hoxify.entity.User;
import com.fsk.hoxify.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User save(final User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.passwordEncoder = new BCryptPasswordEncoder();
        return userRepository.save(user);
    }
}
