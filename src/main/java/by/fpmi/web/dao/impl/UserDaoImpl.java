package by.fpmi.web.dao.impl;

import by.fpmi.web.dao.AbstractDao;
import by.fpmi.web.dao.DaoException;
import by.fpmi.web.dao.UserDao;
import by.fpmi.web.dao.mapper.UserMapper;
import by.fpmi.web.model.entity.User;

import java.sql.Connection;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

  public static final String FIND_USER = "SELECT * FROM user where username = ? and password = md5(?)";

  public UserDaoImpl(Connection connection) {
    super(connection, new UserMapper(), "user");
  }

  @Override
  public Optional<User> login(String username, String password) throws DaoException {
    return executeForSingleResult(FIND_USER);
  }

  @Override
  public User register(String username, String password) throws DaoException {
    long userId = updateQueryAndGetID("INSERT INTO user (name, password, role) values (? , md5(?), USER)");
    return getById(userId).get();
  }
}
