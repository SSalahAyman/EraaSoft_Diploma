package controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.UserAlreadyExistsException;
import service.AuthService;
import service.impl.AuthServiceImpl;
import util.ValidationResult;


@WebServlet("/AuthController")
public class AuthController extends HttpServlet {
	
   AuthService authService = new AuthServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(Objects.isNull(action)) {  
			action="login";
		}
		
		switch(action) {
		case "login" : 
			login(request,response);
			break;
		case "signup" : 
			signup(request,response);
			break;
		default :  
			login(request,response);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	private void signup(HttpServletRequest request, HttpServletResponse response) {
		
		ValidationResult result = null;
		
		try {
			result = authService.signup(request);
		} catch (UserAlreadyExistsException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			try {
				response.getWriter().write(e.getMessage());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		if(result.isValid()) {
			try {
				response.sendRedirect("/Items-Web-Application/login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			request.setAttribute("errorMessage", result.getMessage());
			try {

	            request.getRequestDispatcher("/signup.jsp")
	                   .forward(request,response);

	        } catch (Exception e) {

	            e.printStackTrace();
	        }
		}
		
		
		
		
    }
	

}
