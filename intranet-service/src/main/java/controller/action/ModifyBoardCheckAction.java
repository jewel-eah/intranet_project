package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.controller.BoardDao;

public class ModifyBoardCheckAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int writeCode = Integer.parseInt(request.getParameter("writeCode"));
		BoardDao boardDao = BoardDao.getInstance();
		Board board = boardDao.getBoardByWriteCode(writeCode);
		
		
		request.setAttribute("board", board);
		request.getRequestDispatcher("modifyBoard").forward(request, response);
		
	}

}
