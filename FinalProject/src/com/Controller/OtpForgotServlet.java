package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.ForgotPasswordDao;
import com.Model.ForgotPasswordBean;


/**
 * Servlet implementation class OtpForgotServlet
 */
@WebServlet("/OtpForgotServlet")
public class OtpForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtpForgotServlet() {
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
		 try {
	        	//RegisterCustomerBean bean= new RegisterCustomerBean();
	        	ForgotPasswordBean bean=(ForgotPasswordBean)request.getSession().getAttribute("custBean");
	           int rotp = Integer.parseInt(request.getParameter("otp"));
	            HttpSession ses = request.getSession(false);
	           int n = (Integer)ses.getAttribute("otp");
	           if(rotp==n)
	           {
	        	   bean= ForgotPasswordDao.forgotPassword(bean);
	               response.sendRedirect("HomePage.jsp");
	           }
	           else{
	               response.sendRedirect("invalidLogin.jsp");
	        } 
	        }
	        finally {            
	            out.close();
	        }
	}

}
