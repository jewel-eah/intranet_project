package signUpClass;

public class SignUpClass {
	private int userCode;
	private String classification;
	private String className;
	private String major;
	private String department;
	private String professorName;
	private String classroom;
	private String classCode;
	private int credit;
	
	public SignUpClass(int userCode, String classification, String className, String major, String department, String professorName, String classroom, int credit) {
		this.userCode = userCode;
		this.classification = classification;
		this.className = className;
		this.major = major;
		this.department = department;
		this.professorName = professorName;
		this.classroom = classroom;
		this.credit = credit;
	}
	
	public SignUpClass(int userCode, String classification, String className, String major, String department, String professorName, String classroom, String classCode, int credit) {
		this.userCode = userCode;
		this.classification = classification;
		this.className = className;
		this.major = major;
		this.department = department;
		this.professorName = professorName;
		this.classroom = classroom;
		this.classCode = classCode;
		this.credit = credit;
	}
	public int getUserCode() {
		return userCode;
	}
	
	public String getClassification() {
		return classification;
	}
	
	public String getClassName() {
		return className;
	}
	
	public String getMajor() {
		return major;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String getProfessorName() {
		return professorName;
	}
	
	public String getClassroom() {
		return classroom;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public String getClassCode() {
		return classCode;
	}
}
