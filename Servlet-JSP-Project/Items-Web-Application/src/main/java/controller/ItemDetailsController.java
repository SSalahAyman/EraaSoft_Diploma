package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.InvalidItemDetailsException;
import exceptions.ItemDetailsAlreadyExistsException;
import exceptions.ItemDetailsNotFoundException;
import model.ItemDetails;
import service.ItemDetailsService;
import service.impl.ItemDetailsServiceImpl;


@WebServlet("/ItemDetailsController")
public class ItemDetailsController extends HttpServlet {
	
	private ItemDetailsService itemDetailsService = new ItemDetailsServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(Objects.isNull(action)) {  
			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			
	        return;
		}
		
		switch (action){
			case "view-item-details" :
				viewItemDetails(request,response);
				break;
			case "show-add-details-form" :
				showAddDetailsForm(request,response);
				break;
			case "show-update-details-form"	:
				showUpdateDetailsForm(request,response);
				break;
			default :
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(Objects.isNull(action)) {  
					
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
					
			return;
		}
				
		switch (action){
		case "add-item-details":
			addItemDetails(request,response);
			break;
		case "update-item-details":
			updateItemDetails(request,response);
			break;
		default :
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
	}
		
	}
	
	private void viewItemDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // 200 OK (view item details success)
		try {
			
			Integer itemId = Integer.parseInt(request.getParameter("id"));
			
			ItemDetails itemDetails = itemDetailsService.getItemDetailsByItemId(itemId);
			
			request.setAttribute("itemDetails", itemDetails);
			
			response.setStatus(HttpServletResponse.SC_OK);
			
			request.getRequestDispatcher("/item-details.jsp").forward(request, response);
			
			// 404 Not Found (not found details for the selected item)
		} catch (ItemDetailsNotFoundException e) {
			
			response.setStatus( HttpServletResponse.SC_NOT_FOUND);
			
			request.setAttribute("errorMessage", e.getMessage());
			
			request.getRequestDispatcher( "/item-details-not-found.jsp").forward(request,response);  // [we must create this page]
			
		
		 // 500 SERVER ERROR (database / server errors)
		} catch (NamingException | SQLException e) {
			
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			request.setAttribute("errorMessage", "InternalServerError");
			
			try {
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			} catch (ServletException | IOException e1) {
			
				e1.printStackTrace();
			}
			
			
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		} 
		
		
		
	}
	
	private void showAddDetailsForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 200 OK (showAddDetailsForm success)
			
			Integer itemId = Integer.parseInt(request.getParameter("id"));
			
			request.setAttribute("itemId",itemId);
			
			response.setStatus(HttpServletResponse.SC_OK);
			
			request.getRequestDispatcher("/add-item-details.jsp").forward(request, response);
			
		
	}
	
	
	private void showUpdateDetailsForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 200 ok (showUpdateDetailsForm success)
		
		try {
			
			Integer itemId = Integer.parseInt(request.getParameter("id"));
			
			ItemDetails itemDetails = itemDetailsService.getItemDetailsByItemId(itemId);
			
			request.setAttribute("itemDetails", itemDetails);
			
			response.setStatus(  HttpServletResponse.SC_OK);

            request.getRequestDispatcher( "/update-item-details.jsp").forward(request,response);
            
		 // 404 Not Found (not found details for the selected item to update it)
	    } catch (ItemDetailsNotFoundException e) {
		
		   response.setStatus( HttpServletResponse.SC_NOT_FOUND);
		
		   request.setAttribute("errorMessage", e.getMessage());
		
		    request.getRequestDispatcher( "/item-details-not-found.jsp").forward(request,response);  // [we must create this page]
			
		   // 500 SERVER ERROR (database / server errors)
		} catch (NamingException | SQLException e) {
			
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			request.setAttribute("errorMessage", "InternalServerError");

			request.getRequestDispatcher("/error.jsp").forward(request, response);
			
		}	
	}
	
	private void addItemDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 200 OK (addItemDetails success)
		try {
			
			Integer itemId = Integer.parseInt(request.getParameter("itemId"));
			
			String description = request.getParameter("description");
			
			String color = request.getParameter("color");
			
			Double weight = Double.parseDouble(request.getParameter("weight"));
			
			String brand = request.getParameter("brand");
			
			ItemDetails itemDetails = new ItemDetails(itemId,description,color,weight,brand);
			
			itemDetailsService.addItemDetails(itemDetails);
			
			response.setStatus(HttpServletResponse.SC_CREATED);

            response.sendRedirect( "/Items-Web-Application/ItemController");
			
			// 400 BAD REQUEST
		} catch (InvalidItemDetailsException e) {
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			request.setAttribute("errorMessage", e.getMessage());
			
			request.getRequestDispatcher("/add-item-details.jsp").forward(request, response);
			
			 // 409 CONFLICT
		} catch (ItemDetailsAlreadyExistsException e) {
			
			response.setStatus(HttpServletResponse.SC_CONFLICT);
			 
			 request.setAttribute("errorMessage", e.getMessage());
			 
			 request.getRequestDispatcher("/add-item-details.jsp").forward(request, response);
			
			 // 500 SERVER ERROR (database / server errors)
		} catch (NamingException | SQLException e) {
			
			e.printStackTrace();
			
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			request.setAttribute("errorMessage", "InternalServerError");

			request.getRequestDispatcher("/error.jsp").forward(request, response);
			
		}
	}
	

	private void updateItemDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// 200 OK (updateItemDetails success)
		try {
			
			Integer itemId = Integer.parseInt( request.getParameter("itemId"));
			
			String description = request.getParameter("description");

            String color = request.getParameter("color");

            Double weight = Double.parseDouble( request.getParameter("weight"));

            String brand = request.getParameter("brand");
            
            ItemDetails itemDetails =new ItemDetails(itemId,description,color, weight,brand);
            
            itemDetailsService.updateItemDetails(itemDetails);
            
            response.setStatus( HttpServletResponse.SC_OK);

            response.sendRedirect("/Items-Web-Application/ItemController");
            
            // 400 BAD REQUEST
		} catch (InvalidItemDetailsException e) {
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			request.setAttribute("errorMessage",e.getMessage());

            request.getRequestDispatcher("/update-item-details.jsp").forward(request,response);
			
         // 404 Not Found (not found details for the selected item to update it)
		} catch (ItemDetailsNotFoundException e) {
			
			response.setStatus( HttpServletResponse.SC_NOT_FOUND );

            request.setAttribute("errorMessage", e.getMessage());

            request.getRequestDispatcher("/update-item-details.jsp").forward(request,response);
			
			// 500 SERVER ERROR (database / server errors)
		} catch (NamingException | SQLException e) {
			
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			request.setAttribute("errorMessage", "InternalServerError");

			request.getRequestDispatcher("/error.jsp").forward(request, response);
			
		}
		
	}

}

	


