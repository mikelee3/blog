package com.example.blog;

import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This tests equals and hashcode
 */
@SpringBootTest
@Transactional
public class SameRecordsTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void userDetachTest() {
        User user = User.builder().username("notacolor").build();
        entityManager.persist(user);

        User firstFetched = entityManager.find(User.class, user.getId());
        entityManager.detach(firstFetched);

        User secondFetched = entityManager.find(User.class, user.getId());

        Assertions.assertEquals(firstFetched, secondFetched);
    }

    @Test
    void postDetachTest() {
        Post post = Post.builder().title("title").content("content").build();
        entityManager.persist(post);

        Post firstFetched = entityManager.find(Post.class, post.getId());
        entityManager.detach(firstFetched);

        Post secondFetched = entityManager.find(Post.class, post.getId());

        Assertions.assertEquals(firstFetched, secondFetched);
    }

    @Test
    void commentDetachTest() {
        Comment comment = Comment.builder().content("content").build();
        entityManager.persist(comment);

        Comment firstFetched = entityManager.find(Comment.class, comment.getId());
        entityManager.detach(firstFetched);

        Comment secondFetched = entityManager.find(Comment.class, comment.getId());

        Assertions.assertEquals(firstFetched, secondFetched);
    }
}
