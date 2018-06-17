package createAccount;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class createAccountServlet
 */
@WebServlet("/createAccountServlet")
public class createAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createAccountServlet() {
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
		try
		{	    

			 createAccountBean account = new createAccountBean();
		   	    				 
		     //Account Data
			 account.setCustomerID(Integer.parseInt(request.getParameter("customer_id")));
			 account.setBalance(Integer.parseInt(request.getParameter("balance")));
			 account.setAccountType(request.getParameter("account_type"));
			 account.setBranchCode(request.getParameter("branch_code"));
			 account.setOverDraft(request.getParameter("overdraft"));
			 
		     //transfer bean to DAO
			 account = createAccountDao.addAccount(account);
		     
		     if (account.isAdded())
		     {
			        
		          HttpSession session = request.getSession(true);	    
		          session.setAttribute("customer_id", account.getCustomerID());
		    	 System.out.println("Navigating to Customer Portfolio! " + " Attribute set : "+ account.getCustomerID());
		         // response.sendRedirect("AccountDetails.jsp?a="+account.getCustomerID()); 
		          
		    	 String popup = account.getPopupmsg();
			        response.setContentType("text/html");
					out.println("<html>");
					out.println("<body>");
					out.println("<script>");
					out.println( "alert('"+popup+"');" );
					out.println("window.location='AccountDetails.jsp?a="+ account.getCustomerID()+"'");
					out.println("</script>");
					out.println("</body>");
					out.println("</html>");
		        
		     }
			        
		     else {
		          //response.sendRedirect("RegisterCustomer.jsp"); 
		    	 System.out.println("Unsuccessful : Navigating to Customer Portfolio ! ");
		    		String popup = account.getPopupmsg();

					response.setContentType("text/html");
					out.println("<html>");
					out.println("<body>");
					out.println("<script>");
					out.println("alert('"+popup+"');");
					out.println("window.location='AccountDetails.jsp?a="+ account.getCustomerID()+"'");
					out.println("</script>");
					out.println("</body>");
					out.println("</html>");
		     }
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		
		
	}

}
