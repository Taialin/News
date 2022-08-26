package com.example.news;

import com.example.news.dob.User;
import com.example.news.services.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class UserTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testCreating() {
        User user = new User();
        user.setUserName("Il");
        user.setSecondName("li");
        user.setEmail("ded@gmail.com");
        user.setPassword("$2a$12$qjV5NnJkBBM5SkxLIrW/CuuZi8Sn1ZF4ADq/yKMwSFNhHBP1ZXDK.");
        user.setPhoneNumber("+375257891961");

        User savedUser = userService.save(user);

        User existUser = userService.findUserById(savedUser.getId());
        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());

    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setId(1332323L);
        user.setUserName("Il");
        user.setSecondName("li");
        user.setEmail("ded@gmail.com");
        user.setPassword("$2a$12$qjV5NnJkBBM5SkxLIrW/CuuZi8Sn1ZF4ADq/yKMwSFNhHBP1ZXDK.");
        user.setPhoneNumber("+375257891961");

        User savedUser = userService.save(user);

        userService.deleteUser(savedUser.getId());
        User deletedUser = userService.findUserById(savedUser.getId());
        assertThat(deletedUser).isNull();

    }
}
