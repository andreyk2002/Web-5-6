package by.fpmi.web.command;

import by.fpmi.web.model.dto.WorkerDto;
import by.fpmi.web.service.ServiceException;
import by.fpmi.web.service.WorkersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class WorkersPageCommand implements Command {
    private final WorkersService workersService;

    public WorkersPageCommand(WorkersService workersService) {
        this.workersService = workersService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        List<WorkerDto> workers = workersService.getFreeWorkers();
        request.setAttribute("workers", workers);
        return CommandResult.forward(Pages.VIEW_WORKERS);
    }
}
