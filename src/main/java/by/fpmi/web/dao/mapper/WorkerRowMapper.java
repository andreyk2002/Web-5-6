package by.fpmi.web.dao.mapper;

import by.fpmi.web.dao.RowMapper;
import by.fpmi.web.model.entity.Qualification;
import by.fpmi.web.model.entity.Worker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;


public class WorkerRowMapper implements RowMapper<Worker> {
    private static final String ID = "ID";
    private static final String NAME = "Name";
    private static final String SURNAME = "Surname";
    private static final String PROJECT_ID = "project_id";
    private static final String PROJECT_QUALIFICATION = "qualification";
    private static final String SALARY = "Salary";
    private static final String IS_FREE = "is_Free";
    private static final String TASK_ID = "task_id";

    @Override
    public Worker map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(ID);
        String name = resultSet.getString(NAME);
        String surname = resultSet.getString(SURNAME);
        long projectId = resultSet.getLong(PROJECT_ID);
        long taskId = resultSet.getLong(TASK_ID);
        String qualification = resultSet.getString(PROJECT_QUALIFICATION);
        Qualification q = Qualification.valueOf(qualification.toUpperCase(Locale.ROOT));
        double salary = resultSet.getDouble(SALARY);
        boolean isFree = resultSet.getBoolean(IS_FREE);
        return new Worker(id, projectId, taskId, surname, name, q, salary, isFree);
    }
}
