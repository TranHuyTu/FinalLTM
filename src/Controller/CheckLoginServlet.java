package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.CheckLoginBO;
import Model.BO.GetUserBO;
import Model.Bean.user;

@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " -" + password);

		if (username.equals("") || password.equals("")) {
			request.getSession().setAttribute("message",
					"Invalid username and password!");
			response.sendRedirect("HomePage.jsp");
		} else {
			if (CheckLoginBO.CheckLogin(username, password)) {
				System.out.println("here");
				user user = GetUserBO.GetUser(username);
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("message", "Logged successfully!");
				response.sendRedirect("HomePage.jsp");

			} else {
				request.getSession().setAttribute("message",
						"An error occurred, please check your account information!");
				response.sendRedirect("LoginServlet");
			}
		}
	}

}