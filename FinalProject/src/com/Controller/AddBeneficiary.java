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

import com.Model.Beneficiary;
import com.Dao.BeneficiaryDao;

/**
 * Servlet implementation class AddBeneficiary
 */
@WebServlet("/AddBeneficiary")
public class AddBeneficiary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBeneficiary() {
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
		PrintWriter out = response.getWriter();
		System.out.println("entered post");
		Beneficiary beneficiary= new Beneficiary();
		beneficiary.setBeneficiaryName(request.getParameter("name"));
		beneficiary.setAccountNumber(request.getParameter("accountnumber"));
		beneficiary.setNickName(request.getParameter("nickname"));
		beneficiary.setBranchCode(request.getParameter("branchcode"));
		//beneficiary.setBankName(request.getParameter("bank"));	
		System.out.println("fields added");
		String s=request.getParameter("nickname");
		System.out.println(s);
		HttpSession session=request.getSession(true);
		String cid = (session.getAttribute("customerid")).toString();
		beneficiary.setCid(cid);
        System.out.println(cid);
		
		BeneficiaryDao bdo = new BeneficiaryDao();
		int i=bdo.find(s,cid);
		
		System.out.println(i);
		if(i<=0){
			System.out.println("entered if");
		int result = bdo.add(beneficiary);
		if(result !=0) {
			List<Beneficiary> list = BeneficiaryDao.showAll(cid);
			
			session.setAttribute("beneficiaryList", list);
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('User added successfully');");
			   out.println("</script>");
			  request.getRequestDispatcher("/successful.jsp").include(request, response);
			
		 } else {
			 response.sendRedirect("unsuccessful.jsp");
		 }
		}
		 else {
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Nickname already exists');");
			   out.println("</script>");
			   request.getRequestDispatcher("/addBeneficiary.jsp").include(request, response);
		}
	}
	}

