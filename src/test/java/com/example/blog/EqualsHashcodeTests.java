package com.example.blog;

import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class EqualsHashcodeTests {

    @Test
    void testCommentEqualsHashcode() {
        EqualsVerifier.forClass(Comment.class)
                .withPrefabValues(User.class, User.builder().username("red").build(), User.builder().username("yellow").build())
                .verify();
    }

    @Test
    void testPostEqualsHashcode() {
        EqualsVerifier.forClass(Post.class)
                .withPrefabValues(User.class, User.builder().username("red").build(), User.builder().username("yellow").build())
                .verify();
    }

    @Test
    void testUserEqualsHashcode() {
        EqualsVerifier.forClass(User.class)
                .withPrefabValues(User.class, User.builder().username("red").build(), User.builder().username("yellow").build())
                .verify();
    }
}
