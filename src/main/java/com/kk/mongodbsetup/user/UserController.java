package com.kk.mongodbsetup.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private MongoTemplate mongoTemplate;
    private UserRepository userRepository;

    public UserController(MongoTemplate mongoTemplate, UserRepository userRepository) {
        this.mongoTemplate = mongoTemplate;
        this.userRepository = userRepository;
    }

    @GetMapping
    public void doSomething() {
        userRepository.deleteAll();
        User user = new User();
        user.setName("Shon");
        mongoTemplate.insert(user, "user");
        for (int i = 0; i < 10; i++) {
            User user0 = new User();
            user0.setName("Jon" + i);
            mongoTemplate.insert(user0, "user");
        }
        User user1 = new User();
        user1.setName("Albert");
        mongoTemplate.save(user1, "user");

        User user2 = new User();
        user2.setName("Jack");
        mongoTemplate.save(user2, "user");

        User user3 = mongoTemplate.findOne(
                Query.query(Criteria.where("name").is("Jack")), User.class);
        user3.setName("Jim");
        mongoTemplate.save(user3, "user");


        mongoTemplate.remove(user, "user");
        userRepository.delete(user1);
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        LOGGER.info("users = {}", users);

        Pageable pageableRequest = PageRequest.of(0, 2);
        Page<User> page = userRepository.findAll(pageableRequest);
        List<User> users1 = page.getContent();
        LOGGER.info("users1 = {}", users1);

        Pageable pageableRequest1 = PageRequest.of(2, 2);
        Page<User> page1 = userRepository.findAll(pageableRequest1);
        List<User> users2 = page1.getContent();
        LOGGER.info("users2 = {}", users2);
    }
}
