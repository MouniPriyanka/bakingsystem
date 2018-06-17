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

import com.Dao.*;
import com.Model.*;
/**
 * Servlet implementation class generatestatementserv
 */
@WebServlet("/generatestatementserv")
public class generatestatementserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public generatestatementserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		 GeneratestmtBean genstat = new GeneratestmtBean();
		 genstat.setAccountno(request.getParameter("fromaccount"));
		 String transway=request.getParameter("transway");
		 System.out.println(transway);
		 if("dateway".equals(transway)){
		 genstat.setfromdate(request.getParameter("fromdate"));
		 genstat.settodate(request.getParameter("todate"));
		 }
		 if("lastway".equals(transway)){
			 System.out.println("came to set lasttrans here");
			 String val=request.getParameter("lasttrans");
			genstat.setlasttrans(val);
		
		 }
		 
		List<GeneratestmtBean> statementList = CustomerDao.genstatement(genstat);
		HttpSession session = request.getSession(true);
		session.setAttribute("Genstsession", statementList);
		   request.getRequestDispatcher("/stmntdisplay.jsp").include(request, response);
		for(GeneratestmtBean s : statementList) {
			System.out.println(s.getdate());
		}


	}

}
