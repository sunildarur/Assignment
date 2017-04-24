



import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmPage
 */
@WebServlet("/ConfirmPage")
public class ConfirmPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		 try{
			 
		Class.forName("com.mysql.jdbc.Driver");

	    //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/testdb?autoReconnect=true&useSSL=false","root","root");
        PreparedStatement p1 =con.prepareStatement
                ("select max(applNumber) from applicant");
        ResultSet rs =p1.executeQuery();
        request.setAttribute("Accnum", rs.getString("applNumber"));
        
        RequestDispatcher rt = request.getRequestDispatcher("ConfirmationPage.jsp");
        rt.forward(request, response);

		 }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}
}
