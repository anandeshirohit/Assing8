
import java.sql.*;

import javax.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class LoginForm extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		response.setContentType("form/html");
		PrintWriter out= response.getWriter();
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql:///sys","root","root");
		/*	Class.forName("com.mysql.jdbc.Driver");
			String jdbc="jdbc:mysql://localhost:3306/sys";
			String username="root";
			String password="root";
			
			Connection con= null;
			
		con= DriverManager.getConnection(jdbc,username,password);*/
		Statement st=con.createStatement();
		
		String x= request.getParameter("name");
		String y=request.getParameter("dept");
		String sql="insert into employee values('"+x+"','"+y+"')";
		st.executeUpdate(sql);
		
		
		out.println("<h1>Record Created</h1>");
		RequestDispatcher rd= request.getRequestDispatcher("/form.html");
		rd.include(request,response);
		}
	
	catch(ClassNotFoundException e){
		out.println("class not found");
	}
	}
	catch(SQLException SE){
		throw new RuntimeException("cannot connect to database", SE);
	}
	}

}
    