package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		session.setAttribute("log", true);
		String loc = (String)session.getAttribute("loc");
		request.setAttribute("message", null);
		Customer c = getCustomer(request); 
		try{
			if( areTheyACustomer(c) == true ){
				session.setAttribute("cus", c);
				if(loc != null)
					getServletContext().getRequestDispatcher(loc.toString()).forward(request, response);
				else
					getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}catch (Exception e){
			//System.out.println(e);
			request.setAttribute("message", "Your Email/Password combination is incorect.");
			getServletContext().getRequestDispatcher("/logon.jsp").forward(request, response);
		}
	}
	
	//Maybe change to pass email password instead of request
	protected Customer getCustomer(HttpServletRequest request){
		String cemail = request.getParameter("email");
		String cpass = request.getParameter("password");
		Customer c = CustomerMC.getOneCustomer(cemail, cpass);
		return c;
	}
	
	protected boolean areTheyACustomer(Customer c){
		if (c.getCustomerId() == null)
			return false;
		else
			return true;
	}
}

	