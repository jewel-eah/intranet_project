package currentlySignUp;

public class CurrentlySignUp {
	int userCode;
	String classCode;
	String classification;
	String className;
	String major;
	String department;
	String userName;
	String classroom;
	int credit;
	
	public CurrentlySignUp(int userCode, String classCode, String classification, String className, String major, String department, String userName, String classroom, int credit) {
		this.userCode = userCode;
		this.classCode = classCode;
		this.classification = classification;
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
}
