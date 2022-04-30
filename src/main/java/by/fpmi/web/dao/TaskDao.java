package by.fpmi.web.dao;

import by.fpmi.web.model.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskDao {

    List<Task> getByProjectDefinitionId(long projectDefinitionId) throws DaoException;

    Optional<Task> getById(long taskId) throws DaoException;
}
