package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture.Lecture;
import lecture.LectureRequestDto;
import lecture.controller.LectureDao;
import user.User;

public class ModifyLectureInfoAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("log");
		String classCode = request.getParameter("classCode");
		String information = request.getParameter("information");
		
		
		LectureDao lectureDao = LectureDao.getInstance();
		Lecture lecture = lectureDao.getLectureByClassCode(classCode);
		
		LectureRequestDto lectureDto = new LectureRequestDto
				(classCode, lecture.getUserCode(), lecture.getMajor(), lecture.getDepartment(), lecture.getClassName(),
						lecture.getClassification(), lecture.getCredit(), lecture.getClassroom(), information);
		
		lectureDao.modifyLectureInfo(lectureDto);

		ArrayList<Lecture> list = lectureDao.getLectureByUserCode(user.getUserCode());
		request.setAttribute("list", list);
		request.getRequestDispatcher("lectureInfo").forward(request, response);

	}
}
