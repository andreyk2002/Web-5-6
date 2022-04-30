package by.fpmi.web.command;

import by.fpmi.web.model.entity.User;
import by.fpmi.web.service.ServiceException;
import by.fpmi.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterUserCommand implements Command {
    private final UserService userService;

    public RegisterUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.register(username, password);
        session.setAttribute("user", user);
        return CommandResult.forward(Pages.MAIN_PAGE);
    }
}
