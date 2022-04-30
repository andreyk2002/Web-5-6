package by.fpmi.web.command;

import by.fpmi.web.service.ProjectService;
import by.fpmi.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderProjectCommand implements Command {
    public static final String USER_ID = "USER_ID";
    private final ProjectService projectService;

    public OrderProjectCommand(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        Long customerId = (Long) session.getAttribute(USER_ID);
        String projectName = request.getParameter("projectName");
        String projectDescription = request.getParameter("projectDescription");
        projectService.addProject(projectName,projectDescription,customerId);
        return CommandResult.forward(Pages.ORDER_PROJECT);
    }
}
