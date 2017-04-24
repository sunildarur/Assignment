



import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ApplicationInformationPage
 */
@WebServlet("/ApplicationInformationPage")
public class ApplicationInformationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationInformationPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
		boolean st =false;
        try{
        String firstname = request.getParameter("firstname");
        String middlename = request.getParameter("middlename");
        String lastname = request.getParameter("lastname");
        String addressline1 = request.getParameter("addressline1");
        String addressline2 = request.getParameter("addressline2");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        
        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);
        
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	    //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/testdb?autoReconnect=true&useSSL=false","root","root");
        PreparedStatement p1 =con.prepareStatement
                ("select * from Applicant where applfirstname=? and appllastname=?");
        p1.setString(1, firstname);
        p1.setString(2, lastname);
        
        PreparedStatement p3 =con.prepareStatement
                ("SET SQL_SAFE_UPDATES = 0");
        
        PreparedStatement ps =con.prepareStatement
                            ("insert into Applicant (applfirstname,applmidname,appllastname,appaddrline1,appaddrline2,city"
                            		+ ",state,zipcode) values (?,?,?,?,?,?,?,?)");

        ps.setString(1, firstname);
        ps.setString(2, middlename);
        ps.setString(3, lastname);
        ps.setString(4, addressline1);
        ps.setString(5, addressline2);
        ps.setString(6, city);
        ps.setString(7, state);
        ps.setString(8, zipcode);
        
        PreparedStatement p2 =con.prepareStatement
                ("update Applicant set applfirstname=?,applmidname=?,appllastname=?,appaddrline1=?,appaddrline2=?,city=?"
                		+ ",state=?,zipcode=? where applfirstname=? and appllastname=?");
		
		p2.setString(1, firstname);
		p2.setString(2, middlename);
		p2.setString(3, lastname);
		p2.setString(4, addressline1);
		p2.setString(5, addressline2);
		p2.setString(6, city);
		p2.setString(7, state);
		p2.setString(8, zipcode);
		p2.setString(9, firstname);
		p2.setString(10, lastname);
        
        p3.executeUpdate();
        if (st){
        	p2.executeUpdate();
        }else{
        	ps.executeUpdate();
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        	RequestDispatcher rs = request.getRequestDispatcher("IncomePage.jsp");
            rs.forward(request, response);

            
        }
	}


