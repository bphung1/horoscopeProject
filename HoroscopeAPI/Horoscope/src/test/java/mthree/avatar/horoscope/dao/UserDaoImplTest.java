package mthree.avatar.horoscope.dao;

import mthree.avatar.horoscope.dto.Prediction;
import mthree.avatar.horoscope.dto.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserDaoImplTest {

    @Autowired
    UserDao userDao;
    @Autowired
    JdbcTemplate jdbc;
    @Autowired
    PredictionDao predictionDao;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        jdbc.update("DELETE FROM predictions;");
        jdbc.update("DELETE FROM users;");
    }

    @Test
    public void testAddGetUser() {
        User user = new User();
        user.setUsername("swaglord");
        user.setPassword("password");
        user.setName("Joe Mama");
        LocalDate bDay = LocalDate.parse("1999-12-25");
        user.setBirthday(bDay);
        user.setPredictions(new ArrayList<Prediction>());
        user = userDao.addUser(user);

        User fromDao = userDao.getUserByUsername(user.getUsername());

        assertEquals(user, fromDao);

    }

    @org.junit.jupiter.api.Test
    void editUser() {
        User user = new User();
        user.setUsername("swaglord");
        user.setPassword("password");
        user.setName("Joe Mama");
        LocalDate bDay = LocalDate.parse("1999-12-25");
        user.setBirthday(bDay);
        user.setPredictions(new ArrayList<Prediction>());
        user = userDao.addUser(user);

        User fromDao = userDao.getUserByUsername(user.getUsername());

        assertEquals(user, fromDao);

        user.setName("Steve Jobs");

        userDao.editUser(user);

        assertNotEquals(user, fromDao);

        fromDao = userDao.getUserByUsername(user.getUsername());

        assertEquals(user, fromDao);
    }

    @org.junit.jupiter.api.Test
    void deleteUser() {
        User user = new User();
        user.setUsername("swaglord");
        user.setPassword("password");
        user.setName("Joe Mama");
        LocalDate bDay = LocalDate.parse("1999-12-25");
        user.setBirthday(bDay);
        user.setPredictions(new ArrayList<Prediction>());
        user = userDao.addUser(user);

        Prediction pred = new Prediction();
        pred.setHoroscope("Do better");
        pred.setTimestamp(LocalDateTime.now().withNano(0));
        pred.setUsername("swaglord");
        pred = predictionDao.addPrediction(pred);

        userDao.deleteUser(user);

        User fromDao = userDao.getUserByUsername(user.getUsername());

        assertNull(fromDao);
    }
}