package com.demo.demo.Auth;

import com.demo.demo.User.User;
import lombok.Data;

@Data
public class AuthResponse {
    private User user;
    private String accessToken;

    public AuthResponse(User user, String accessToken) {
        this.user = user;
        this.accessToken = accessToken;
    }


}
