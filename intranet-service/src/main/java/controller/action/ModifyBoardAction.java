package controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.Board;
import board.BoardRequestDto;
import board.controller.BoardDao;
import user.User;

public class ModifyBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int writeCode = Integer.parseInt(request.getParameter("writeCode"));
		
		Timestamp modDate = new Timestamp(System.currentTimeMillis());
		
		BoardDao boardDao = BoardDao.getInstance();
		Board board = boardDao.getBoardByWriteCode(writeCode);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("log");
		
		String recontent = "";
		recontent = content.replace("\n", "<br>");
		recontent = content.replace("\r\n", "<br>");
		
		BoardRequestDto boardDto = new BoardRequestDto(writeCode, user.getUserCode(), board.getCategory(), title, recontent, board.getRegDate(), modDate);
		
		boardDao.modifyBoard(boardDto);
		
		response.sendRedirect("community");
	}
}
