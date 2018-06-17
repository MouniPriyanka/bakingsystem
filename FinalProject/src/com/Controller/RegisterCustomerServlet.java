package com.Controller;
import com.Model.*;
import com.Dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterCustomerServlet
 */
@WebServlet("/RegisterCustomerServlet")
public class RegisterCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCustomerServlet() {
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
		PrintWriter out = response.getWriter();
		try{
			
			RegisterCustomerBean bean= new RegisterCustomerBean();
			
			bean.setCustomerId(Integer.parseInt(request.getParameter("customer_id")));
			bean.setPassword(request.getParameter("createPassword"));

			int id= bean.getCustomerId();
			request.getSession().setAttribute("custBean", bean);
			
			Random rnd = new Random();
			int otp = 100000 + rnd.nextInt(900000);
			HttpSession s=request.getSession();
			s.setMaxInactiveInterval(2*60);
			s.setAttribute("otp", otp);
			System.out.println("before OTP Dao");
			OtpDao.otpGenerate(id,otp);
			System.out.println("after OTP Dao");
			response.sendRedirect("otp.jsp");
			
			/*if(bean.isRegistered()){
				
				HttpSession session = request.getSession(true);	    
		         session.setAttribute("delete", "Account Registered : "+bean.getCustomerId());
		         response.sendRedirect("HomePage.jsp"); 
			}
			else{
				
				 response.sendRedirect("invalidLogin.jsp"); 
			}*/
			
			 
		}
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		finally {            
            out.close();
        }
		
	}

}
