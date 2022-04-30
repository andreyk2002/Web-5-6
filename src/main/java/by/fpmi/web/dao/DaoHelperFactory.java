package by.fpmi.web.dao;

import by.fpmi.web.dao.connection.ConnectionPool;

public class DaoHelperFactory {
    public DaoHelper create() throws DaoException {
        return new DaoHelper(ConnectionPool.getInstance());
    }
}
