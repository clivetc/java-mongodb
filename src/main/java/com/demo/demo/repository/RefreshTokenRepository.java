package com.demo.demo.repository;

import com.demo.demo.User.RefreshToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends MongoRepository<RefreshToken,String> {

    Optional<RefreshToken> findByOwner(String owner);
}
