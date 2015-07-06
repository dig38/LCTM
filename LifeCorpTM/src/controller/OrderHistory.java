package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * SERVLET implementation class OrderHistory
 */
@WebServlet("/OrderHistory")
public class OrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderHistory() {
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
				request.setAttribute("flag", true);
				getServletContext().getRequestDispatcher("/orderhistory.jsp").forward(request, response);
			}else{
				session.setAttribute("loc", "OrderHistory");
				getServletContext().getRequestDispatcher("/logon.jsp").forward(request, response);
			}
		}catch (NullPointerException e){
			session.setAttribute("loc", "OrderHistory");
			getServletContext().getRequestDispatcher("/logon.jsp").forward(request, response);
		}
	}

}
