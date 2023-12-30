package com.demo.demo.User;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class User {
    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String password;
    private LocalDateTime createdAt;

    public User( String email, String firstName, String lastName, String password, LocalDateTime createdAt) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.createdAt = createdAt;
    }
}
