package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;

public class professorUpdateCheckAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("log");
		Object updateSuccess = request.getAttribute("updateSuccess");
		if (updateSuccess != null && (boolean) updateSuccess) {
			String script = "alertUpdateSuccess();";
			request.setAttribute("script", script);
		}
		
		request.getRequestDispatcher("modifyLectureInfo").forward(request, response);
	}
}
