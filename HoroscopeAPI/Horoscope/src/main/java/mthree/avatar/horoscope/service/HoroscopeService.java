package mthree.avatar.horoscope.service;

import mthree.avatar.horoscope.dao.PredictionDao;
import mthree.avatar.horoscope.dao.UserDao;
import mthree.avatar.horoscope.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoroscopeService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PredictionDao predictionDao;

    public User createAccount(User user) {
        if (userDao.getUserByUsername(user.getUsername()) == null) {
            return null;
        }
        else {
            return userDao.addUser(user);
        }
    }
}
