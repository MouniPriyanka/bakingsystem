package eligibilityCheckpkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EligibilityServlet
 */
@WebServlet("/EligibilityServlet")
public class EligibilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EligibilityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// eligibility check code goes here *****************************************
		
		try
		{	    
		     EligibilityBean eb = new EligibilityBean();
		     eb.setssn(request.getParameter("SSN"));
		     System.out.println("You entered ssn : - " + request.getParameter("SSN") );

		     eb = EligibilityDao.Check(eb);
			   		    
		     if (eb.isEligible())
		     {
		    	response.sendRedirect("RegisterCustomer.jsp");
			 }
			else{
				
			}
		
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}

		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
