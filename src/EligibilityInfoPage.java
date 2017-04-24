



import java.io.IOException;
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
 * Servlet implementation class EligibilityInfoPage
 */
@WebServlet("/EligibilityInfoPage")
public class EligibilityInfoPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EligibilityInfoPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
		//boolean st =false;

        try{
        
        	
        String accounttype = request.getParameter("accounttype");
        String initialdeposit = request.getParameter("initialdeposit");
        String directdepositmonthly = request.getParameter("directdeposit");
        String debitcardvisamaster = request.getParameter("debitcard");
        String loanrequirement = request.getParameter("loanamount");
        String creditscore = request.getParameter("creditscore");

        request.setAttribute("credit", creditscore);
        request.setAttribute("directDepositMonthly", directdepositmonthly);

        
        if(creditscore.equals("Bad") && directdepositmonthly.equals("1")){
        	request.setAttribute("interestrate", 14.4);
        	request.setAttribute("discount", 10);
        }else if(creditscore.equals("Fair") && directdepositmonthly.equals("1")){
        	request.setAttribute("interestrate", 10.8);
        	request.setAttribute("discount", 10);
        }else if(creditscore.equals("Good") && directdepositmonthly.equals("1")){
        	request.setAttribute("interestrate", 7.2);
        	request.setAttribute("discount", 10);
        }else if(creditscore.equals("Excellent") && directdepositmonthly.equals("1")){
        	request.setAttribute("interestrate", 3.6);
        	request.setAttribute("discount", 10);
        }else if(creditscore.equals("Bad") && directdepositmonthly.equals("0")){
        	request.setAttribute("interestrate", 16.0);
        	request.setAttribute("discount", 10);
        }else if(creditscore.equals("Fair") && directdepositmonthly.equals("0")){
        	request.setAttribute("interestrate", 12.0);
        	request.setAttribute("discount", 10);
        }else if(creditscore.equals("Good") && directdepositmonthly.equals("0")){
        	request.setAttribute("interestrate", 8.0);
        	request.setAttribute("discount", 10);
        }else if(creditscore.equals("Excellent") && directdepositmonthly.equals("0")){
        	request.setAttribute("interestrate", 4.0);
        	request.setAttribute("discount", 10);
        }
        
        
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	    //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/testdb?autoReconnect=true&useSSL=false","root","root");
        
        PreparedStatement pr =con.prepareStatement
                ("truncate eligibility");
        
        PreparedStatement ps =con.prepareStatement
                ("insert into eligibility (accounttype,intialDeposit,directDepositMonthly,debitCardVisaMaster,"
                		+ "loanRequirement,creditscore) values (?,?,?,?,?,?)");
        
        ps.setString(1, accounttype);
        ps.setString(2, initialdeposit);
        ps.setString(3, directdepositmonthly);
        ps.setString(4, debitcardvisamaster);
        ps.setString(5, loanrequirement);
        ps.setString(6, creditscore);
        
        pr.execute();
        ps.executeUpdate();  
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        RequestDispatcher rs = request.getRequestDispatcher("ConfirmationPage.jsp");
        rs.forward(request, response);
   
	}
}
