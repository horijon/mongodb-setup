package com.kk.mongodbsetup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@EnableMongoRepositories(basePackages = "com.kk")
@SpringBootApplication
public class MongoDbSetupApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbSetupApplication.class, args);
    }

}
