package by.fpmi.web.dao;

import by.fpmi.web.dao.connection.ConnectionPool;
import by.fpmi.web.dao.connection.ProxyConnection;
import by.fpmi.web.dao.impl.CustomerDaoImpl;
import by.fpmi.web.dao.impl.ProjectDaoImpl;
import by.fpmi.web.dao.impl.ProjectDefinitionDaoImpl;
import by.fpmi.web.dao.impl.TaskDaoImpl;
import by.fpmi.web.dao.impl.WorkerDaoImp;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {
    private final ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) {
        this.connection = pool.getConnection();
    }

    public WorkerDao createWorkerDao() {
        return new WorkerDaoImp(connection);
    }

    public ProjectDao createProjectDao() {
        return new ProjectDaoImpl(connection);
    }

    public CustomerDao createCustomerDao() {
        return new CustomerDaoImpl(connection);
    }

    public TaskDao createTaskDao() {
        return new  TaskDaoImpl(connection);
    }

    public ProjectDefinitionDao createProjectDefinitionDao(){
        return new ProjectDefinitionDaoImpl(connection);
    }

    @Override
    public void close() {
        connection.close();
    }

    public void startTransaction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    public void endTransaction() throws DaoException {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new DaoException();
        }
    }
}
