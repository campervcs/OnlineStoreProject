package filters;

import model.customer.Customer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoleCheckFilter implements Filter {

    private String contextPath;

    @Override
    public void init(FilterConfig fc) throws ServletException {
        //contextPath = fc.getServletContext().getContextPath();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        Customer user = (Customer) req.getSession().getAttribute("LOGIN_USER");
        if (user == null) {
            res.sendRedirect("index.html");
        } else {
            switch (user.getRole()) {
                case admin:
                    break;
                case user:
                    res.sendRedirect("welcome.jsp");
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
