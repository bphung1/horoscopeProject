package mthree.avatar.horoscope.service;

import mthree.avatar.horoscope.dao.PredictionDao;
import mthree.avatar.horoscope.dao.UserDao;
import mthree.avatar.horoscope.dto.Prediction;
import mthree.avatar.horoscope.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public User login(User user) {
        User fetchedUserInfo = userDao.getUserByUsername(user.getUsername());
        if (fetchedUserInfo == null || !matchPassword(user.getPassword(), fetchedUserInfo.getPassword())) {
            return null;
        }
        else {
            return fetchedUserInfo;
        }
    }

    public void generateHoroscope(User user) {

    }

    public List<Prediction> getAllHoroscopes(String username) {
        return predictionDao.getPredictionsForUser(username);
    }

    public User updateUserInfo(User user) {
        return userDao.editUser(user);
    }

    public boolean deleteHoroscope(Prediction prediction) {
        return predictionDao.deletePrediction(prediction);
    }


    private boolean matchPassword(String submittedPass, String fetchedPass) {
        return submittedPass.equals(fetchedPass);
    }
}
