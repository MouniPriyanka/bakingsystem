package deleteAccount;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class CloseAccountServlet
 */
@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccountServlet() {
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
		try{
			
			DeleteAccountBean account = new DeleteAccountBean();
	   	     
		     //Account Data
			
			account.setAccountNumber(Integer.parseInt(request.getParameter("account_number")));
			account.setCustomer_id(Integer.parseInt(request.getParameter("hf2")));
			System.out.println("in do post  ; account number = " + request.getParameter("account_number") + " , " + request.getParameter("hf2")  );
			account= DeleteAccountDao.closeAccount(account);
			
			if(account.isClosed()){
				 HttpSession session = request.getSession(true);	    
		          session.setAttribute("delete", "Account Deleted : "+account.getAccountNumber());
		          session.setAttribute("customer_id",  account.getCustomer_id());
		          System.out.println( " customerid is : - " + account.getCustomer_id() );
				
		        response.setContentType("text/html");
				out.println("<html>");
				out.println("<body>");
				out.println("<script>");
				out.println( "alert('Account Closed!');" );
				out.println("window.location='AccountDetails.jsp?a="+ account.getCustomer_id()+"'");
				out.println("</script>");
				out.println("</body>");
				out.println("</html>");
				
				//request.getRequestDispatcher("/AccountDetails.jsp?a="+ account.getCustomer_id()).forward(request, response);
		         //response.sendRedirect("AccountDetails.jsp?a="+ account.getCustomer_id());  
			}
			else{
				
				System.out.println("Unsuccessful!");
				 HttpSession session = request.getSession(true);	    
		          session.setAttribute("delete", "Account Deleted : "+account.getAccountNumber());
		          session.setAttribute("customer_id",  account.getCustomer_id());
		          System.out.println( " customerid is : - " + account.getCustomer_id() );
				String popup = account.getpopup();

				response.setContentType("text/html");
				out.println("<html>");
				out.println("<body>");
				out.println("<script>");
				out.println("alert('" + "Balance should be made $0 to delete Account!" + "');");
				out.println("window.location='AccountDetails.jsp?a="+ account.getCustomer_id()+"'");
				out.println("</script>");
				out.println("</body>");
				out.println("</html>");
				//request.getRequestDispatcher("/AccountDetails.jsp?a="+ account.getCustomer_id()).forward(request, response);
		        
			}
			
			
		}
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		finally{
			out.close();
		}
	}

}
