package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.UserProfileBO;
import Model.Bean.uploadfile;

@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = 0;

		try {
			uid = Integer.parseInt(request.getParameter("uid"));
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (uid != 0) {
			ArrayList<uploadfile> files = UserProfileBO.GetProcessedFile(uid);
			request.setAttribute("Files", files);
			String src = "/UserProfile.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(src);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}