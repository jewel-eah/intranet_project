package lecture;

public class Lecture {

	private String classCode,major, department, className, classification, classroom, information;
	private int userCode, credit;

	public Lecture(String classCode, int userCode, String major, String department, String className, String classification
			, int credit, String classroom, String information) {
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

	public Lecture(LectureRequestDto lectureDto) {
		this.classCode = lectureDto.getClassCode();
		this.userCode = lectureDto.getUserCode();
		this.major = lectureDto.getMajor();
		this.department = lectureDto.getDepartment();
		this.className = lectureDto.getClassName();
		this.classification = lectureDto.getClassification();
		this.credit = lectureDto.getCredit();
		this.classroom = lectureDto.getClassroom();
		this.information = lectureDto.getInformation();
	}

	public String getClassCode() {
		return classCode;
	}
	
	public int getUserCode() {
		return userCode;
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

	public String getClassroom() {
		return classroom;
	}

	public String getInformation() {
		return information;
	}

	public int getCredit() {
		return credit;
	}

}
