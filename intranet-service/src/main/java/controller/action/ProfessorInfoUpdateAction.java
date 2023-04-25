package controller.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;
import user.UserRequestDto;
import user.controller.UserDao;

public class ProfessorInfoUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("log");
		
		int userCode = user.getUserCode();
		String password = request.getParameter("userPassword");
		String userType = user.getUserType();
		String userName = user.getUserName();
		String gender = user.getGender();
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String addressCode = request.getParameter("addressCode");
		String birthDate = user.getBirthDate();
		String accountNum = user.getAccountNum();
		String bankName = user.getBankName();
		String accountName = user.getAccountName();
		String email = request.getParameter("email");
		String admDate = user.getAdmDate();
		String admType = user.getAdmType();
		String depName = user.getDepName();
		String mainMajor = user.getMainMajor();
		String subMajor = user.getSubMajor();
		String graduate = user.getGraduate();
		String degree = user.getDegree();
		String semester = user.getSemester();
		
		UserDao userDao = UserDao.getInstance();
		UserRequestDto userDto = new UserRequestDto(userCode, password, userType, userName, gender, phone, address,
				addressCode, birthDate, accountNum, bankName, accountName, email, admDate, admType, depName, mainMajor,
				subMajor, graduate, degree, semester);
		userDao.updateStudentPart(userDto);

		User studentInfo = userDao.getUserByUserCode(userCode);
		session.setAttribute("log", studentInfo);
		
		
		request.setAttribute("updateSuccess", true);
		request.getRequestDispatcher("professorUpdate").forward(request, response);
	
	}
}
