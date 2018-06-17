package com.customer.login;
import com.Model.*;
import com.Dao.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		CustomerLoginBean customer = new CustomerLoginBean();
		customer.setCustomerId(Integer.parseInt(request.getParameter("customer_id")));
		customer.setPassword(request.getParameter("inputPassword3"));
		customer=CustomerLoginDao.login(customer);
		//request.getParameterNames();
		
		if( customer.isValid()) {
			HttpSession session = request.getSession(true);	    
	         session.setAttribute("customerid",customer.getCustomerId()); 
	         // response.sendRedirect("fundtransferjsp.jsp");
	         System.out.println("customer valid !!");
	         request.getRequestDispatcher("/AccountController").forward(request, response);
		} else
		{
			out.println("<script type=\"text/javascript\">");
			  out.println("alert('incorrect credentials');");
			   out.println("</script>");
			response.sendRedirect("HomePage.jsp");
		}
	}

}
