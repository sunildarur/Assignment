



import java.io.IOException;
//import java.io.PrintWriter;
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
 * Servlet implementation class IncomePage
 */
@WebServlet("/IncomePage")
public class IncomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomePage() {
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
        String ssn = request.getParameter("ssnnumber");
        String modeofincome = request.getParameter("modeofincome");
        String annualincome = request.getParameter("annualincome");
        String houserentown = request.getParameter("houserentown");
        String rentleaseamount = request.getParameter("rentleaseamount");
        
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	    //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/testdb?autoReconnect=true&useSSL=false","root","root");
        
        PreparedStatement p1 =con.prepareStatement
                ("select * from income where ssn=?");
        
        p1.setString(1, ssn);
        
        
        PreparedStatement ps =con.prepareStatement
                            ("insert into income (ssn,incomemode,annual,housemode,"
                            		+ "rent) values (?,?,?,?,?)");

        ps.setString(1, ssn);
        ps.setString(2, modeofincome);
        ps.setString(3, annualincome);
        ps.setString(4, houserentown);
        ps.setString(5, rentleaseamount);
        
        PreparedStatement p2 =con.prepareStatement
                ("update income set ssn=?,incomemode=?,annual=?,housemode=?,rent=? where ssn=? ");
        
        p2.setString(1, ssn);
        p2.setString(2, modeofincome);
        p2.setString(3, annualincome);
        p2.setString(4, houserentown);
        p2.setString(5, rentleaseamount);
        p2.setString(6, ssn);
       
        
        ResultSet rs =p1.executeQuery();
        st = rs.next();
        if (st){
        	p2.executeUpdate();
        }else{
        	ps.executeUpdate();
        }     
       }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    	RequestDispatcher rp = request.getRequestDispatcher("EligibilityInfoPage.jsp");
        rp.forward(request, response);
		}
	}
