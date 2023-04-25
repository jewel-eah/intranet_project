package lecture;

public class LectureRequestDto {
	private String classCode, major, department, className, classification, classroom, information;
	private int userCode, credit;

	public LectureRequestDto(String classCode, int userCode, String major, String department, String className, String classification,
			 int credit, String classroom, String information) {
		this.classCode = classCode;
		this.userCode = userCode;
		this.major = major;
		this.department = department;
		this.className = className;
		this.classification = classification;
		this.credit = credit;
		this.classroom = classroom;
		this.information = information;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public int getUserCode() {
		return userCode;
	}
	
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}


	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
}
