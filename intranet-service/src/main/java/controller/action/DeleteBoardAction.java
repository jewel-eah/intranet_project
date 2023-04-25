package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.controller.BoardDao;
import user.User;

public class DeleteBoardAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("log");
		
		int writeCode = Integer.parseInt(request.getParameter("writecode"));
		int userCode = user.getUserCode();
		
		BoardDao boardDao = BoardDao.getInstance();
		boardDao.deleteBoard(writeCode, userCode);
		
		response.sendRedirect("community");
	}

}
