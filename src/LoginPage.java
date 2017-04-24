



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet(description = "Servlet for Login Page Functionality", urlPatterns = { "/LoginPage" })
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(ValidationPage.checkUser(username, password))
        {
            RequestDispatcher rs = request.getRequestDispatcher("ApplicationPage.jsp");
            rs.forward(request, response);
        }
        else
        {
           out.println("<span id='invcred' class='messageBox'>Invalid Credentials!</span>"); 
           RequestDispatcher rs = request.getRequestDispatcher("BankLogin.jsp");
           rs.include(request, response);
        }
	}

}
