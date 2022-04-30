package by.fpmi.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserInfoInjector implements Filter {
    public static final String USER_ID = "USER_ID";
    public static final long CUSTOMER_ID = 42L;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        if (session.getAttribute(USER_ID) == null) {
            session.setAttribute(USER_ID, CUSTOMER_ID);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
