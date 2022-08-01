package com.example.news.Controllers;

import com.example.news.dob.User;
import com.example.news.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class UserControllerTest {

    @Autowired
    private UserService userService;

    @Test
    void userList() {
        User user = new User();

    }

    @Test
    void getUser() {
    }

    @Test
    public void icanIFind() {
        User user = new User();
        user.setUserName("Nn");
        user.setPassword("");
        userService.save(user);
        user = userService.findUserById(4L);
        assertThat(user).hasFieldOrPropertyWithValue("userName","Nn");


    }
}