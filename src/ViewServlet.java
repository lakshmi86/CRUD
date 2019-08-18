import java.util.*;
import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			 response.setContentType("text/html");  
		     PrintWriter out=response.getWriter();  
		     
		     out.println("<a href='Index.html'>Add New Employee</a>");
		     out.println("<h1>Employees List</h1>");
		     
		     List<Emp> list=EmpDao.view();
		     
		     out.print("<table border='1' width='100%'");  
		     out.print("<tr><th>ID</th><th>Name</th><th>Email</th><th>Country</th><th>EDIT</th><th>DELETE</th></tr>");
		     
		     for(Emp e:list) {
		    	 
		    	 out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td>"
		    	 		+ "<td><a href='EditServletById?id="+e.getId()+"'>EDIT</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>DELETE</a></td>");
		    	 
		     }
		     
		     
			out.print("</table>");
			out.close();
	}
}
