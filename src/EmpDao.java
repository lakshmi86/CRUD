import java.io.*;
import java.sql.*;
import java.util.*;


public class EmpDao{
	
	
	public static Connection getConnection() {
		
		Connection con=null;
		try {						
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root", "admin");						
		}catch(Exception e1) {
			System.out.println(e1);
		}
		
		return con;		
	}
	
	public static int save(Emp e) {
		
		int status=0;
		try {
			
				Connection con=EmpDao.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into register values(null,?,?,?)");
											
					ps.setString(1, e.getName());
					ps.setString(2, e.getEmail());
					ps.setString(3, e.getCountry());
			
					status=ps.executeUpdate();
					
					con.close();
		
		}catch(Exception e2) {
			System.out.println(e2);
		}
		return status;
	}
	
	public static List<Emp> view(){
		
		Connection con;
		List<Emp> list=new ArrayList<Emp>();
		
		try {
		con=EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from register");
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			Emp e=new Emp();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setEmail(rs.getString(3));
			e.setCountry(rs.getString(4));
			
			list.add(e);
		}
		
		}catch(Exception e2) {
			System.out.println(e2);
		}
		
	return list;
	}
	
	public static int delete(int id1) {
		
		int status=0;
		Connection con;
		try {
			con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from register where Id=?");
			ps.setInt(1,id1 );
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e2) {
			System.out.println(e2);
		}
		return status;
			
	}
	
	public static Emp updateById(int id) {
		
		/* When user clicks edit link from ViewServlet 
		 
		EditServletById is invoked, getting the particular ID and then taking all the values of the particular id from the table
		
		and displaying into the corresponding textboxes for further update   */
		
		Emp e=new Emp();
		Connection con;
		try {
			con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from register where Id=?");
			
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setEmail(rs.getString(3));
			e.setCountry(rs.getString(4));
			
			con.close();
			}
			
		}catch(Exception e2) {
			System.out.println(e2);
		}
		
		return e;		
	}
	
	public static int update(Emp emp) {
		
		int status=0;
		Connection con;
		//Emp e=new Emp();
		
		try {
			
			con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update register set Name=?,Email=?,Country=? where Id=?");
						
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getCountry());
			ps.setInt(4,emp.getId());
			
			status=ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e2) {
			System.out.println(e2);
		}
		
		return status;
	}
}