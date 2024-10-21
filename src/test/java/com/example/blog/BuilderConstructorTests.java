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
        User author = User.builder().username("bobby").build();
        userRepository.save(author);

        Post post = Post.builder().author(author).title("Post Title").content("Post Content").build();
        postRepository.save(post);

        Comment comment = Comment.builder().author(author).content("Comment Content").build();
        commentRepository.save(comment);
    }

    @Test
    void noArgsConstructorTest() {
        User author = new User();
        author.setUsername("bobby");
        userRepository.save(author);

        Post post = new Post();
        post.setAuthor(author);
        post.setTitle("Post Title");
        post.setContent("Post Content");
        postRepository.save(post);

        Comment comment = new Comment();
        comment.setAuthor(author);
        comment.setContent("Comment Content");
        commentRepository.save(comment);
    }

    /**
     * For this test, JPA Buddy recommends having both AllArgsConstructor and NoArgsConstructor
     * if you have Builder.
     */
    @Disabled("Unsure where to use this - hard-coding generated ids does not make sense")
    @Test
    void allArgsConstructorTest() {
        User author = new User("bobby", null, null);
        userRepository.save(author);

        Post post = new Post("My First Post", "My post content", author);
        postRepository.save(post);

        Comment comment = new Comment("My comment content", author);
        commentRepository.save(comment);
    }
}
