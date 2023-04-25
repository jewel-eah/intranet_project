package evaluation;

public class EvaluationRequestDto {
	private String classCode, grade;
	private int professorCode;

	public EvaluationRequestDto(String classCode, int professorCode, String grade) {
		this.classCode = classCode;
		this.professorCode = professorCode;
		this.grade = grade;
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

	public int getProfessorCode() {
		return professorCode;
	}

	public void setProfessorCode(int professorCode) {
		this.professorCode = professorCode;
	}

}
