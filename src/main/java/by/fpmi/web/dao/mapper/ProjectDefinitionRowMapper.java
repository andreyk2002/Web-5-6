package by.fpmi.web.dao.mapper;

import by.fpmi.web.dao.RowMapper;
import by.fpmi.web.model.entity.ProjectDefinition;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProjectDefinitionRowMapper implements RowMapper<ProjectDefinition> {
    private static final String ID = "ID";
    private static final String CUSTOMER_ID = "customer_id";
    public static final String DESCRIPTION = "Description";

    @Override
    public ProjectDefinition map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(ID);
        long customerId = resultSet.getLong(CUSTOMER_ID);
        String description = resultSet.getString(DESCRIPTION);
        return new ProjectDefinition(id, customerId, description);
    }
}
