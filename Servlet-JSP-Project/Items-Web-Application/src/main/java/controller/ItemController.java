package controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		if(Objects.isNull(action)) {  // here is the request that is send to the controller without value for action parameter , then
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
			case "add-item" :
				addItem(request,response);
				break;
			case "update-item" :
				updateItem(request,response);
				break;
			case "delete-item" :
				deleteItem(request,response);
				break;
			default :  // here if the action that send in request by user is not of any cases that I defined , So by default show for the user the mainPage (show-items page)
				showItems(request,response);
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// here when the request that is come to this itemServletController with type POST , execute the same business logic that is within in doGet() by calling it and passes to it the data of httpRequestObject & httpResponseObject
		doGet(request,response);  
	}

	private void showItems(HttpServletRequest request, HttpServletResponse response) {
		List<Item> items = itemService.getAllItems();  // this "items list" have now object of item that every object mapping to a row of ITEM table in database
		request.setAttribute("allItems", items);
		try {
			request.getRequestDispatcher("/show-items.jsp").forward(request, response);   // here must do try/catch here because the path that we put can be not found 
		} catch (ServletException | IOException e) {
			System.out.println("Exception " + e.getMessage());
		}
		// TODO : code that send the list of items to front-end page to showing it in browser
	}


	private void showItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	
	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	
	private void deleteItem(HttpServletRequest request, HttpServletResponse response) {
		
		try {

			Integer id = Integer.parseInt(request.getParameter("id"));

	        boolean isItemDeleted = itemService.deleteItem(id);

	        if(isItemDeleted) {

	            response.sendRedirect( "/Items-Web-Application/ItemController?action=show-items");

	        } else {

	            System.out.println("Delete failed");
	        }

	    } catch (Exception e) {

	        System.out.println("Exception " + e.getMessage());
	    }
		
	}



	

}
