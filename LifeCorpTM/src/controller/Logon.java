package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import model.Customer;
import modelcontroller.CustomerMC;

/**
 * SERVLET implementation class Logon
 */
@WebServlet("/Logon")
public class Logon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loc = (String)session.getAttribute("loc");
		request.setAttribute("message", null);
		
		try {
			//get customer
			Customer c = CustomerMC.getOneCustomer(request.getParameter("email"),  request.getParameter("password"));			
			
			// If they exist send them to index or their location. Otherwise send them back to logon.
			if( customerExists(c) == true ){
				session.setAttribute("log", true);
				session.setAttribute("cus", c);
			
				RequestDispatcher reqdis = loc == null 
						? getServletContext().getRequestDispatcher("/index.jsp") 
						: getServletContext().getRequestDispatcher(loc);
				
				reqdis.forward(request, response);
				
			}else{
				//make sure log is false and pass a message back from this request
				session.setAttribute("log", false);
				request.setAttribute("message", "Your Email/Password combination is incorect.");
				
				getServletContext().getRequestDispatcher("/logon.jsp").forward(request, response);
			}
		}
		catch (Exception e){	
		}
	}
	
	//Checks that the customer id is not null.
	protected boolean customerExists(Customer c){
		boolean rb = (c.getCustomerId() != null) ? true : false;
		return rb;
	}	
}

	