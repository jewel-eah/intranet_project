package SCData;

public class SCData {
	private int userCode;
	private String classCode, grade;
	private String userName, major, department, className, classification;

	public SCData(int userCode, String classCode, String grade) {
		this.userCode = userCode;
		this.classCode = classCode;
		this.grade = grade;
	}

	public SCData(SCDataRequestDto scDataDto) {
		this.userCode = scDataDto.getUserCode();
		this.classCode = scDataDto.getClassCode();
		this.grade = scDataDto.getGrade();
	}

	public int getUserCode() {
		return userCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public String getGrade() {
		return grade;
	}

					
	public SCData (int userCode, String userName, String major, String classCode, String department, String className, String classification, String grade) {
		this.userCode= userCode;
		this.userName = userName;
		this.classCode = classCode;
		this.major = major;
		this.department = department;
		this.className = className;
		this.classification = classification;
		this.grade = grade;
		
	}

	public String getUserName() {
		return userName;
	}
	
	public String getMajor() {
		return major;
	}

	public String getDepartment() {
		return department;
	}

	public String getClassName() {
		return className;
	}

	public String getClassification() {
		return classification;
	}
	
}
