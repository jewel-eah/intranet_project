package major;

public class MajorRequestDto {
	private String majorName;
	private int depCode, majorCode;

	public MajorRequestDto(String majorName, int depCode, int majorCode) {
		this.majorName = majorName;
		this.depCode = depCode;
		this.majorCode = majorCode;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public int getDepCode() {
		return depCode;
	}

	public void setDepCode(int depCode) {
		this.depCode = depCode;
	}

	public int getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(int majorCode) {
		this.majorCode = majorCode;
	}
}
