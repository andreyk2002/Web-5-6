package by.fpmi.web.filter;

import by.fpmi.web.model.entity.User;
import by.fpmi.web.model.entity.UserRole;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

public class UserAccessFilter implements Filter {

    private static final String ACCESS_DENIED = "Access for requested resource denied for your user group";
    private final Set<String> deniedCommands = Set.of("orderProject", "orderProjectPage");


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        checkAccess(request, session);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void checkAccess(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String commandName = request.getParameter("commandName");
        if (deniedCommands.contains(commandName) && user.getUserRole() == UserRole.ADMIN) {
            request.setAttribute("errorMessage", ACCESS_DENIED);
            throw new AccessException(ACCESS_DENIED);
        }
    }

}