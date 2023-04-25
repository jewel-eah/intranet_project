package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SCData.controller.SCDataDao;
import board.controller.BoardDao;
import department.controller.DepartmentDao;
import evaluation.controller.EvaluationDao;
import lecture.controller.LectureDao;
import major.controller.MajorDao;
import signUpClass.controller.SignUpClassDao;
import user.controller.UserDao;

public class DeleteUserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		UserDao userDao = UserDao.getInstance();
		BoardDao boardDao = BoardDao.getInstance();
		LectureDao lectureDao = LectureDao.getInstance();
		SCDataDao scdataDao = SCDataDao.getInstance();
		EvaluationDao evaluationDao = EvaluationDao.getInstance();
		SignUpClassDao signUpClassDao = SignUpClassDao.getInstance();

		int userCode = Integer.parseInt(request.getParameter("userCode"));

		scdataDao.deleteSCDataByUserCode(userCode);
		evaluationDao.deleteEvaluationByUserCode(userCode);
		boardDao.deleteBoardByUserCode(userCode);
		signUpClassDao.deleteSignUpClassByUserCode(userCode);
		lectureDao.deletelectureByUserCode(userCode);
		userDao.deleteUserByUserCode(userCode);
		
		response.sendRedirect("portalsite");
	}

}
