package by.fpmi.web.service;

import by.fpmi.web.dao.DaoException;
import by.fpmi.web.dao.DaoHelper;
import by.fpmi.web.dao.DaoHelperFactory;
import by.fpmi.web.dao.ProjectDao;
import by.fpmi.web.dao.TaskDao;
import by.fpmi.web.dao.WorkerDao;
import by.fpmi.web.model.entity.Project;
import by.fpmi.web.model.entity.Qualification;
import by.fpmi.web.model.entity.Task;
import by.fpmi.web.model.entity.Worker;
import by.fpmi.web.model.dto.WorkerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorkersService {
    public static final Task DEFAULT_TASK = new Task(-1, -1, Qualification.LOW, 0);
    public static final Project DEFAULT_PROJECT = new Project(-1, -1,
            "No project assigned to the worker", -1, false);
    private final DaoHelperFactory factory;

    public WorkersService(DaoHelperFactory factory) {
        this.factory = factory;
    }

    public List<WorkerDto> getFreeWorkers() throws ServiceException {
        try (DaoHelper helper = factory.create()) {
            WorkerDao workerDao = helper.createWorkerDao();
            List<Worker> workers = workerDao.getFreeWorkers();
            return getWorkersDtos(workers);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private List<WorkerDto> getWorkersDtos(List<Worker> workers) throws ServiceException {
        ArrayList<WorkerDto> workerDtos = new ArrayList<>();
        for(Worker worker : workers){
            WorkerDto workerDto = getWorkerDto(worker);
            workerDtos.add(workerDto);
        }
        return workerDtos;
    }

    private WorkerDto getWorkerDto(Worker worker) throws ServiceException {
        try(DaoHelper helper = factory.create()){
            TaskDao taskDao = helper.createTaskDao();
            ProjectDao projectDao = helper.createProjectDao();
            Optional<Task> optionalTask = taskDao.getById(worker.getTaskId());
            Optional<Project> optionalProject = projectDao.getById(worker.getProjectId());
            Task task = optionalTask.orElse(DEFAULT_TASK);
            Project project = optionalProject.orElse(DEFAULT_PROJECT);
            return new WorkerDto(worker.getId(),
                    project.getProjectName(),
                    task.getWorkersCount(),
                    worker.getSurname(),
                    worker.getName(),
                    worker.getQualification(),
                    worker.getSalary(),
                    worker.isFree()
            );
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
