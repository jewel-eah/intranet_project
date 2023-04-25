package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;
import user.UserRequestDto;
import user.controller.UserDao;

public class StudentUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("log");

		int userCode = user.getUserCode();
		String password = user.getUserPassword();
		String userType = user.getUserType();
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
		String admDtae = user.getAdmDate();
		String admType = user.getAdmType();
		String depName = user.getDepName();
		String mainMajor = user.getMainMajor();
		String subMajor = user.getSubMajor();
		String graduate = user.getGraduate();
		String degree = user.getDegree();
		String semester = user.getSemester();

		UserDao userDao = UserDao.getInstance();
		UserRequestDto userDto = new UserRequestDto(userCode, password, userType, userName, gender, phone, address,
				addressCode, birthDate, accountNum, bankName, accountName, email, admDtae, admType, depName, mainMajor,
				subMajor, graduate, degree, semester);
		userDao.updateStudentPart(userDto);

		User studentInfo = userDao.getUserByUserCode(userCode);
		session.setAttribute("log", studentInfo);

		response.sendRedirect("studentInfo");

	}

}
