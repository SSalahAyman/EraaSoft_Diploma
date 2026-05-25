package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.MissingMandatoryField;
import exceptions.PasswordMismatchException;
import exceptions.UserAlreadyExistsException;
import exceptions.ValidationException;
import service.AuthService;
import service.impl.AuthServiceImpl;


@WebServlet("/SignupController")
public class SignupController extends HttpServlet {       
   
	private AuthService authService = new AuthServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/signup.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 200 OK (SignUp success)
		 try {
			 
			authService.signup(request);
			
			// response.setStatus(HttpServletResponse.SC_OK);  this is produces statues code 200
			
			response.sendRedirect("login.jsp");   // and sendRedirect uses internally 302 status code , so the code 200 is not appeared and not used
			
	      } 
		 
		// 400 BAD REQUEST
		 catch (MissingMandatoryField | PasswordMismatchException | ValidationException e){
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			request.setAttribute("errorMessage", e.getMessage());
			
			request.getRequestDispatcher("/signup.jsp").forward(request, response);
			
		  } 
		 
		// 409 CONFLICT
		 catch(UserAlreadyExistsException e) {
			 
			 response.setStatus(HttpServletResponse.SC_CONFLICT);
			 
			 request.setAttribute("errorMessage", e.getMessage());
			 
			 request.getRequestDispatcher("/signup.jsp").forward(request, response);
			 
		 }
		 
		// 500 SERVER ERROR
		 catch (SQLException | NamingException e) {
			
			 response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			 
			 request.setAttribute("errorMessage", "Internal Server Error");
			 
			 request.getRequestDispatcher("/signup.jsp").forward(request,response);
			 
			 e.printStackTrace();
		} 
		 
		 
	}

}
