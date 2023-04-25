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

public class UserCreateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		DepartmentDao departmentDao = DepartmentDao.getInstance();
		ArrayList<Department> department = departmentDao.getDepartmentAll();
		
		request.setAttribute("department", department);

		MajorDao majorDao = MajorDao.getInstance();
		ArrayList<Major> major = majorDao.getMajorAll();
		request.setAttribute("major", major);
		
		request.getRequestDispatcher("masterUserCreate").forward(request, response);
	}
}
