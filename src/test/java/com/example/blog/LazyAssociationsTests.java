package com.example.blog;

import com.example.blog.entity.User;
import com.example.blog.repository.UserRepository;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUtil;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

/**
 * This test validates that the toString annotations are correct - that collections are excluded.
 */
@SpringBootTest
@Transactional
public class LazyAssociationsTests {

    private final PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();
    @Autowired
    private UserRepository userRepository;

    @Test
    @Sql(scripts = "classpath:insert-user-with-posts.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:delete-user-with-posts.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void toStringLazyTest() {
        User user = userRepository.findById(0L).orElseThrow();
        Assertions.assertFalse(persistenceUtil.isLoaded(user.getPosts()));
        Assertions.assertFalse(persistenceUtil.isLoaded(user.getComments()));

        String s = user.toString();
        System.out.println("User: " + s);

        Assertions.assertFalse(persistenceUtil.isLoaded(user.getPosts()));
        Assertions.assertFalse(persistenceUtil.isLoaded(user.getComments()));
    }
}
