package by.fpmi.web.command;

import by.fpmi.web.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    /**
     * Executes a specific command
     *
     * @param request  servlet request from controller
     * @param response servlet response from controller
     * @return instance of {@link CommandResult} class which contains the type of redirection to next
     * resource (redirect or forward) and the name of next resource
     * @throws CommandExecutionException when client request is invalid
     */
    CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException;

}
