package by.fpmi.web.dao.impl;

import by.fpmi.web.dao.AbstractDao;
import by.fpmi.web.dao.DaoException;
import by.fpmi.web.dao.ProjectDefinitionDao;
import by.fpmi.web.model.entity.ProjectDefinition;
import by.fpmi.web.dao.mapper.ProjectDefinitionRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ProjectDefinitionDaoImpl extends AbstractDao<ProjectDefinition> implements ProjectDefinitionDao {
    private static final String TABLE_NAME = "project_definitions";
    public static final String CREATE_PROJECT_DEFINITION = "INSERT INTO project_definitions (description, customer_id) VALUES (?, ?)";
    public static final String FIND_BY_CUSTOMER_ID = "SELECT * FROM project_definitions WHERE customer_id = ?";

    public ProjectDefinitionDaoImpl(Connection connection) {
        super(connection, new ProjectDefinitionRowMapper(), TABLE_NAME);
    }

    @Override
    public List<ProjectDefinition> getByCustomerId(long customerId) throws DaoException {
        return executeQuery(FIND_BY_CUSTOMER_ID, customerId);
    }

    @Override
    public long createIfAbsent(ProjectDefinition definition) throws DaoException {
        Optional<ProjectDefinition> projectDefinition = getById(definition.getId());
        if(!projectDefinition.isPresent()){
           return createProjectDefinition(definition);
        }
        return projectDefinition.get().getId();
    }

    @Override
    public long createProjectDefinition(ProjectDefinition definition) throws DaoException {
       return updateQueryAndGetID(CREATE_PROJECT_DEFINITION, definition.getDescription(), definition.getCustomerId());
    }
}
