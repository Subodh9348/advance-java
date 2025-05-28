package com.subodh.orderpizza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	
    
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String ccno = request.getParameter("cardno");
	    String rccno = request.getParameter("rcardno");

	    if (ccno != null && ccno.equalsIgnoreCase(rccno)) {
	        request.getRequestDispatcher("display.jsp").forward(request, response);
	    } else {
	        request.getRequestDispatcher("invalid.jsp").forward(request, response);
	    }
	}


}
