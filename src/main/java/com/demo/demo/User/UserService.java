package com.demo.demo.User;

import com.demo.demo.Student.Student;
import com.demo.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }



}
