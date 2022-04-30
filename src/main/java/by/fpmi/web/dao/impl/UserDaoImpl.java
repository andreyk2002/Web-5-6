package by.fpmi.web.dao.impl;

import by.fpmi.web.dao.AbstractDao;
import by.fpmi.web.dao.RowMapper;
import by.fpmi.web.dao.UserDao;
import by.fpmi.web.dao.mapper.UserMapper;
import by.fpmi.web.model.entity.User;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {


  public UserDaoImpl(Connection connection) {
    super(connection, new UserMapper(), "user");
  }

  @Override
  public User login(String username, String password) {
    return null;
  }

  @Override
  public User register(String username, String password) {
    return null;
  }
}
