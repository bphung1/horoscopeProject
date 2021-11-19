package mthree.avatar.horoscope.dao;

import mthree.avatar.horoscope.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbc;
    @Autowired
    PredictionDao predictionDao;

    @Override
    public User addUser(User user) {
        final String INSERT_USER = "INSERT INTO users(username, password, name, birthday) VALUES (?,?,?,?);";

        jdbc.update(INSERT_USER,
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                Date.valueOf(user.getBirthday()));

        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            final String SELECT_USER_BY_USERNAME = "Select * FROM users WHERE username = ?";

            User user = jdbc.queryForObject(SELECT_USER_BY_USERNAME, new UserMapper(), username);
            user.setPredictions(predictionDao.getPredictionsForUser(user.getUsername()));

            return user;
        } catch (DataAccessException ex) {
            return null;
        }

    }

    @Override
    public User editUser(User user) {

        final String EDIT_USER = "UPDATE users SET password = ?, name = ?, birthday = ? "
                + "WHERE username = ?;";

        jdbc.update(EDIT_USER,
                user.getPassword(),
                user.getName(),
                Date.valueOf(user.getBirthday()));

        return user;
    }

    @Override
    public boolean deleteUser(User user) {

        final String DELETE_USER_PREDICTIONS = "DELETE FROM predictions "
                + "WHERE username = ?;";
        jdbc.update(DELETE_USER_PREDICTIONS, user.getUsername());

        final String DELETE_USER = "DELETE FROM users WHERE username = ?;";

        return jdbc.update(DELETE_USER, user.getUsername()) > 0;
    }

    public static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int index) throws SQLException {
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setBirthday(rs.getDate("birthday").toLocalDate());

            return user;
        }
    }
}
