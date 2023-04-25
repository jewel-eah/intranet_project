package department;

public class Department {
	private String depName;
	private int depCode;

	public Department(String depName, int depCode) {
		this.depName = depName;
		this.depCode = depCode;
	}

	public Department(DepartmentRequestDto departmentDto) {
		this.depName = departmentDto.getDepName();
		this.depCode = departmentDto.getDepCode();
	}

	public String getDepName() {
		return depName;
	}

	public int getDepCode() {
		return depCode;
	}
}
