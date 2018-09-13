package org.springboot.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	//@WebServlet(urlPatterns="/xs/*", description="Servlet的说明")
	private static final long serialVersionUID = 3301127181345921948L;

	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		System.out.println("doget");
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		System.out.println("dopost");
		resp.setContentType("text/html");  
        PrintWriter out = resp.getWriter();  
        out.println("<html>");  
        out.println("<head>");  
        out.println("<title>Hello World</title>");  
        out.println("</head>");  
        out.println("<body>");  
        out.println("<h1>大家好，我的名字叫Servlet2</h1>");  
        out.println("</body>");  
        out.println("</html>"); 
	}
}
