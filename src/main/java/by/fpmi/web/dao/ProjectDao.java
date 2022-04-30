package by.fpmi.web.dao;

import by.fpmi.web.model.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectDao {

    List<Project> getUnpaidProjects() throws DaoException;

    void payForProject(long projectId) throws DaoException;

    long createProject(Project project) throws DaoException;

    List<Project> getByCustomerId(long customer) throws DaoException;

    List<Project> getProjects() throws DaoException;

    Optional<Project> getById(long projectId) throws DaoException;
}
