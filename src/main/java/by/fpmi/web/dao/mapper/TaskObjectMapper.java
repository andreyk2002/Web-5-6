package by.fpmi.web.dao.mapper;

import by.fpmi.web.dao.RowMapper;
import by.fpmi.web.model.entity.Qualification;
import by.fpmi.web.model.entity.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskObjectMapper implements RowMapper<Task> {
    private static final String ID = "ID";
    private static final String PROJECT_DEFINITION_ID = "project_definition_id";
    public static final String MIN_QUALIFICATION = "min_qualification";
    public static final String WORKERS_COUNT = "workers_count";

    @Override
    public Task map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(ID);
        long projectDefinitionId = resultSet.getLong(PROJECT_DEFINITION_ID);
        Qualification minQualification = Qualification.valueOf(resultSet.getString(MIN_QUALIFICATION));
        int workersCount = resultSet.getInt(WORKERS_COUNT);
        return new Task(id, projectDefinitionId, minQualification, workersCount);
    }
}
