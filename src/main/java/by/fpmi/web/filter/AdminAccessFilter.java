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
import java.nio.file.AccessDeniedException;
import java.util.Set;

public class AdminAccessFilter implements Filter {

    private static final String ACCESS_DENIED = "Access for requested resource denied for your user group";
    private final List<String> deniedCommands = Arrays.asList("admin_page");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String commandName = request.getParameter("commandName");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (deniedCommands.contains(commandName) && user.getUserRole() == UserRole.USER) {
            request.setAttribute("errorMessage", ACCESS_DENIED);
            throw new AccessDeniedException(ACCESS_DENIED);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
