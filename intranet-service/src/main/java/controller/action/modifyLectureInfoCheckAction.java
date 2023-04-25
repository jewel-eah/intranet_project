package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture.Lecture;
import lecture.controller.LectureDao;

public class modifyLectureInfoCheckAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LectureDao lectureDao = LectureDao.getInstance();
		String classCode = request.getParameter("classCode");
		ArrayList<Lecture> lecture = lectureDao.getLuctureByClassCode(classCode);
		System.out.println("classcode: " + classCode);
		request.setAttribute("lecture", lecture);
		
		request.getRequestDispatcher("modifyLectureInfo").forward(request, response);
	}
}
