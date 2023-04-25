package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;
import user.controller.UserDao;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		request.setCharacterEncoding("UTF-8");
		int userCode = Integer.parseInt(request.getParameter("userCode"));
		String userPassword = request.getParameter("userPassword");
		
		UserDao userDao = UserDao.getInstance();
		user = userDao.getUserByUserCode(userCode);
		
		if(userPassword.equals(user.getUserPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("log", user);
			response.sendRedirect("portalsite");
		}
		else
			response.sendRedirect("login");
	}
}