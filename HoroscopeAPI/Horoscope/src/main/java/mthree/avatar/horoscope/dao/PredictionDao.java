package mthree.avatar.horoscope.dao;

import mthree.avatar.horoscope.dto.Prediction;
import mthree.avatar.horoscope.dto.User;

import java.util.List;

public interface PredictionDao {

    Prediction addPrediction(Prediction prediction);
    Prediction getPredictionById(int predictionId);
    Prediction editPrediction(Prediction prediction);
    boolean deletePrediction(Prediction prediction);

    List<Prediction> getPredictionsForUser(String username);

}
