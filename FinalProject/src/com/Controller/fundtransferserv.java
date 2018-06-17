package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Dao.*;
import com.Model.*;

/**
 * Servlet implementation class fundtransferserv
 */
@WebServlet("/fundtransferserv")
public class fundtransferserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fundtransferserv() {
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
		//doGet(request, response);
		 PrintWriter out = response.getWriter();  
		 response.setContentType("text/html");  
		int res;
		 FundtransBean fundtransBean = new FundtransBean();
		 fundtransBean.setfromaccountno(request.getParameter("fromaccount"));
		 fundtransBean.settoaccountno(request.getParameter("toaccount"));
		  String amount=request.getParameter("amount").toString();
		 fundtransBean.setamount(amount);
		  try {
			 res = CustomerDao.fundtransfer(fundtransBean);
			 if(res>0){
				 out.println("<script type=\"text/javascript\">");  
				 out.println("alert('Transaction Sucessfull!!');");  
				 out.println("</script>");
				 try 
			     {
			        //connect to DB 
					Connection currentCon = DBHelperV.getConnection();
			        Statement stmt = currentCon.createStatement();
			        String squery="insert into transactions values(transid.nextval,CURRENT_DATE,'withdraw','account transfer',"
				            +fundtransBean.getamount()
				            +","
				            +fundtransBean.getfromaccountno()
				            +","
				            +fundtransBean.gettoaccountno()
			        		+")";  
			        System.out.println("Query: "+squery);
			        int  i = stmt.executeUpdate(squery);	        
			         System.out.println(" res value in try:"+i);
			         
			     } 

			     catch (Exception ex) 
			     {
			        System.out.println("transaction table error!" + ex);
			     } 
				  request.getRequestDispatcher("/Generatestmtjsp.jsp").include(request, response);
				
			 }
			 else
			 {
				 out.println("<script type=\"text/javascript\">");  
				 out.println("alert('Something went wrong!Please try again..');");  
				 out.println("</script>");
				 
			 }
		} catch (ClassNotFoundException | UnsufficientFundException | SQLException e) {
			response.sendRedirect("error.jsp");
			
			e.printStackTrace();
		}
	}

}
