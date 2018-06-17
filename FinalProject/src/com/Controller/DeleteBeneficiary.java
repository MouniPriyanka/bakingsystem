package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.BeneficiaryDao;
import com.Model.Beneficiary;
import com.Model.Cb;

/**
 * Servlet implementation class DeleteBeneficiary
 */
@WebServlet("/DeleteBeneficiary")
public class DeleteBeneficiary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBeneficiary() {
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
		PrintWriter out = response.getWriter();
		doGet(request, response);
		String[] s= request.getParameterValues("user");
		for (String value : s) {
			System.out.println(value);
		}
		Cb cb= new Cb();
		cb.setValue(s);
		HttpSession session=request.getSession(true);
		String cid = (session.getAttribute("customerid")).toString();
		for(String name : s){
		int  i = BeneficiaryDao.delete(name,cid);
		if(i>0) {
			System.out.println("deleted successfully");
			
			List<Beneficiary> list = BeneficiaryDao.showAll(cid);
			
			session.setAttribute("beneficiaryList", list);
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Deleted Successfully');");
			  // out.println("location='deleteBeneficiary.jsp';");
			   out.println("</script>");
			   request.getRequestDispatcher("/deleteBeneficiary.jsp").include(request, response);
			//response.sendRedirect("deleteBeneficiary.jsp");
		} else {
			System.out.println("unsuccessful");
		}
		}
	}

}
