package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import major.MajorRequestDto;
import major.controller.MajorDao;

public class CreateMajorAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String majorName = request.getParameter("majorName");
		int depCode = Integer.parseInt(request.getParameter("department"));
		int majorCode = Integer.parseInt(request.getParameter("majorCode"));

		MajorDao majorDao = MajorDao.getInstance();
		MajorRequestDto majorDto = new MajorRequestDto(majorName, depCode, majorCode);

		if (majorDao.getMajorByMajorName(majorName) == null) {
			majorDao.createMajor(majorDto);
		}

		response.sendRedirect("portalsite");
	}

}
