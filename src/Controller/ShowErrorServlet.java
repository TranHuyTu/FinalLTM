package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _CONSTAINT.CONSTAINT;

@WebServlet("/ShowErrorServlet")
public class ShowErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowErrorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int errorCode = 0;
		int uid = 0;
		try {
			errorCode = Integer.parseInt(request.getParameter("errorCode"));
			uid = Integer.parseInt(request.getParameter("uid"));
		} catch (Exception e) {
			// TODO: handle exception
		}

		switch (errorCode) {
		case CONSTAINT.PROCESSING: {
			break;
		}
		case CONSTAINT.CONVERT_ERROR: {
			request.getSession().setAttribute("message",
					"Conversion error, please check the file name and try again later!");
			break;
		}
		case CONSTAINT.UPLOAD_ERROR: {
			request.getSession().setAttribute("message",
					"File upload error, please try again later!");
			break;
		}
		default:
			request.getSession().setAttribute("message", "Error, please try again later!");
			break;
		}

		response.sendRedirect("UserProfileServlet?uid=" + uid);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}