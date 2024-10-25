package com.example.blog;

import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class ProxyEqualsHashcodeTests {

    @Autowired
    private EntityManager entityManager;

    @Test
    void testUserProxyEqualsHashcode() {
        EntityTestUtils.assertEntityProxyBehaviorForSets(User.class, 1L, entityManager);
    }

    @Test
    void testCommentProxyEqualsHashcode() {
        EntityTestUtils.assertEntityProxyBehaviorForSets(Comment.class, 1L, entityManager);
    }

    @Test
    void testPostProxyEqualsHashcode() {
        EntityTestUtils.assertEntityProxyBehaviorForSets(Post.class, 2L, entityManager);
    }

}
