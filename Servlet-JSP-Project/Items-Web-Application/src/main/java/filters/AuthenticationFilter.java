package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


    @WebFilter("/*")  // Applies to all URLs of the project such as ItemController , ItemDetailsController ,.....
public class AuthenticationFilter extends HttpFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req =(HttpServletRequest) request;

        HttpServletResponse res = (HttpServletResponse) response;
        
        String uri = req.getRequestURI();

// Public Pages (this pages & controllers when user request this url's the filter is not working on it and other url's inside itemController or itemDetails Controller checking it's have session or not)
        if(uri.endsWith("login.jsp")
        		|| uri.endsWith("signup.jsp")
                || uri.endsWith("forget-password.jsp")
                || uri.endsWith("reset-password.jsp")
                || uri.contains("LoginController")
                || uri.contains("SignupController")
                || uri.contains("ForgetPasswordController")
                || uri.contains("LogoutController")
        		) {

            chain.doFilter(request, response);
            
            return;
        }

        HttpSession session = req.getSession(false);
        
        if(session == null ||session.getAttribute("userId") == null) {
        	
        	res.sendRedirect(req.getContextPath() + "/login.jsp");

        	return;
        }
        
        chain.doFilter(req, res);
		
	}
}
