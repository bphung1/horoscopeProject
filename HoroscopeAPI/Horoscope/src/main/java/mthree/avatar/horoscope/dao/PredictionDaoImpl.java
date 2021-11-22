package mthree.avatar.horoscope.dao;

import mthree.avatar.horoscope.dto.Prediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Component
public class PredictionDaoImpl implements PredictionDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    @Transactional
    public Prediction addPrediction(Prediction prediction) {
        final String INSERT_PREDICTION = "INSERT INTO predictions(username, timestamp, horoscope, " +
                                                                "fortuneCookie, luckyNumbers, luckySportsTeam, " +
                                                                "luckyMovie, jokeOfTheDay) VALUES (?,?,?,?,?,?,?,?);";

        jdbc.update(INSERT_PREDICTION,
                prediction.getUsername(),
                Timestamp.valueOf(prediction.getTimestamp()),
                prediction.getHoroscope(),
                prediction.getFortuneCookie(),
                prediction.getLuckyNumbers(),
                prediction.getLuckySportsTeam(),
                prediction.getLuckyMovie(),
                prediction.getJokeOfTheDay());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        prediction.setPredictionId(newId);

        return prediction;
    }

    @Override
    public Prediction getPredictionById(int predictionId) {
        try {
            final String SELECT_PREDICTION_BY_ID = "SELECT * FROM predictions WHERE predictionID = ?";
            Prediction prediction = jdbc.queryForObject(SELECT_PREDICTION_BY_ID, new PredictionMapper(), predictionId);

            return prediction;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public boolean deletePrediction(Prediction prediction) {
        final String DELETE_PREDICTION = "DELETE FROM predictions WHERE predictionID = ?";

        return jdbc.update(DELETE_PREDICTION, prediction.getPredictionId()) > 0;
    }

    @Override
    public List<Prediction> getPredictionsForUser(String username) {
        final String SELECT_PREDICTIONS_FOR_USER = "SELECT * FROM predictions "
                + "WHERE username = ?";

        List<Prediction> predictions = jdbc.query(SELECT_PREDICTIONS_FOR_USER, new PredictionMapper(), username);

        return predictions;
    }

    public static final class PredictionMapper implements RowMapper<Prediction> {

        @Override
        public Prediction mapRow(ResultSet rs, int index) throws SQLException {
            Prediction pred = new Prediction();
            pred.setPredictionId(rs.getInt("predictionID"));
            pred.setUsername(rs.getString("username"));
            pred.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
            pred.setHoroscope(rs.getString("horoscope"));
            pred.setFortuneCookie(rs.getString("fortuneCookie"));
            pred.setLuckyNumbers(rs.getInt("luckyNumbers"));
            pred.setLuckySportsTeam(rs.getString("luckySportsTeam"));
            pred.setLuckyMovie(rs.getString("luckyMovie"));
            pred.setJokeOfTheDay(rs.getString("jokeOfTheDay"));

            return pred;

        }
    }
}
