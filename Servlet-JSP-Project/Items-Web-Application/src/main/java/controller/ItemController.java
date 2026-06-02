package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.InvalidItemDataException;
import exceptions.InvalidItemNameFormatException;
import exceptions.ItemNotFoundException;
import exceptions.MissingMandatoryField;
import model.Item;
import service.ItemService;
import service.impl.ItemServiceImpl;

/* Item controller >>> is receive specific action from user (browser) such as showItems or addItem or deleteItem or updateItem 
 * and based on the action that selected , it is processed business logic based on the specific action that is selected
 */

// [at this point , the Item Controller currently , we can send request for it with anyone of this 5 URL , every URL has specific action to do ]
//https://localhost:8080/Items-Web-Application/ItemController?action=show-item
//https://localhost:8080/Items-Web-Application/ItemController?action=show-items
//https://localhost:8080/Items-Web-Application/ItemController?action=add-item
//https://localhost:8080/Items-Web-Application/ItemController?action=update-items
//https://localhost:8080/Items-Web-Application/ItemController?action=delete-items

// https://localhost:8080/Items-Web-Application/ItemController?action=xyz
// https://localhost:8080/Items-Web-Application/ItemController  >> mean user don't send value for action

@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	
	ItemService itemService = new ItemServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(Objects.isNull(action)) {  
			action="show-items";
		}
// here if the action that send from user when calling this ItemController is "show-items" , then go to the showItems method and doing the business logic that is showing all items to user on the browser
		switch(action){
			case "show-item" : 
				showItem(request,response);
				break;
			case "show-items" : 
				showItems(request,response);
				break;
			default :  // here if the action that send in request by user is not of any cases that I defined , So by default show for the user the mainPage (show-items page)
				showItems(request,response);
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(Objects.isNull(action)) {  
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	        return;
		}
		
		switch(action) {
		case "add-item" :
			addItem(request,response);
			break;
		case "update-item":
			updateItem(request,response);
			break;
		case "delete-item" :
			deleteItem(request,response);
			break;
		default :
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}  
	}
	
	
	
	private void showItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 200 OK (show items success)
		try {
			
			HttpSession session = request.getSession(false);
			
			Integer userId = (Integer) session.getAttribute("userId");
			
			List<Item> items = itemService.getAllItemsByUserId(userId);
			
			request.setAttribute("allItems", items);
			
			response.setStatus(HttpServletResponse.SC_OK);
			
			request.getRequestDispatcher("/show-items.jsp").forward(request, response);
			
			// 500 SERVER ERROR (database / server errors)
		}  catch (NamingException | SQLException e) {
			
			e.printStackTrace();
			
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			request.setAttribute("errorMessage", "InternalServerError");
			
	        request.getRequestDispatcher("/error.jsp").forward(request, response);

		}

	}


	private void showItem(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
		 
		// 200 OK (show item success)
		try {
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			/*
	         * Retrieve the item from the database.
	         * This is the normal flow when the user open the Update page for the first time.
	         */
			Item item = itemService.selectItem(id);
			
			HttpSession session = request.getSession();
			
			/*
	         * Check if there is an oldItem stored in session.
	         * oldItem exists only when:
	         * - The user submitted the Update form.
	         * - Validation failed.
	         * - We stored the user's entered values in session before redirecting back.
	         */
			Item oldItem = (Item) session.getAttribute("oldItem");
			
			/*
	         * If oldItem exists in session it means the user returned here because of a validation error.
	         * Instead of showing the original DB values, show the values entered by the user so that they can correct the invalid fields only.
	         * In this case we display the user's
	         */
			if(oldItem != null && oldItem.getId().equals(id)) {
				
				item = oldItem;
				
				/*
	             * Remove oldItem after using it.
	             * This ensures that:
	             * - The values are used only once.
	             * - Refreshing the page later will not keep showing the old invalid values.
	             */
				session.removeAttribute("oldItem");
			}
			
			/*
	         * Send the final item object to the JSP.
	         *
	         * Possible scenarios:
	         * 1) Normal Update Page Open: item contains values from database.
	         * 2) Validation Error: item contains values previously entered by the user.
	         */
			request.setAttribute("itemSelected", item);
			
			response.setStatus(HttpServletResponse.SC_OK);
			
			request.getRequestDispatcher("/update-item.jsp").forward(request, response);
			
			// 404 Not Found (not found this item that we want to show it)
		} catch(ItemNotFoundException e) {
			
			response.setStatus( HttpServletResponse.SC_NOT_FOUND);
			
			request.setAttribute("errorMessage", e.getMessage());
			
			request.getRequestDispatcher( "/item-not-found.jsp").forward(request,response); 
			
			// 500 SERVER ERROR (database / server errors)
		} catch (NamingException | SQLException e) {
			
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			request.setAttribute("errorMessage", "InternalServerError");

	        request.getRequestDispatcher("/error.jsp").forward(request, response);

		   } 
		}
		
	
	private void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 200 OK (add item success)
		try {
			
			String name = request.getParameter("itemName");
			Double price = Double.parseDouble(request.getParameter("itemPrice"));
			Integer totalNumber = Integer.parseInt(request.getParameter("itemTotalNumber"));
			
			HttpSession session = request.getSession(false);
			
			Integer userId = (Integer) session.getAttribute("userId");
			
			Item item = new Item(name,price,totalNumber);
			
			item.setUserId(userId);
			
			itemService.saveItem(item);
			
			response.setStatus(HttpServletResponse.SC_OK);
			
			response.sendRedirect("/Items-Web-Application/ItemController");
			
			// 400 BAD REQUEST
		} catch (MissingMandatoryField |InvalidItemNameFormatException |InvalidItemDataException e) {
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("errorMessage", e.getMessage());  // here we store the errorMessage of the exception in the session not the request because we use sendRedirect to view the add-item page with new request
			
			response.sendRedirect ("add-item.jsp"); // here using sendRedirect no dispatcher to can when user submit the form and this exception happen and go to the add-item page again and when doing refresh don't resubmit the form again 
			
			// 500 SERVER ERROR (database / server errors)
		} catch (NamingException | SQLException e) {
			
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			request.setAttribute("errorMessage", "InternalServerError");

			request.getRequestDispatcher("/error.jsp").forward(request, response);
	
		} 

	}


	private void updateItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("itemName");
		
		Double price = Double.parseDouble(request.getParameter("itemPrice"));
		
		Integer totalNumber = Integer.parseInt(request.getParameter("itemTotalNumber"));
		
		// 200 OK (update item success)
		try {
			
			Item item = new Item(id,name,price,totalNumber);
			
			itemService.updateitem(item);
			
			response.setStatus(HttpServletResponse.SC_OK);
			
			response.sendRedirect("/Items-Web-Application/ItemController");
			
			// 400 BAD REQUEST
		} catch (MissingMandatoryField |InvalidItemNameFormatException |InvalidItemDataException e) {
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("errorMessage", e.getMessage());
			
			Item oldItem = new Item(id,name,price,totalNumber);
			
			/*
			 * Validation failed.
			 *
			 * Store the user's entered values in session before redirecting back to the Update page.
			 * This allows the form to keep the user's data instead of reloading the original values from the database.
			 */
			session.setAttribute("oldItem", oldItem);
			
			/*
			 * Redirect back to showItem().
			 * We use Redirect instead of Forward to avoid Form Re-submission when the user refreshes the page after a validation error.
			 */
			response.sendRedirect ("/Items-Web-Application/ItemController?action=show-item&id="+id);
			
			// 500 SERVER ERROR (database / server errors)
		} catch (NamingException | SQLException e) {
			
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			request.setAttribute("errorMessage", "InternalServerError");
			
		    request.getRequestDispatcher("/error.jsp").forward(request, response);
		
		}
	}


	
	private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 200 OK (update item success)
		
		try {
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			itemService.deleteItem(id);
			
			response.setStatus(HttpServletResponse.SC_OK);
			
			response.sendRedirect("/Items-Web-Application/ItemController");
			
			
			// 500 SERVER ERROR (database / server errors)
		} catch (NamingException | SQLException e) {

			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			request.setAttribute("errorMessage", "InternalServerError");
			
			e.printStackTrace();
			
			request.getRequestDispatcher("/error.jsp").forward(request, response);

		}

	}

}
