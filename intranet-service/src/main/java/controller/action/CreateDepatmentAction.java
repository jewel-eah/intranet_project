package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import department.DepartmentRequestDto;
import department.controller.DepartmentDao;

public class CreateDepatmentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String depName = request.getParameter("depName");
		int depCode = Integer.parseInt(request.getParameter("depCode"));

		DepartmentDao depDao = DepartmentDao.getInstance();
		DepartmentRequestDto depDto = new DepartmentRequestDto(depName, depCode);

		if (depDao.getDepartmentBydepName(depName) == null) {
			depDao.createDepartemnt(depDto);
		}

		response.sendRedirect("portalsite");
	}

}
