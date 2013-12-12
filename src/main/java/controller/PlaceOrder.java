package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnectionBooking;
import data.CSV;
import model.BookingEntity;

/**
 * Servlet implementation class PlaceOrder
 */
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("goods");
		String email=(String) request.getSession().getAttribute("email");
		String id=CSV.getString(20);
		BookingEntity book=new BookingEntity(id,email);
		book.setName(name);
		ConnectionBooking.addBookingEntity(book);
		request.getSession().invalidate();
		request.getRequestDispatcher("success.jsp").forward(request, response);
		
		
	}

}
