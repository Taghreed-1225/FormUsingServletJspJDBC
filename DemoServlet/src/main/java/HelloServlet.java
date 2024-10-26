

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter pw =response.getWriter();
//		String s =request.getParameter("t1");
//		pw.println("<h1>Hello"+s);
//		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 String email=request.getParameter("email");
		 String phone=request.getParameter("phone");
		 Member member=new Member(username, password, email, phone);
		 DaoRegister rdao=new DaoRegister();
		 String result=rdao.insert(member);
		 
		 //response.getWriter().println(result);
		 
		 request.setAttribute("username", username);
	        request.setAttribute("email", email);
	        request.setAttribute("phone", phone);
	     // توجيه الطلب إلى صفحة JSP
	        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
	        dispatcher.forward(request, response);
	    }
	}


