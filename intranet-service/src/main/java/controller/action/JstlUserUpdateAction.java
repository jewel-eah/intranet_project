package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import department.Department;
import department.controller.DepartmentDao;
import major.Major;
import major.controller.MajorDao;
import user.User;
import user.controller.UserDao;

public class JstlUserUpdateAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		UserDao userDao = UserDao.getInstance();
		int userCode = Integer.parseInt(request.getParameter("userCode"));
		
		if(!userDao.getNamebyUserCode(userCode).equals("")) {
			User user = userDao.getUserByUserCode(userCode);
			request.setAttribute("user", user);
			
			DepartmentDao departmentDao = DepartmentDao.getInstance();
			ArrayList<Department> department = departmentDao.getDepartmentAll();
			request.setAttribute("department", department);
			
			MajorDao majorDao = MajorDao.getInstance();
			ArrayList<Major> major = majorDao.getMajorAll();
			
			request.setAttribute("major", major);
			
			request.getRequestDispatcher("masterUserUpdate").forward(request, response);			
		} else {
			response.sendRedirect("../masterUser");
		}
	}
}
