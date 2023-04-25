package currentlySignUp;

public class CurrentlySignUpRequestDto {
	int userCode;
	String classification;
	String classCode;
	String className;
	String major;
	String department;
	String userName;
	String classroom;
	int credit;
	
	public CurrentlySignUpRequestDto(int userCode, String classification, String classCode, String className, String major, String department, String userName, String classroom, int credit) {
		this.userCode = userCode;
		this.classification = classification;
		this.classCode = classCode;
		this.className = className;
		this.major = major;
		this.department = department;
		this.userName = userName;
		this.classroom = classroom;
		this.credit = credit;
	}
	
	public int getUserCode() {
		return userCode;
	}
	
	public String getClassification() {
		return classification;
	}
	
	public String getClassCode() {
		return classCode;
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
	
	public String getUserName() {
		return userName;
	}
	
	public String getClassroom() {
		return classroom;
	}
	
	public int getCredit() {
		return credit;
	}
	
	
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	public void setClassCode(String classCode) {
		this.classCode = classCode;
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
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
}
