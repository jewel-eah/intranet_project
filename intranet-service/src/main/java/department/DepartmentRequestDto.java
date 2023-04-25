package department;

public class DepartmentRequestDto {
	private String depName;
	private int depCode;

	public DepartmentRequestDto(String depName, int depCode) {
		this.depName = depName;
		this.depCode = depCode;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public int getDepCode() {
		return depCode;
	}

	public void setDepCode(int depCode) {
		this.depCode = depCode;
	}

}
