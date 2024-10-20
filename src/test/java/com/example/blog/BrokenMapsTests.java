package com.example.blog;

import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import com.example.blog.repository.CommentRepository;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: write what specifically this tests for annotations on entity.
 */
@SpringBootTest
public class BrokenMapsTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    void userSetTest() {
        User user = new User();
        Set<User> set = new HashSet<>();
        set.add(user);

        userRepository.save(user);

        Assertions.assertTrue(set.contains(user));
    }

    @Test
    void postSetTest() {
        Post post = new Post();
        Set<Post> set = new HashSet<>();
        set.add(post);

        postRepository.save(post);

        Assertions.assertTrue(set.contains(post));
    }

    @Test
    void commentSetTest() {
        Comment comment = new Comment();
        Set<Comment> set = new HashSet<>();
        set.add(comment);

        commentRepository.save(comment);

        Assertions.assertTrue(set.contains(comment));
    }
}
