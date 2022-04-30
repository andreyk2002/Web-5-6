package by.fpmi.web.service;

import by.fpmi.web.dao.CustomerDao;
import by.fpmi.web.dao.DaoException;
import by.fpmi.web.dao.DaoHelper;
import by.fpmi.web.dao.DaoHelperFactory;
import by.fpmi.web.dao.ProjectDao;
import by.fpmi.web.dao.ProjectDefinitionDao;
import by.fpmi.web.model.dto.ProjectDto;
import by.fpmi.web.model.entity.Customer;
import by.fpmi.web.model.entity.Project;
import by.fpmi.web.model.entity.ProjectDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectService {
    private static final Customer DEFAULT_CUSTOMER = new Customer(-1, "Unknown customer", "Unkown", 0);
    private static final ProjectDefinition DEFAULT_DEFINITION = new ProjectDefinition(-1, -1, "Unkown");


    private final DaoHelperFactory factory;

    public ProjectService(DaoHelperFactory factory) {
        this.factory = factory;
    }

    public List<ProjectDto> getProjects(Long customerId) throws ServiceException {
        try (DaoHelper helper = factory.create()) {
            ProjectDao projectDao = helper.createProjectDao();
            List<Project> projects = projectDao.getByCustomerId(customerId);
            return getProjectDtos(projects);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private List<ProjectDto> getProjectDtos(List<Project> projects) throws ServiceException {
        List<ProjectDto> dtos = new ArrayList<>();
        for (Project project : projects) {
            ProjectDto dto = getProjectDto(project);
            dtos.add(dto);
        }
        return dtos;
    }

    private ProjectDto getProjectDto(Project project) throws ServiceException {
        try (DaoHelper helper = factory.create()) {
            CustomerDao customerDao = helper.createCustomerDao();
            ProjectDefinitionDao projectDefinitionDao = helper.createProjectDefinitionDao();
            Optional<Customer> optionalCustomer = customerDao.getById(project.getCustomerId());
            Optional<ProjectDefinition> optionalProjectDefinition = projectDefinitionDao.getById(project.getProjectDefinitionId());
            Customer customer = optionalCustomer.orElse(DEFAULT_CUSTOMER);
            ProjectDefinition projectDefinition = optionalProjectDefinition.orElse(DEFAULT_DEFINITION);
            return new ProjectDto(project.getId(),
                    projectDefinition.getDescription(),
                    project.getProjectName(),
                    customer.getName(),
                    customer.getSurname(),
                    customer.getMoney(),
                    project.isPaidByCustomer());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void addProject(String projectName, String projectDescription, Long customerId) throws ServiceException {
        try (DaoHelper helper = factory.create()) {
            ProjectDao projectDao = helper.createProjectDao();
            ProjectDefinitionDao projectDefinitionDao = helper.createProjectDefinitionDao();

            long definitionId = projectDefinitionDao.
                    createProjectDefinition(new ProjectDefinition(0, customerId, projectDescription));
            projectDao.createProject(new Project(0, definitionId, projectName, customerId, false));
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
