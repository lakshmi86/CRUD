
import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String n=request.getParameter("name");
		String em=request.getParameter("email");
		String c=request.getParameter("country");
		
		Emp e=new Emp();
		
		e.setName(n);
		e.setEmail(em);
		e.setCountry(c);		
		
		int status=EmpDao.save(e);
		
		if(status>0) {
			out.print("Saved Successfully");
			request.getRequestDispatcher("Index.html").include(request,response);
		}else
		{
			out.print("Sorry! unable to save");
		}
		out.close();
		
	}

}
