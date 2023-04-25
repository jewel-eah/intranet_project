package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture.Lecture;
import lecture.controller.LectureDao;
import signUpClass.SignUpClass;
import signUpClass.SignUpClassRequestDto;
import signUpClass.controller.SignUpClassDao;
import user.User;
import user.controller.UserDao;

public class SignupClassAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Lecture lecture = null;
		User user = null;
		
		LectureDao lectureDao = LectureDao.getInstance();
		SignUpClassDao signupClassDao = SignUpClassDao.getInstance();
		user = (User) session.getAttribute("log");
				
		int userCode = user.getUserCode();
		String[] classification = request.getParameterValues("classification");
		String[] className = request.getParameterValues("classname");
		String[] major = request.getParameterValues("major");
		String[] department = request.getParameterValues("department");
		String[] professorName = request.getParameterValues("professorname");
		String[] classroom = request.getParameterValues("classroom");
		String[] credit = request.getParameterValues("credit");
		
		if(className != null) {
			for(int i=0; i<className.length; i++) {
				System.out.println(className[i]);
				lecture = lectureDao.getLectureByName(className[i]);
				String classCode = lecture.getClassCode();
				String insertClassification = classification[i];
				String insertClassName = className[i];
				String insertMajor = major[i];
				String insertDepartment = department[i];
				String insertProfessorName = professorName[i];
				String insertClassroom = classroom[i];
				int insertCredit = Integer.parseInt(credit[i]);
				
				SignUpClassRequestDto signupClassDto = new SignUpClassRequestDto(userCode, classCode, insertClassification, insertClassName, insertMajor, insertDepartment, insertProfessorName, insertClassroom, insertCredit);
				signupClassDao.createSignUpList(signupClassDto);
			}
		}
		response.sendRedirect("signupClass");
	}
}
