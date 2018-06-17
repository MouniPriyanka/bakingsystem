package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.FundsTransferDao;


/**
 * Servlet implementation class FundsTransfer
 */
@WebServlet("/FundsTransfer")
public class FundsTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundsTransfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 PrintWriter out = response.getWriter();  
		String from = request.getParameter("fromaccount");
		String to = request.getParameter("toaccount");//beneficiary name
		int amount = Integer.parseInt(request.getParameter("amount"));
		try {
			FundsTransferDao tdo = new FundsTransferDao();
			if(tdo.minAmount(from,to,amount)) {
				 tdo.transaction(from,to,amount);
				 out.println("<script type=\"text/javascript\">");
				 out.println("alert('Minimum balance should be $5000');");
				 out.println("</script>");
				
				
			}else {
				 tdo.transaction(from,to,amount);
				 out.println("<script type=\"text/javascript\">");  
				 out.println("alert('Transaction Sucessfull!!');");  
				 out.println("</script>");
			}
		   
			   request.getRequestDispatcher("/Generatestmtjsp.jsp").include(request, response);
		  
		 
		}
		catch(Exception e){
response.sendRedirect("error.jsp");
			
			e.printStackTrace();
			
		}
		
	}
	

}
