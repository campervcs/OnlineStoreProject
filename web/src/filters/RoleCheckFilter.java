package filters;

import models.customer.Customer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoleCheckFilter implements Filter {

    private Customer User;

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        User = (Customer) req.getSession().getAttribute("LOGIN_USER");
        if (User == null) {
            res.sendRedirect("/login");
        } else {
            switch (User.getRole()) {
                case admin:
                    break;
                case user:
                    res.sendRedirect("/myStore");
                    break;
                default:
                    break;
            }
            fc.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
