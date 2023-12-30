package com.demo.demo.Auth;

import com.demo.demo.User.User;
import com.demo.demo.config.JwtTokenGenerator;
import com.demo.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void signUp(User user){
        Optional<User> userByEmail= userRepository.findUserByEmail(user.getEmail());

        if(userByEmail.isPresent()){
            throw new IllegalStateException("Duplicate User");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.insert(user);
    }

    public AuthResponse signIn(String email, String password) {
        Optional<User> optionalUser = userRepository.findUserByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                String accessToken = JwtTokenGenerator.generateToken(user.getEmail());
                return new AuthResponse(user, accessToken);
            } else {
                throw new IllegalArgumentException("Invalid credentials");
            }
        } else {
            throw new IllegalArgumentException("User not found");
        }


    }

}
