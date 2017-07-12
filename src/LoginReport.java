import java.sql.*;
import javax.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class LoginReport extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try{
		response.setContentType("form/html");
		PrintWriter out= response.getWriter();
	try{
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql:///sys","root","root");
		/*Class.forName("com.mysql.jdbc.Driver");
		String jdbc="jdbc:mysql://localhost:3306/sys";
		Connection con=null;
		String username="root";
		String password="root";
		
		con= DriverManager.getConnection(jdbc,username,password);*/
		Statement st=con.createStatement();
		
		String z= request.getParameter("dept");
		String sql="select * from employee where dept=z";
		out.println("<h1>Employee Details</h1>");
		ResultSet rs= st.executeQuery(sql);
		out.println("<table border ='2'>");
		out.println("<tr>");
		out.println("<th>NAME</th>");
		out.println("<th>DEPT</th>");
		out.println("</tr>");
		
		while(rs.next())
		{
			String ename=rs.getString("name");
			String dept=rs.getString("dept");
			out.println("<tr>");
			out.println("<td>"+ename+"</td>");
			out.println("<td>"+dept+"</td>");
			out.println("</tr>");
			
		}
		out.println("</table>");
		
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
	
	
	
	
	
	
	
	