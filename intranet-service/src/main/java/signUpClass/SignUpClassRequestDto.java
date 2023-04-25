package signUpClass;

public class SignUpClassRequestDto {
	private int userCode;
	private String classification;
	private String className;
	private String major;
	private String department;
	private String professorName;
	private String classroom;
	private String classCode;
	private int credit;
	
	public SignUpClassRequestDto(int userCode, String classification, String className, String major, String department, String professorName, String classroom, int credit) {
		this.userCode = userCode;
		this.classification = classification;
		this.className = className;
		this.major = major;
		this.department = department;
		this.professorName = professorName;
		this.classroom = classroom;
		this.credit = credit;
	}
	
	public SignUpClassRequestDto(int userCode, String classCode, String classification, String className, String major, String department, String professorName, String classroom, int credit) {
		this.userCode = userCode;
		this.classCode = classCode;
		this.classification = classification;
		this.className = className;
		this.major = major;
		this.department = department;
		this.professorName = professorName;
		this.classroom = classroom;
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
	
	
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
}
