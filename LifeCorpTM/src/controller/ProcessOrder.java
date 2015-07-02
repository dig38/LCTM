package controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Customer;
import model.Order;
import model.Product;
import modelcontroller.OrderMC;

/**
 * Servlet implementation class ProcessOrder
 */
@WebServlet("/ProcessOrder")
public class ProcessOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessOrder() {
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
		BigDecimal qty = new BigDecimal(request.getParameter("quantity"));
		Product p = (Product)session.getAttribute("pro");
		try{
			Order o = new Order();
			o.setCustomer((Customer)session.getAttribute("cus"));
			o.setOrderQuantity(qty);
			o.setOrderTotal(qty.multiply(p.getProductUnitprice()));
			o.setProduct((Product)session.getAttribute("pro"));
			OrderMC.insert(o);
			getServletContext().getRequestDispatcher("/orderprocessed.jsp").forward(request, response);
		}catch (Exception e){
			System.out.println("Error: "+e+" !!!!!!!!!!!!!!!!");
			//sorry
		}
	}

}
