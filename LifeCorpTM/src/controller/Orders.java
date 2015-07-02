package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import modelcontroller.productMC;

/**
 * SERVLET implementation class Order
 */
@WebServlet("/Orders")
public class Orders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Orders() {
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
		try{
			if((boolean)session.getAttribute("log") == true){
				Product pro = productMC.getOneProduct(request.getParameter("pid").toString());
				session.setAttribute("pro", pro);

				getServletContext().getRequestDispatcher("/order.jsp").forward(request, response);
			}else
				session.setAttribute("loc", "order");
				
				getServletContext().getRequestDispatcher("/logon.jsp").forward(request, response);
		}catch (NullPointerException e){
			session.setAttribute("loc", "order");
			
			getServletContext().getRequestDispatcher("/logon.jsp").forward(request, response);
		}
		
	}

}
