



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmationPage
 */
@WebServlet("/ConfirmationPage")
public class ConfirmationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmationPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
        try{
			 
    		Class.forName("com.mysql.jdbc.Driver");

    	    //creating connection with the database 
            Connection con=DriverManager.getConnection
                           ("jdbc:mysql://localhost:3306/testdb?autoReconnect=true&useSSL=false","root","root");
            PreparedStatement p1 =con.prepareStatement
                    ("select * from applicant");
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
