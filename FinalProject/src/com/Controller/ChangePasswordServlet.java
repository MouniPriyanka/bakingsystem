package com.Controller;
import com.Model.*;
import com.Dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.CustomerBean;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try
		{	    

		     CustomerBean customer = new CustomerBean();
		     customer.setCustomerId((request.getParameter("customer_id")));
		     customer.setoldpassword(request.getParameter("oldPassword"));
		     customer.setnewPassword(request.getParameter("newPassword"));
      
		     int res = changepassworddao.changepassword(customer);
		     if(res>0){
		    	 System.out.println("password updated");
		     }
		     else
		     {
		    	 System.out.println("Sorry! try again");
		     }
		     if( customer.isValid()) {
					//HttpSession session = request.getSession(true);	    
			        //  session.setAttribute("currentSession",customer); 
			          response.sendRedirect("HomePage.jsp");
				} else
				{
					response.sendRedirect("invalidLogin.jsp");
				}
		}
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}

}
