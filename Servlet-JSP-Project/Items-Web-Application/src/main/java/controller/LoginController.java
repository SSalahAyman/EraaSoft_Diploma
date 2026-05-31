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

import exceptions.InvalidCredentialsException;
import exceptions.MissingMandatoryField;
import service.AuthService;
import service.impl.AuthServiceImpl;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	private AuthService authService = new AuthServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 200 OK (login success)
		 try {
			 
			authService.login(request);
			
			response.setStatus(HttpServletResponse.SC_OK);
			
			response.sendRedirect("/Items-Web-Application/ItemController");
			
		// 401 Unauthorized (that meaning user failed in authentication such as login)	
		} catch (InvalidCredentialsException e) {
			
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			
			request.setAttribute("errorMessage", e.getMessage());
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}
		 
		// 400 BAD REQUEST
		 catch (MissingMandatoryField e) {
				
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				
				request.setAttribute("errorMessage", e.getMessage());
				
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				
			}
		 
		// 500 SERVER ERROR
		 catch (SQLException | NamingException e) {
			 
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			e.printStackTrace();
			
		}
		
	}

}
