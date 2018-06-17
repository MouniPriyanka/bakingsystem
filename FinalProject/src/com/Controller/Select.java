package com.Controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.BeneficiaryDao;
import com.Dao.UserDao;
import com.Model.Beneficiary;
import com.Model.User;
import java.util.List;

/**
 * Servlet implementation class Select
 */
@WebServlet("/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession(true);
		String cid = (session.getAttribute("customerid")).toString();
		System.out.println(cid);
		List<Beneficiary> list = BeneficiaryDao.showAll(cid);
		System.out.println(list);
		session.setAttribute("beneficiaryList", list);
		//response.sendRedirect("deleteBeneficiary.jsp");
		request.getRequestDispatcher("/deleteBeneficiary.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		/*HttpSession session=request.getSession(true);
		String cid = (session.getAttribute("customerid")).toString();
		List<Beneficiary> list = BeneficiaryDao.showAll(cid);
		session.setAttribute("beneficiaryList", list);
		response.sendRedirect("deleteBeneficiary.jsp");*/
		
	}

}
