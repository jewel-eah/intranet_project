package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture.Lecture;
import lecture.controller.LectureDao;
import user.User;
import user.controller.UserDao;

public class ShowLectureInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		LectureDao lectureDao = LectureDao.getInstance();
		

		if (!request.getParameter("className").equals("")) {
			String className = request.getParameter("className");
			
			Lecture lecture = lectureDao.getLectureByName(className);
			UserDao userDao = UserDao.getInstance();
			User user = userDao.getUserByUserCode(lecture.getUserCode());
			String professorName = user.getUserName();
			
			HttpSession session = request.getSession();
			session.setAttribute("lecture", lecture);
			session.setAttribute("professorName", professorName);
			
			response.sendRedirect("showLectureInfo");
		} else {
			response.sendRedirect("lectureInfoForStudent");
		}

	}

}
