package by.fpmi.web.dao;

import by.fpmi.web.model.entity.User;

import java.util.Optional;

public interface UserDao {

  Optional<User> login(String username, String password) throws DaoException;

  User register(String username, String password) throws DaoException;
}
