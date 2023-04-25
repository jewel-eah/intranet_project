package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import currentlySignUp.controller.CurrentlySignUpDao;
import user.User;

public class DeleteClassAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		HttpSession session = request.getSession();
		user = (User) session.getAttribute("log");
		
		int userCode = user.getUserCode();
		String classCode = request.getParameter("classCode");
        
        CurrentlySignUpDao currentlySignUpDao = CurrentlySignUpDao.getInstance();
        currentlySignUpDao.deleteSignUpData(userCode, classCode);
        
        response.sendRedirect("../service?command=currentlySignUpCheck");
	}
}
