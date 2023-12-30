package com.demo.demo.Auth;

import com.demo.demo.User.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/auth/signup")
    public void signUp(@RequestBody User user){
        authService.signUp(user);
    }

    @PostMapping(path = "/auth/login")
    public AuthResponse signIn(@RequestBody AuthRequest authRequest){
        return  authService.signIn(authRequest.getEmail(), authRequest.getPassword());
    }

}
