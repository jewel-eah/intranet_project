package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SCData.SCData;
import SCData.controller.SCDataDao;
import user.User;

public class ViewGradeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("log");
		SCDataDao scdataDao = SCDataDao.getInstance();
		ArrayList<SCData> scData = scdataDao.getScdataViewByUsercode(user.getUserCode());
		
		request.setAttribute("scData", scData);

		request.getRequestDispatcher("viewGrade").forward(request, response);
	}

}
