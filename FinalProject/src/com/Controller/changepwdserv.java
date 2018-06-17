package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Dao.*;
import com.Model.CustomerBean;


/**
 * Servlet implementation class changepwdserv
 */
@WebServlet("/changepwdserv")
public class changepwdserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepwdserv() {
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
		     customer.setCustomerId(request.getParameter("cid"));
		     customer.setoldpassword(request.getParameter("oldpwd"));
		     customer.setnewPassword(request.getParameter("password"));

		     int res = CustomerDao.changepwd(customer);
		     if(res>0){
		    	 System.out.println("password updated");
		     }
		     else
		     {
		    	 System.out.println("Sorry! try again");
		     }
		}
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		       
		}
	}


