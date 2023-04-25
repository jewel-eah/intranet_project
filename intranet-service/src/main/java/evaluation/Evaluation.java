package evaluation;

public class Evaluation {
	private String classCode, grade;
	private int professorCode;

	public Evaluation(String classCode, int professorCode, String grade) {
		this.classCode = classCode;
		this.professorCode = professorCode;
		this.grade = grade;
	}

	public Evaluation(EvaluationRequestDto evaluationDto) {
		this.classCode = evaluationDto.getClassCode();
		this.professorCode = evaluationDto.getProfessorCode();
		this.grade = evaluationDto.getGrade();
	}

	public String getClassCode() {
		return classCode;
	}

	public String getGrade() {
		return grade;
	}

	public int getProfessorCode() {
		return professorCode;
	}

}
