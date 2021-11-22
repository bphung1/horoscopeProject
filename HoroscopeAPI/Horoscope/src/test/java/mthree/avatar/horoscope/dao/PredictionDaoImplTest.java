package mthree.avatar.horoscope.dao;

import mthree.avatar.horoscope.dto.Prediction;
import mthree.avatar.horoscope.dto.User;
import org.junit.jupiter.api.BeforeEach;
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
class PredictionDaoImplTest {

    @Autowired
    UserDao userDao;
    @Autowired
    JdbcTemplate jdbc;
    @Autowired
    PredictionDao predictionDao;

    @BeforeEach
    void setUp() {
        jdbc.update("DELETE FROM predictions;");
        jdbc.update("DELETE FROM users;");
    }

    @Test
    void testAddGetPrediction() {
        User user = new User();
        user.setUsername("some_guy");
        user.setPassword("password");
        user.setName("Some Guy");
        LocalDate bDay = LocalDate.parse("1996-01-20");
        user.setBirthday(bDay);
        user.setPredictions(new ArrayList<Prediction>());
        user = userDao.addUser(user);

        Prediction pred = new Prediction();
        pred.setUsername("some_guy");
        pred.setTimestamp(LocalDateTime.now().withNano(0));
        pred.setHoroscope("Something will happen");
        pred = predictionDao.addPrediction(pred);

        Prediction fromDao = predictionDao.getPredictionById(pred.getPredictionId());

        assertEquals(pred, fromDao);
    }

    @Test
    void deletePrediction() {
        User user = new User();
        user.setUsername("some_guy");
        user.setPassword("password");
        user.setName("Some Guy");
        LocalDate bDay = LocalDate.parse("1996-01-20");
        user.setBirthday(bDay);
        user.setPredictions(new ArrayList<Prediction>());
        user = userDao.addUser(user);

        Prediction pred = new Prediction();
        pred.setUsername("some_guy");
        pred.setTimestamp(LocalDateTime.now().withNano(0));
        pred.setHoroscope("Something will happen");
        pred = predictionDao.addPrediction(pred);

        predictionDao.deletePrediction(pred);

        Prediction fromDao = predictionDao.getPredictionById(pred.getPredictionId());

        assertNull(fromDao);
    }

    @Test
    void getPredictionsForUser() {
        User user = new User();
        user.setUsername("some_guy");
        user.setPassword("password");
        user.setName("Some Guy");
        LocalDate bDay = LocalDate.parse("1996-01-20");
        user.setBirthday(bDay);
        user.setPredictions(new ArrayList<Prediction>());
        user = userDao.addUser(user);

        Prediction pred = new Prediction();
        pred.setUsername("some_guy");
        pred.setTimestamp(LocalDateTime.now().withNano(0));
        pred.setHoroscope("Something will happen");
        pred = predictionDao.addPrediction(pred);

        Prediction pred2 = new Prediction();
        pred2.setUsername("some_guy");
        pred2.setTimestamp(LocalDateTime.now().withNano(0));
        pred2.setHoroscope("It gets worse before it gets even more worse");
        pred2 = predictionDao.addPrediction(pred2);

        List<Prediction> predictions = predictionDao.getPredictionsForUser(user.getUsername());

        assertEquals(2, predictions.size());
        assertTrue(predictions.contains(pred));
        assertTrue(predictions.contains(pred2));
    }
}