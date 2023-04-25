package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import major.Major;
import major.controller.MajorDao;

import org.json.JSONArray;

public class ListOfMajorsAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		int depCode = Integer.parseInt(request.getParameter("depCode"));

		MajorDao majorDao = MajorDao.getInstance();
		ArrayList<Major> list = majorDao.getMajorByDepartment(depCode);

		// JSON
		JSONArray result = new JSONArray(list);

		response.getWriter().print(result);
		response.getWriter().flush();

	}

}
