package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import currentlySignUp.CurrentlySignUp;
import currentlySignUp.controller.CurrentlySignUpDao;
import signUpClass.SignUpClass;
import signUpClass.controller.SignUpClassDao;
import user.User;
import user.controller.UserDao;

public class signupCheckClassAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("log");
		request.setAttribute("log", user);
		
		SignUpClassDao signupClassDao = SignUpClassDao.getInstance();
		
		
		ArrayList<SignUpClass> list = signupClassDao.getSignUpClassAll();
		
		
		request.setAttribute("list", list);
		int userCode = user.getUserCode();
		CurrentlySignUpDao currentlySignUpDao = CurrentlySignUpDao.getInstance();
		ArrayList<CurrentlySignUp> currentlylist = currentlySignUpDao.getCurrentlySignUpByUser(userCode);
		
		
		request.setAttribute("currentlylist", currentlylist);
		
		request.getRequestDispatcher("signupClass").forward(request, response);
	}
}
