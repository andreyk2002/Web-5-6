package by.fpmi.web.service;

import by.fpmi.web.dao.DaoException;
import by.fpmi.web.dao.DaoHelper;
import by.fpmi.web.dao.DaoHelperFactory;
import by.fpmi.web.dao.UserDao;
import by.fpmi.web.model.entity.User;

import java.util.Optional;

public class UserService {
    private final DaoHelperFactory helperFactory;

    public UserService(DaoHelperFactory helperFactory) {
        this.helperFactory = helperFactory;
    }

    public User login(String username, String password) throws ServiceException {
        try (DaoHelper daoHelper = helperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            Optional<User> loginResult = userDao.login(username, password);
            return loginResult.orElseThrow(() -> new ServiceException("Wrong username or password"));
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public User register(String username, String password) throws ServiceException {
        try (DaoHelper daoHelper = helperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            return userDao.register(username, password);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
