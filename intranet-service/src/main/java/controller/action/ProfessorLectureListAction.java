package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture.Lecture;
import lecture.controller.LectureDao;
import user.User;

public class ProfessorLectureListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("log");
		
		LectureDao lectureDao = LectureDao.getInstance();
		ArrayList<Lecture> list = lectureDao.getLectureByUserCode(user.getUserCode());
		
		request.setAttribute("lecture", list);
		request.getRequestDispatcher("professorLectureList").forward(request, response);
		
	}
}
