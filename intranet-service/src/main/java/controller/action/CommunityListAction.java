package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import board.Board;
import board.controller.BoardDao;

public class CommunityListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		BoardDao boardDao = BoardDao.getInstance();
		int count = boardDao.getBoardCount();
		
		int pageSize = 10;
		int currentPage = 1;
		
		String page = request.getParameter("page");
		if(page != null)
			currentPage = Integer.parseInt(page);
		
		int startIndex = (currentPage - 1) * pageSize;
		
		ArrayList<Board> list = boardDao.getBoardList(startIndex, pageSize);
		
		int totalPages = (int) Math.ceil((double) count / pageSize);
		int prevPage = currentPage - 1;
		int nextPage = currentPage + 1;

		
		JSONObject result = new JSONObject();		   
		
		JSONObject statusObj = new JSONObject();		
		statusObj.put("totalPages", totalPages);		
		statusObj.put("currentPage", currentPage);		
		statusObj.put("prevPage", prevPage);
		statusObj.put("nextPage", nextPage);
		
		JSONArray listObj = new JSONArray(list);		
		
		result.put("status", statusObj);
		result.put("list", listObj);
		
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
	}

}
