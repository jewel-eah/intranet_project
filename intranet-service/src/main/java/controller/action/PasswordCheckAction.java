package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;

public class PasswordCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("log");
		
		String password = request.getParameter("userPassword");
		
		if (password.equals(user.getUserPassword())) {
			if(user.getUserType().equals("교수")) {
				response.sendRedirect("professorUpdate");				
			}
			else if(user.getUserType().equals("학생")) {
				response.sendRedirect("studentInfoChange");				
			}
		}
		else {
			response.sendRedirect("professorLogCheck");
		}
	}

}
