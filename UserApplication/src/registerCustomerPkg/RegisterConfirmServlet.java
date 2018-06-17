package registerCustomerPkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userLoginPkg.UserBean;
import userLoginPkg.UserDao;

/**
 * Servlet implementation class RegisterConfirmServlet
 */
@WebServlet("/RegisterConfirmServlet")
public class RegisterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{	    

		     RegisterconfirmBean user = new RegisterconfirmBean();
		     //user.setUserName(request.getParameter("un"));
		     //user.setPassword(request.getParameter("pw"));
		     System.out.println("In REgisterconfirmServlet ");
		     HttpSession session = request.getSession(true);	    
		        //  session.setAttribute("currentSessionUser",user);
		          int value =Integer.parseInt( String.valueOf(session.getAttribute("c_id")) );
				     user.setC_id(value);
				     user = RegisterconfirmDao.confirm(user);
		     
			   		    
		     if (user.isConfirmstatus())
		     {
			        
		         
		          response.sendRedirect("UserHome.jsp"); //logged-in page      		
		     }
			        
		     else {
		         // response.sendRedirect("UserHome.jsp"); //error page
		     }
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		     theException.printStackTrace();
		}
		
		
	}

}
