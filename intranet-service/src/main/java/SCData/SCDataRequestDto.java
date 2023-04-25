package SCData;

public class SCDataRequestDto {
	private int userCode;
	private String classCode, grade;

	public SCDataRequestDto(int userCode, String classCode, String grade) {
		this.userCode = userCode;
		this.classCode = classCode;
		this.grade = grade;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
