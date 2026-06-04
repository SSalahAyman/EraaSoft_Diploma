package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.MissingMandatoryField;
import exceptions.PasswordMismatchException;
import exceptions.UserNotFoundException;
import exceptions.ValidationException;
import service.AuthService;
import service.impl.AuthServiceImpl;


@WebServlet("/ForgetPasswordController")
public class ForgetPasswordController extends HttpServlet {
	
	private AuthService authService = new AuthServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch(action) {
			
		case "check-username":
			checkUsername(request,response);
			break;
			
		case "reset-password" :
			resetPassword (request,response);
			break;
			
		default :
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		
		
	}


	private void resetPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("newPassword");
		
		String confirmPassword = request.getParameter("confirmPassword");
		
		HttpSession session =request.getSession();
		
		try {
			
			authService.resetPassword(username, password, confirmPassword);
			
			session.removeAttribute("resetUsername");
			
			response.sendRedirect("login.jsp");
			
		} // 400 BAD REQUEST
	      catch (MissingMandatoryField | PasswordMismatchException | ValidationException e) {
		
	         response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		
		    session.setAttribute("errorMessage", e.getMessage());
		
		    response.sendRedirect("reset-password.jsp");
		     
		  // 500 internal server error
	      } catch (NamingException | SQLException e) {
				
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				
				request.setAttribute("errorMessage", "InternalServerError");
				
			    request.getRequestDispatcher("/error.jsp").forward(request, response);
			
			}
	}


	private void checkUsername(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String username = request.getParameter("username");
		
		HttpSession session =request.getSession();
		
		try {
			
			authService.checkUsername(username);
			
			session.setAttribute("resetUsername", username);
			
			response.sendRedirect("reset-password.jsp");
			
			// 400 BAD REQUEST
		} catch (MissingMandatoryField e) {
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
		    session.setAttribute("errorMessage", e.getMessage());
		
		    response.sendRedirect("forget-password.jsp");
			
			// 404 Not Found 
		} catch (UserNotFoundException e) {
			
			response.setStatus( HttpServletResponse.SC_NOT_FOUND);
			
			session.setAttribute("errorMessage", e.getMessage());
			
			response.sendRedirect("forget-password.jsp");
			
			// 500 internal server error
		} catch (NamingException | SQLException e) {
			
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			request.setAttribute("errorMessage", "InternalServerError");
			
		    request.getRequestDispatcher("/error.jsp").forward(request, response);
		
		}
		
		
		
	}

}
