package major;

public class Major {
	private String majorName;
	private int depCode, majorCode;

	public Major(String majorName, int depCode, int majorCode) {
		this.majorName = majorName;
		this.depCode = depCode;
		this.majorCode = majorCode;
	}

	public Major(MajorRequestDto majorDto) {
		this.majorName = majorDto.getMajorName();
		this.depCode = majorDto.getDepCode();
		this.majorCode = majorDto.getMajorCode();
	}

	public String getMajorName() {
		return majorName;
	}

	public int getDepCode() {
		return depCode;
	}

	public int getMajorCode() {
		return majorCode;
	}

}
