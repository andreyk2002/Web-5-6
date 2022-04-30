package by.fpmi.web.dao.impl;

import by.fpmi.web.dao.AbstractDao;
import by.fpmi.web.dao.DaoException;
import by.fpmi.web.dao.WorkerDao;
import by.fpmi.web.model.entity.Worker;
import by.fpmi.web.dao.mapper.WorkerRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class WorkerDaoImp extends AbstractDao<Worker> implements WorkerDao {
    private static final String TABLE_NAME = "workers";
    public static final String ADD_WORKER = "INSERT INTO workers (project_id, task_id, surname, name, qualification, salary, is_free) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String FIND_BY_TASK_ID = "SELECT * FROM workers WHERE task_id = ?";
    public static final String FIND_FREE_WORKERS = "SELECT * FROM workers WHERE is_free = true";
    public static final String CHANGE_STATUS = "UPDATE workers SET is_free = 0 WHERE id IN (%s)";
    public static final String ADD_PROJECT = "UPDATE workers SET is_free = 0, project_id = ?, task_id = ? WHERE ID IN (%s)";
    public static final String FIND_WORKERS_BY_PROJECT = "SELECT * FROM workers WHERE project_id = ?";

    public WorkerDaoImp(Connection connection) {
        super(connection, new WorkerRowMapper(), TABLE_NAME);
    }

    @Override
    public void addWorker(Worker worker) throws DaoException {
        updateQuery(ADD_WORKER, -1, 0, worker.getSurname(), worker.getName(),
                worker.getQualification(), worker.getSalary(), true);
    }

    @Override
    public List<Worker> getByTaskId(long taskId) throws DaoException {
        return executeQuery(FIND_BY_TASK_ID, taskId);
    }

    @Override
    public List<Worker> getFreeWorkers() throws DaoException {
        return executeQuery(FIND_FREE_WORKERS);
    }

    @Override
    public void changeWorkerStatus(List<Worker> workers) throws DaoException {
        StringBuilder idString = buildRange(workers);

        String query = String.format(CHANGE_STATUS, idString);
        updateQuery(query);
    }

    @Override
    public void addToProject(List<Worker> workers, long taskId, long projectId) throws DaoException {
        StringBuilder stringBuilder = buildRange(workers);
        String query = String.format(ADD_PROJECT, stringBuilder);
        updateQuery(query, projectId, taskId);
    }

    @Override
    public List<Worker> getByProjectId(long id) throws DaoException {
        return executeQuery(FIND_WORKERS_BY_PROJECT, id);
    }

    private StringBuilder buildRange(List<Worker> workers) {
        List<Long> ids = workers.stream().map(Worker::getId).collect(Collectors.toList());
        StringBuilder idString = new StringBuilder();
        for (int i = 0; i < ids.size(); i++) {
            idString.append(ids.get(i));
            if (i != ids.size() - 1) {
                idString.append(",");
            }
        }
        return idString;
    }


}
