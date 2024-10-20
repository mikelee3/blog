package com.example.blog;

import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import com.example.blog.repository.CommentRepository;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class BuilderConstructorTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    void builderTest() {
        User author = User.builder().build();
        userRepository.save(author);

        Post post = Post.builder().author(author).build();
        postRepository.save(post);

        Comment comment = Comment.builder().author(author).build();
        commentRepository.save(comment);
    }

    @Test
    void noArgsConstructorTest() {
        User author = new User();
        userRepository.save(author);

        Post post = new Post();
        post.setAuthor(author);
        postRepository.save(post);

        Comment comment = new Comment();
        comment.setAuthor(author);
        commentRepository.save(comment);
    }

    /**
     * For this test, JPA Buddy recommends having both AllArgsConstructor and NoArgsConstructor
     * if you have Builder.
     */
    @Disabled("Unsure where to use this - hard-coding generated ids does not make sense")
    @Test
    void allArgsConstructorTest() {
        User author = new User(111L, null, null);
        userRepository.save(author);

        Post post = new Post(1L, author);
        postRepository.save(post);

        Comment comment = new Comment(1L, author);
        commentRepository.save(comment);
    }
}
