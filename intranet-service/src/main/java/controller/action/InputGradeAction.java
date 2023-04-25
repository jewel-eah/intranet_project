package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SCData.SCData;
import SCData.SCDataRequestDto;
import SCData.controller.SCDataDao;
import user.User;
import user.controller.UserDao;

public class InputGradeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userCode = Integer.parseInt(request.getParameter("userCode"));
		String classCode = request.getParameter("classCode");
		String grade = request.getParameter("grade");
		System.out.println("[Action] usercode: "+userCode);
		System.out.println("[Action] grade: "+grade);
		
		SCDataDao scdataDao = SCDataDao.getInstance();
		
		SCDataRequestDto scdataDto = new SCDataRequestDto (userCode, classCode, grade);
		scdataDao.updateGrade(scdataDto);
		
		SCData result = scdataDao.getScdataByUsercodeAndClassCode(userCode, classCode);
		if(result != null) {
			Double score = Double.parseDouble(result.getGrade());
			
			String gradeStr = "";
			
			if(score >= 4.0)
				gradeStr += "A";
			else if(score >= 3.0)
				gradeStr += "B";
			else if(score >= 2.0)
				gradeStr += "C";
			else if(score >= 1.0)
				gradeStr += "D";
			else if(score >= 0.0)
				gradeStr += "F";
			else 
				gradeStr += "미등록";
			
			
			if(score % 1 > 0 && score >= 2.0)
				gradeStr += "+";
			
			System.out.println("gradeStr : " + gradeStr);
			response.getWriter().append(gradeStr);
		} else {
			response.getWriter().append("null");
		}
		
	}

}
