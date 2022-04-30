package by.fpmi.web.dao;

import by.fpmi.web.model.entity.User;

public interface UserDao {

  User login(String username, String password);

  User register(String username, String password);
}
