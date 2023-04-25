package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SCData.SCData;
import SCData.controller.SCDataDao;
//import lecture.controller.LectureDao;
//import user.controller.UserDao;

public class UpdateGradeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[checkcheck]");
		SCDataDao scdataDao = SCDataDao.getInstance();
		
		String classCode = request.getParameter("classCode");
		ArrayList<SCData> scData = scdataDao.getScdataViewByClasscode(classCode);
		
		request.setAttribute("scData", scData);
		request.getRequestDispatcher("inputGrade").forward(request, response);
	}

}
