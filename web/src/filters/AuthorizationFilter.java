package filters;

import models.customer.Customer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        Customer User = (Customer) req.getSession().getAttribute("LOGIN_USER");
        if (User == null) {
            res.sendRedirect("/login");
        } else fc.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
