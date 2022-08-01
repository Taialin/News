package com.example.news.services;

import com.example.news.Controllers.UserController;
import com.example.news.dob.User;
import com.example.news.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserController userController;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;



    @Test
    void allUsers() {
    }

    @Test
    void save() {
    }
}