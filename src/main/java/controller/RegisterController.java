package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConnectionCustomer;
import model.CustomerEntity;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
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
		String name=(String) request.getParameter("name");
		String email=(String) request.getParameter("email");
		String country=request.getParameter("country");
		String password=(String) request.getParameter("password");
		System.out.println(name+email+password);
		
		
		CustomerEntity customer=new CustomerEntity(name,email);
		customer.setPassword(password);
		customer.setCountry(country);
		
		ConnectionCustomer.addCustomer(customer);
		HttpSession session=request.getSession();
		session.setAttribute("email", email);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
		
	}

}
