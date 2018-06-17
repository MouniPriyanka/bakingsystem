package editCustomer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userLoginPkg.ConnectionManager;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("In update servlet doPost");
		
		
		 Connection currentCon = null;
		  ResultSet rs = null; 
		  Statement stmt = null; 
		  int val=0;
		  
		HttpSession session=request.getSession();
		String oldssn=(String) session.getAttribute("ssn");
		System.out.println("ssn old :- "+ oldssn);
	
		//HttpSession session = request.getSession();
		String name=request.getParameter("name");
		String ssn=request.getParameter("ssn");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String residence=request.getParameter("residence");
		int customerid=Integer.parseInt(request.getParameter("customerid"));
		int phonenumber=Integer.parseInt(request.getParameter("phonenumber"));
		String email=request.getParameter("email");
		System.out.println("ssn new :- "+ ssn); // TO_DATE('"+dob+ "','yyyy-mm-dd')
		
		String updateQuery="UPDATE CustomerProfile SET CustomerID=" + customerid + ",Name = '" + name + "',Gender = '" + gender +
				"',DOB = TO_DATE('"+dob+ "','yyyy-mm-dd'),Residence = '"+residence + "',SSN = " + ssn +",PhoneNumber ="+ phonenumber + ",Email = '"+ email + "' WHERE ssn=" + oldssn ;
		System.out.println( "Update query is : " + updateQuery);
		try 
		 {
		    //connect to DB 
		    currentCon = ConnectionManager.getConnection();
		    currentCon.setAutoCommit(false);
		    stmt=currentCon.createStatement();
		    val = stmt.executeUpdate(updateQuery);	
		    currentCon.commit();
		    System.out.println("Rows Updated: - " + val);

		 } 

		 catch (Exception ex) 
		 {
			 

			    if (currentCon != null) {
			       try {
			    	   currentCon.rollback();
			    	   currentCon.setAutoCommit(true);
			          currentCon.close();
			       } catch (Exception e) {
			       }

			       currentCon = null;
			    }
			 
		    System.out.println("Sorry! Update Failed. An Exception has occurred! " + ex);
		 } 
			    
		 //some exception handling
		 finally 
		 {
		    if (rs != null)	{
		       try {
		          rs.close();
		       } catch (Exception e) {}
		          rs = null;
		       }
			
		    if (stmt != null) {
		       try {
		          stmt.close();
		       } catch (Exception e) {}
		          stmt = null;
		       }
			
		    if (currentCon != null) {
		       try {
		    	   currentCon.setAutoCommit(true);
		          currentCon.close();
		       } catch (Exception e) {
		       }

		       currentCon = null;
		    }
		 }
		
		//EditCustomerBean bean=new EditCustomerBean();
		//bean=EditCustomerDao.fillform(ssn);
		// request.setParameter("CustomerID", bean.getCustomerID());
		//session.setAttribute("currentSessionUser",bean);
		 response.sendRedirect("UserHome.jsp");
		
	}

}
