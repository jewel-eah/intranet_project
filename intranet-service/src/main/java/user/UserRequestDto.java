package user;

public class UserRequestDto {
	private int userCode;
	private String userPassword, userType, userName, gender, phone, address;
	private String addressCode, birthDate, accountNum, bankName, accountName, email;
	private String admDate, admType, depName, mainMajor, subMajor, graduate, degree, semester;

	public UserRequestDto(int userCode, String userPassword, String userType, String userName, String gender,
			String phone, String address, String addressCode, String birthDate, String accountNum, String bankName,
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

	public UserRequestDto(int userCode, String password, String userName, String gender, String phone, String address,
			String addressCode, String birthDate, String accountNum, String bankName, String accountName,
			String email) {

		this.userCode = userCode;
		this.userPassword = password;
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

	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdmDate() {
		return admDate;
	}

	public void setAdmDate(String admDate) {
		this.admDate = admDate;
	}

	public String getAdmType() {
		return admType;
	}

	public void setAdmType(String admType) {
		this.admType = admType;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getMainMajor() {
		return mainMajor;
	}

	public void setMainMajor(String mainMajor) {
		this.mainMajor = mainMajor;
	}

	public String getSubMajor() {
		return subMajor;
	}

	public void setSubMajor(String subMajor) {
		this.subMajor = subMajor;
	}

	public String getGraduate() {
		return graduate;
	}

	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

}
