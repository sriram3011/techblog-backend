package org.blog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.blog.model.Comment;
import org.blog.model.Post;
import org.blog.model.User;
import org.blog.repository.CommentRepository;
import org.blog.repository.PostRepository;
import org.blog.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogRestApiBackendApplicationTests {
   @Autowired
    PostRepository postRepository;
   @Autowired
    UserRepository userRepository;
   @Autowired
   CommentRepository commentRepository;
   
    @Test
    @Order(2)
    public void getPostTest()throws IOException ,SQLException ,ClassNotFoundException {
        List<Post> post = postRepository.findAll();
        assertThat(post).size().isGreaterThan(0);
        
        }
    
    @Test
    
    public void getPostsbyCategoryTest()throws IOException ,SQLException ,ClassNotFoundException {
        List<Post> post = postRepository.findByCategoryId(5);
        assertThat(post).size().isGreaterThan(0);
    }
    @Test
    @Disabled
    public void getPostsbyUserIdTest() throws IOException ,SQLException ,ClassNotFoundException{
        List<Post> post = postRepository.findPostsByUserId(2209);
        assertNotEquals(2203,post);
    }
    @Test
    @Disabled
    public void getCommentsbyPostIdTest()throws IOException ,SQLException ,ClassNotFoundException {
        List<Comment> comment = commentRepository.findBypost((long) 1234);
        assertEquals("Thank you.",comment);
    }
    @Test
    public void getCommentsbyPostIdTest1() throws IOException ,SQLException ,ClassNotFoundException{
        List<Comment> comment = commentRepository.findBypost((long) 1252);
        assertNotNull(comment);
    }
    @Test()
    @Disabled
    public void getCommentsbyPostIdTest2()throws IOException ,SQLException ,ClassNotFoundException {
        List<Comment> comment = commentRepository.findBypost((long) 1253);
        assertNull(comment);
    }
    @Test
    @Disabled
    @Order(2)
    public void getUserbyEmailTest()throws IOException ,SQLException ,ClassNotFoundException {
        Optional<User> user = userRepository.findByuserEmail("fareedh@gmail.com");
        assertSame(user,"guna@gmail.com");
    }
    @Test
    @Order(3)
    public void getUserbyEmailTest1()throws IOException ,SQLException ,ClassNotFoundException{
        Optional<User> user = userRepository.findByuserEmail("sriram@gmail.com");
        assertNotSame(user,"fareedh@gmail.com");
    }
}