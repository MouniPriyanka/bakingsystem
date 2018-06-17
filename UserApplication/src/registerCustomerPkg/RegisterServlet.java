package registerCustomerPkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		try
		{	    

			 RegisterCustomerBean user = new RegisterCustomerBean();
		    // user.setCustomerID(Integer.parseInt(request.getParameter("CustomerID")));
		     user.setName(request.getParameter("Name"));
		     user.setGender(request.getParameter("Gender"));
		     user.setDOB(request.getParameter("DOB"));
		     user.setResidence(request.getParameter("Residence"));
		     user.setPhone(Integer.parseInt(request.getParameter("Phone")));
		     user.setSSN(Integer.parseInt(request.getParameter("SSN")));
		     user.setEmail(request.getParameter("Email"));
		    
			 
		     //Account Data
		     user.setBalance(Integer.parseInt(request.getParameter("Balance")));
		     user.setAccountType(request.getParameter("AccountType"));
		     user.setBranchCode(request.getParameter("BranchCode"));
		     user.setOverDraft(request.getParameter("OverDraft"));
	
		     
		     //transfer bean to DAO
		     user = RegisterDAO.register(user);
		     
		     if (user.isRegistered())
		     {
			        
		          HttpSession session = request.getSession(true);	    
		          session.setAttribute("c_id", user.getC_id());
		    	 System.out.println("Navigating to Customer Portfolio! " + " Attribute set : "+ user.getC_id());
		          response.sendRedirect("RegisterConfirm.jsp"); 
		        
		     }
			        
		     else {
		          //response.sendRedirect("RegisterCustomer.jsp"); 
		    	 System.out.println("Unsuccessful : Navigating to Customer Portfolio ! ");
		     }
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		
		
		
	}

	

}
