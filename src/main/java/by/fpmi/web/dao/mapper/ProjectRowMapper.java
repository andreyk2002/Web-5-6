package by.fpmi.web.dao.mapper;

import by.fpmi.web.dao.RowMapper;
import by.fpmi.web.model.entity.Project;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProjectRowMapper implements RowMapper<Project> {
    private static final String ID = "ID";
    private static final String NAME = "project_name";
    private static final String PAID_BY_CUSTOMER = "is_paid_by_customer";
    private static final String PROJECT_DEFINITION_ID = "project_definition_id";
    public static final String CUSTOMER_ID = "customer_id";

    @Override
    public Project map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(ID);
        String name = resultSet.getString(NAME);
        boolean paidByCustomer = resultSet.getBoolean(PAID_BY_CUSTOMER);
        long projectDefId = resultSet.getLong(PROJECT_DEFINITION_ID);
        long customerId = resultSet.getLong(CUSTOMER_ID);
        return new Project(id, projectDefId, name, customerId, paidByCustomer);
    }
}
