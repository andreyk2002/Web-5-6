package by.fpmi.web.dao.impl;

import by.fpmi.web.dao.AbstractDao;
import by.fpmi.web.dao.DaoException;
import by.fpmi.web.dao.TaskDao;
import by.fpmi.web.model.entity.Task;
import by.fpmi.web.dao.mapper.TaskObjectMapper;

import java.sql.Connection;
import java.util.List;

public class TaskDaoImpl extends AbstractDao<Task> implements TaskDao {
    private static final String TABLE_NAME = "tasks";

    public TaskDaoImpl(Connection connection) {
        super(connection, new TaskObjectMapper(), TABLE_NAME);
    }

    @Override
    public List<Task> getByProjectDefinitionId(long projectDefinitionId) throws DaoException {
        return executeQuery("SELECT * FROM tasks WHERE projectDefinition_id = ?", projectDefinitionId);
    }
}
