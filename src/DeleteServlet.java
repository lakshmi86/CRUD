
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteServlet")


public class DeleteServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			String sid=request.getParameter("id");
			int id=Integer.parseInt(sid);
			
			int status=EmpDao.delete(id);
			response.sendRedirect("ViewServlet");
			
			if(status>0) {
				out.print("Saved Successfully");
			}else
			{
				out.print("Sorry! unable to save");
			}
			out.close();
	}

	
}
