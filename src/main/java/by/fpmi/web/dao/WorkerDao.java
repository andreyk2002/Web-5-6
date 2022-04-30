package by.fpmi.web.dao;

import by.fpmi.web.model.entity.Worker;

import java.util.List;

public interface WorkerDao {

    void addWorker(Worker worker) throws DaoException;

    List<Worker> getByTaskId(long projectDefinitionId) throws DaoException;

    List<Worker> getFreeWorkers() throws DaoException;

    void changeWorkerStatus(List<Worker> workers) throws DaoException;

    void addToProject(List<Worker> workers, long taskId, long projectId) throws DaoException;

    List<Worker> getByProjectId(long id) throws DaoException;
}
