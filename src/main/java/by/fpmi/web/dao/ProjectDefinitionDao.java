package by.fpmi.web.dao;

import by.fpmi.web.model.entity.ProjectDefinition;

import java.util.List;
import java.util.Optional;

public interface ProjectDefinitionDao {
    List<ProjectDefinition> getByCustomerId(long customerId) throws DaoException;

    long createIfAbsent(ProjectDefinition definition) throws DaoException;

    long createProjectDefinition(ProjectDefinition definition) throws DaoException;

    Optional<ProjectDefinition> getById(long projectDefinitionId) throws DaoException;
}
