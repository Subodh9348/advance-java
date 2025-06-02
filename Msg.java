package com.subodh.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Msg
 */
@WebServlet("/Msg")
public class Msg extends HttpServlet {
	
//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		String name=req.getParameter("name");
//		PrintWriter wrt=res.getWriter();
//		wrt.append(name+",good evening");
//		
//	}
//
//}
//..................................................................
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String name = req.getParameter("name");
    res.setContentType("text/html");
    PrintWriter wrt = res.getWriter();

    java.util.Calendar cal = java.util.Calendar.getInstance();
    int hour = cal.get(java.util.Calendar.HOUR_OF_DAY);

    String greeting;
    if (hour < 12) {
        greeting = "Good morning";
    } else if (hour < 17) {
        greeting = "Good afternoon";
    } else {
        greeting = "Good evening";
    }

    wrt.println("<html><body>");
    wrt.println("<h2>" + name + ", " + greeting + "!</h2>");
    wrt.println("</body></html>");
}
}
