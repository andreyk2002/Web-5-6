package by.fpmi.web.dao.impl;

import by.fpmi.web.dao.AbstractDao;
import by.fpmi.web.dao.DaoException;
import by.fpmi.web.dao.ProjectDao;
import by.fpmi.web.model.entity.Project;
import by.fpmi.web.dao.mapper.ProjectRowMapper;

import java.sql.Connection;
import java.util.List;

public class ProjectDaoImpl extends AbstractDao<Project> implements ProjectDao {
    private static final String TABLE_NAME = "projects";
    private static final String SELECT_INPAID_PROJECTS = "SELECT * From projects where is_paid_by_customer=false";
    public static final String PAY_QUERY = "UPDATE projects SET is_paid_by_customer=true WHERE ID = ?";
    public static final String CREATE_PROJECT = "INSERT into projects (project_name, project_definition_id, customer_id, paid_by_customer) VALUES (?, ?, ?, ?)";
    public static final String FIND_BY_CUSTOMER = "SELECT * FROM projects WHERE customer_id = ?";
    public static final String GET_ALL_QUERY = "SELECT * FROM projects";

    public ProjectDaoImpl(Connection connection) {
        super(connection, new ProjectRowMapper(), TABLE_NAME);
    }


    @Override
    public List<Project> getUnpaidProjects() throws DaoException {
        return executeQuery(SELECT_INPAID_PROJECTS);
    }

    @Override
    public void payForProject(long projectId) throws DaoException {
        updateQuery(PAY_QUERY, projectId);
    }

    @Override
    public long createProject(Project project) throws DaoException {
        return updateQueryAndGetID(CREATE_PROJECT, project.getProjectName(), project.getProjectDefinitionId(), project.getCustomerId(), project.isPaidByCustomer());
    }

    @Override
    public List<Project> getByCustomerId(long customerId) throws DaoException {
        return executeQuery(FIND_BY_CUSTOMER, customerId);
    }

    @Override
    public List<Project> getProjects() throws DaoException {
        return executeQuery(GET_ALL_QUERY);
    }
}
