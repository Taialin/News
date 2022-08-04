package com.example.news;

import com.example.news.dob.User;
import com.example.news.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void  testCreating() {
        User user = new User();
        user.setUserName("Il");
        user.setSecondName("li");
        user.setEmail("ded@gmail.com");
        user.setPassword("$2a$12$qjV5NnJkBBM5SkxLIrW/CuuZi8Sn1ZF4ADq/yKMwSFNhHBP1ZXDK.");
        user.setPhoneNumber("+375257891961");

        User savedUser = userRepository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());
        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());

    }
}
