package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import currentlySignUp.CurrentlySignUp;
import currentlySignUp.controller.CurrentlySignUpDao;
import user.User;

public class CurrentlySignUpChecksAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("log");
		int userCode = user.getUserCode();
		CurrentlySignUpDao currentlySignUpDao = CurrentlySignUpDao.getInstance();
		ArrayList<CurrentlySignUp> currentlylist = currentlySignUpDao.getCurrentlySignUpByUser(userCode);
		request.setAttribute("currentlylist", currentlylist);
		
		request.getRequestDispatcher("currentlySignUp").forward(request, response);
	}
}