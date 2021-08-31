package com.kk.mongodbsetup.user;

import com.kk.mongodbsetup.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // 
}