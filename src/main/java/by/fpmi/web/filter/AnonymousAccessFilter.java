package by.fpmi.web.filter;

import by.fpmi.web.model.entity.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AnonymousAccessFilter implements Filter {
    private final List<String> allowedCommands = Arrays.asList("login", "login_page","main", "main_page", "register", "register_page");
    private String loginCommand;

    @Override
    public void init(FilterConfig filterConfig) {
        loginCommand = filterConfig.getInitParameter("loginCommand");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String commandName = request.getParameter("commandName");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (!allowedCommands.contains(commandName)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/controller?commandName=" + loginCommand);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
