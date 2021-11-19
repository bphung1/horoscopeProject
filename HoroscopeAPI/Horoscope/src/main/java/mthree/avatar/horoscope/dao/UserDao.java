package mthree.avatar.horoscope.dao;

import mthree.avatar.horoscope.dto.User;

public interface UserDao {

    User addUser(User user);
    User getUserByUsername(String username);
    User editUser(User user);
    boolean deleteUser(User user);

}
