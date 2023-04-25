package user;

public class User {
	private int userCode;
	private String userPassword, userType, userName, gender, phone, address;
	private String addressCode, birthDate, accountNum, bankName, accountName, email;
	private String admDate, admType, depName, mainMajor, subMajor, graduate, degree, semester;

	public User(int userCode, String userPassword, String userType, String userName, String gender, String phone,
			String address, String addressCode, String birthDate, String accountNum, String bankName,
			String accountName, String email, String admDate, String admType, String depName, String mainMajor,
			String subMajor, String graduate, String degree, String semester) {

		this.userCode = userCode;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userName = userName;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.addressCode = addressCode;
		this.birthDate = birthDate;
		this.accountNum = accountNum;
		this.bankName = bankName;
		this.accountName = accountName;
		this.email = email;
		this.admDate = admDate;
		this.admType = admType;
		this.depName = depName;
		this.mainMajor = mainMajor;
		this.subMajor = subMajor;
		this.graduate = graduate;
		this.degree = degree;
		this.semester = semester;

	}
	
	public User(UserRequestDto userDto) {
		this.userCode = userDto.getUserCode();
		this.userPassword = userDto.getUserPassword();
		this.userType = userDto.getUserType();
		this.userName = userDto.getUserName();
		this.gender = userDto.getGender();
		this.phone = userDto.getPhone();
		this.address = userDto.getAddress();
		this.addressCode = userDto.getAddressCode();
		this.birthDate = userDto.getBirthDate();
		this.accountNum = userDto.getAccountNum();
		this.bankName = userDto.getBankName();
		this.accountName = userDto.getAccountName();
		this.email = userDto.getEmail();
		this.admDate = userDto.getAdmDate();
		this.admType = userDto.getAdmType();
		this.depName = userDto.getDepName();
		this.mainMajor = userDto.getMainMajor();
		this.subMajor = userDto.getSubMajor();
		this.graduate = userDto.getGraduate();
		this.degree = userDto.getDegree();
		this.semester = userDto.getSemester();

	}
	
	public int getUserCode() {
		return userCode;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserType() {
		return userType;
	}

	public String getUserName() {
		return userName;
	}

	public String getGender() {
		return gender;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getAddressCode() {
		return addressCode;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public String getBankName() {
		return bankName;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getEmail() {
		return email;
	}

	public String getAdmDate() {
		return admDate;
	}

	public String getAdmType() {
		return admType;
	}

	public String getDepName() {
		return depName;
	}

	public String getMainMajor() {
		return mainMajor;
	}

	public String getSubMajor() {
		return subMajor;
	}

	public String getGraduate() {
		return graduate;
	}

	public String getDegree() {
		return degree;
	}

	public String getSemester() {
		return semester;
	}

}
