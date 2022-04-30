package by.fpmi.web.command;

import by.fpmi.web.model.dto.ProjectDto;
import by.fpmi.web.service.ProjectService;
import by.fpmi.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ProjectsPageCommand implements Command {
    public static final String USER_ID = "USER_ID";
    private final ProjectService projectService;

    public ProjectsPageCommand(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        Long customerId = (Long) session.getAttribute(USER_ID);
        List<ProjectDto> projects = projectService.getProjects(customerId);
        request.setAttribute("projects", projects);
        return CommandResult.forward(Pages.VIEW_PROJECT);
    }
}
