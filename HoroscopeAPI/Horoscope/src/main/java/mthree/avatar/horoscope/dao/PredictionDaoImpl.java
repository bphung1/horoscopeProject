package mthree.avatar.horoscope.dao;

import mthree.avatar.horoscope.dto.Prediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PredictionDaoImpl implements PredictionDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Prediction addPrediction(Prediction prediction) {
        return null;
    }

    @Override
    public Prediction getPredictionById(int predictionId) {
        return null;
    }

    @Override
    public Prediction editPrediction(Prediction prediction) {
        return null;
    }

    @Override
    public boolean deletePrediction(Prediction prediction) {
        return false;
    }

    @Override
    public List<Prediction> getPredictionsForUser(String username) {
        return null;
    }
}
