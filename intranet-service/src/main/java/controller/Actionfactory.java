package controller;

import controller.action.Action;
import controller.action.CommunityListAction;
import controller.action.CreateDepatmentAction;
import controller.action.CreateMajorAction;
import controller.action.CreateUserAction;
import controller.action.CurrentlySignUpChecksAction;
import controller.action.DeleteBoardAction;
import controller.action.DeleteClassAction;
import controller.action.DeleteUserAction;
import controller.action.GetMajorCode;
import controller.action.InputGradeAction;
import controller.action.LectureInfoAction;
import controller.action.JstlUserUpdateAction;
import controller.action.ListOfMajorsAction;
import controller.action.LoginAction;
import controller.action.ModifyBoardAction;
import controller.action.ModifyBoardCheckAction;
import controller.action.ModifyLectureInfoAction;
import controller.action.PasswordCheckAction;
import controller.action.ProfessorInfoUpdateAction;
import controller.action.ProfessorLectureListAction;
import controller.action.ReadBoardAction;
import controller.action.SelectDepartmentAction;
import controller.action.ShowLectureInfoAction;
import controller.action.SignupClassAction;
import controller.action.StudentUpdateAction;
import controller.action.UpdateGradeAction;
import controller.action.ViewGradeAction;
import controller.action.UserCreateAction;
import controller.action.WriteBoardAction;
import controller.action.masterUserUpdateAction;
import controller.action.modifyLectureInfoCheckAction;
import controller.action.professorUpdateCheckAction;
import controller.action.signupCheckClassAction;
import controller.action.LogoutAction;

public class Actionfactory {
	private Actionfactory() {
	}

	private static Actionfactory instance = new Actionfactory();

	public static Actionfactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		if (command != null) {
			if (command.equals("login"))
				action = new LoginAction();
			else if (command.equals("writeBoard"))
				action = new WriteBoardAction();
			else if (command.equals("modifyBoard"))
				action = new ModifyBoardAction();
			else if (command.equals("studentUpdate"))
				action = new StudentUpdateAction();
			else if (command.equals("logout"))
				action = new LogoutAction();
			else if (command.equals("deleteBoard"))
				action = new DeleteBoardAction();
			else if (command.equals("passwordCheck"))
				action = new PasswordCheckAction();
			else if (command.equals("professorInfoUpdate"))
				action = new ProfessorInfoUpdateAction();
			else if (command.equals("professorLectureList"))
				action = new ProfessorLectureListAction();
			else if (command.equals("masterUserUpdate"))
				action = new masterUserUpdateAction();
			else if (command.equals("modifyLectureInfo"))
				action = new ModifyLectureInfoAction();
			else if (command.equals("inputGrade"))
				action = new InputGradeAction();
			else if (command.equals("showLectureInfo"))
				action = new ShowLectureInfoAction();
			else if (command.equals("masterUserCreate"))
				action = new CreateUserAction();
			else if (command.equals("masterUserDelete"))
				action = new DeleteUserAction();
			else if (command.equals("listOfMajors"))
				action = new ListOfMajorsAction();
			else if (command.equals("createDepartment"))
				action = new CreateDepatmentAction();
			else if (command.equals("createMajor"))
				action = new CreateMajorAction();
			else if (command.equals("signupClass"))
				action = new SignupClassAction();
			else if (command.equals("CommunityListWithPage"))
				action = new CommunityListAction();
			else if (command.equals("deleteClass"))
				action = new DeleteClassAction();
			else if (command.equals("readBoard"))
				action = new ReadBoardAction();
			else if (command.equals("modifyBoardCheck"))
				action = new ModifyBoardCheckAction();
			else if (command.equals("viewGrade"))
				action = new ViewGradeAction();
			else if (command.equals("lectureInfo"))
				action = new LectureInfoAction();
			else if (command.equals("userCreate"))
				action = new UserCreateAction();
			else if (command.equals("userUpdate"))
				action = new JstlUserUpdateAction();
			else if (command.equals("signUpCheckClass"))
				action = new signupCheckClassAction();
			else if (command.equals("currentlySignUpCheck"))
				action = new CurrentlySignUpChecksAction();
			else if (command.equals("updateGrade"))
				action = new UpdateGradeAction();
			else if (command.equals("selectDepartment"))
				action = new SelectDepartmentAction();
			else if (command.equals("getMajorCode"))
				action = new GetMajorCode();
			else if (command.equals("modifyLectureInfoCheck"))
				action = new modifyLectureInfoCheckAction();
			else if (command.equals("professorUpdateoCheck"))
				action = new professorUpdateCheckAction();
		}
		return action;
	}
}
