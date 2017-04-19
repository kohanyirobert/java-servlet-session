package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/user.html")
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        HttpSession session = httpReq.getSession(false);
        if (session != null) {
            String email = (String) session.getAttribute("email");
            if (email != null) {
                chain.doFilter(req, resp);
                return;
            }
        }
        httpResp.sendRedirect("/login.html");
    }

    @Override
    public void destroy() {
    }
}
