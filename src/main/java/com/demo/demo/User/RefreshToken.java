package com.demo.demo.User;

import com.demo.demo.User.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

public class RefreshToken {
    @Id
    private String id;
    @DocumentReference
    private User owner;
}
