package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardRequestDto;
import board.controller.BoardDao;
import user.User;

public class WriteBoardAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("log");
		String title = "";

		if(user.getUserCode()==9999) {
			title += "[ ＊ 공지사항 ＊ ] ";
		}
		
		title += request.getParameter("title");
		String content = request.getParameter("content");
		String recontent = "";
		recontent = content.replace("\n", "<br>");
		recontent = content.replace("\r\n", "<br>");
		BoardDao boardDao = BoardDao.getInstance();
		BoardRequestDto boardDto = new BoardRequestDto(boardDao.getWriteCode(),user.getUserCode(),"일반",title,recontent,null,null);
		
		boardDao.createBoard(boardDto);
		
		response.sendRedirect("community");
	}

}
