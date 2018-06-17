package editCustomer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userLoginPkg.ConnectionManager;


/**
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/EditCustomerServlet")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("In doPost");
		HttpSession session = request.getSession();
		String ssn=request.getParameter("hf1");
		String customerid=request.getParameter("customerid");
		System.out.println("customerid in session :- " +customerid );
		System.out.println("ssn new :- "+ ssn);
		EditCustomerBean bean=new EditCustomerBean();
		bean=EditCustomerDao.fillform(ssn);
		// request.setParameter("CustomerID", bean.getCustomerID());
		session.setAttribute("currentSessionUser",bean);
		session.setAttribute("ssn", ssn);
		session.setAttribute("customerid", customerid);
		 response.sendRedirect("EditCustomer.jsp");
	
		
		 
		 
	}

}
