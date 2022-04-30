package by.fpmi.web.command;

import by.fpmi.web.dao.DaoHelperFactory;
import by.fpmi.web.service.ProjectService;
import by.fpmi.web.service.UserService;
import by.fpmi.web.service.WorkersService;

import java.util.Locale;

public class CommandFactory {
    private final DaoHelperFactory helperFactory = new DaoHelperFactory();

    public Command create(String commandName) {
        Commands command = Commands.valueOf(commandName.toUpperCase(Locale.ROOT));
        ProjectService projectService = new ProjectService(helperFactory);
        WorkersService workersService = new WorkersService(helperFactory);
        UserService userService = new UserService(helperFactory);
        if (command == Commands.MAIN) {
            return new MainPageCommand();
        }
        if (command == Commands.ORDER_PROJECT) {
            return new OrderProjectCommand(projectService);
        }
        if (command == Commands.VIEW_PROJECT) {
            return new ProjectsPageCommand(projectService);
        }
        if (command == Commands.VIEW_WORKERS) {
            return new WorkersPageCommand(workersService);
        }
        if (command == Commands.VIEW_WORKERS_PAGE) {
            return new ShowPageCommand(Pages.MAIN_PAGE);
        }
        if (command == Commands.VIEW_PROJECT_PAGE) {
            return new ShowPageCommand(Pages.VIEW_WORKERS);
        }
        if (command == Commands.MAIN_PAGE) {
            return new ShowPageCommand(Pages.ORDER_PROJECT);
        }
        if (command == Commands.ORDER_PROJECT_PAGE) {
            return new ShowPageCommand(Pages.ORDER_PROJECT);
        }
        if (command == Commands.LOGIN_PAGE) {
            return new ShowPageCommand(Pages.LOGIN_PAGE);
        }
        if (command == Commands.LOGIN) {
            return new LoginCommand(userService);
        }
        if (command == Commands.REGISTER_PAGE) {
            return new ShowPageCommand(Pages.REGISTER_PAGE);
        }
        if (command == Commands.REGISTER) {
            return new RegisterUserCommand(userService);
        }
        if (command == Commands.ADMIN_PAGE) {
            return new ShowPageCommand(Pages.ADMIN_PAGE);
        }
        throw new CommandNotExistException("Unknown type = " + commandName);
    }
}
