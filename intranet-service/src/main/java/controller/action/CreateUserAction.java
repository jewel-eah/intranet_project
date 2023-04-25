package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import department.Department;
import department.controller.DepartmentDao;
import user.User;
import user.UserRequestDto;
import user.controller.UserDao;

public class CreateUserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		DepartmentDao depDao = DepartmentDao.getInstance();

		int userCode = Integer.parseInt(request.getParameter("userCode"));
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String addressCode = request.getParameter("addressCode");
		String birthDate = request.getParameter("birthDate");
		String accountNum = request.getParameter("account");
		String bankName = request.getParameter("bankOffice");
		String accountName = request.getParameter("accountName");
		String email = request.getParameter("email");
		String admDate = request.getParameter("admissionDate");
		String admType = request.getParameter("admissionType");
		int depCode = Integer.parseInt(request.getParameter("department"));
		Department department = depDao.getDepartmentBydepCode(depCode);
		String depName = department.getDepName();
		String mainMajor = request.getParameter("mainMajor");
		String subMajor = null;
		if(userType == "학생") {
			subMajor = request.getParameter("subMajor");			
		}
		String graduate = request.getParameter("graduate");
		String degree = request.getParameter("degree");
		String semester = request.getParameter("semester");
		
		UserDao userDao = UserDao.getInstance();
		UserRequestDto userDto = new UserRequestDto(userCode, password, userType, userName, gender, phone, address,
				addressCode, birthDate, accountNum, bankName, accountName, email, admDate, admType, depName, mainMajor,
				subMajor, graduate, degree, semester);
		userDao.createUser(userDto);

		response.sendRedirect("portalsite");

	}

}
