package user.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBManager;
import user.User;
import user.UserRequestDto;

public class UserDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private UserDao() {
	}

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	// C
	public void createUser(UserRequestDto userDto) {
		User user = new User(userDto);
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				this.pstmt = this.conn.prepareStatement(sql);

				this.pstmt.setInt(1, user.getUserCode());
				this.pstmt.setString(2, user.getUserPassword());
				this.pstmt.setString(3, user.getUserType());
				this.pstmt.setString(4, user.getUserName());
				this.pstmt.setString(5, user.getGender());
				this.pstmt.setString(6, user.getPhone());
				this.pstmt.setString(7, user.getAddress());
				this.pstmt.setString(8, user.getAddressCode());
				this.pstmt.setString(9, user.getBirthDate());
				this.pstmt.setString(10, user.getAccountNum());
				this.pstmt.setString(11, user.getBankName());
				this.pstmt.setString(12, user.getAccountName());
				this.pstmt.setString(13, user.getEmail());
				this.pstmt.setString(14, user.getAdmDate());
				this.pstmt.setString(15, user.getAdmType());
				this.pstmt.setString(16, user.getDepName());
				this.pstmt.setString(17, user.getMainMajor());
				this.pstmt.setString(18, user.getSubMajor());
				this.pstmt.setString(19, user.getGraduate());
				this.pstmt.setString(20, user.getDegree());
				this.pstmt.setString(21, user.getSemester());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// R
	public ArrayList<User> getUserAll() {
		ArrayList<User> list = new ArrayList<User>();

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM user";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int userCode = this.rs.getInt(1);
					String userPassword = this.rs.getString(2);
					String userType = this.rs.getString(3);
					String userName = this.rs.getString(4);
					String gender = this.rs.getString(5);
					String phone = this.rs.getString(6);
					String address = this.rs.getString(7);
					String addressCode = this.rs.getString(8);
					String birthDate = this.rs.getString(9);
					String accountNum = this.rs.getString(10);
					String bankName = this.rs.getString(11);
					String accountName = this.rs.getString(12);
					String email = this.rs.getString(13);
					String admDate = this.rs.getString(14);
					String admType = this.rs.getString(15);
					String depName = this.rs.getString(16);
					String mainMajor = this.rs.getString(17);
					String subMajor = this.rs.getString(18);
					String graduate = this.rs.getString(19);
					String degree = this.rs.getString(20);
					String semester = this.rs.getString(21);

					User user = new User(userCode, userPassword, userType, userName, gender, phone, address,
							addressCode, birthDate, accountNum, bankName, accountName, email, admDate, admType, depName,
							mainMajor, subMajor, graduate, degree, semester);
					list.add(user);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return list;
	}

	public User getUserByUserCode(int userCode) {
		User user = null;
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM user WHERE user_code=?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, userCode);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String userPassword = this.rs.getString(2);
					String userType = this.rs.getString(3);
					String userName = this.rs.getString(4);
					String gender = this.rs.getString(5);
					String phone = this.rs.getString(6);
					String address = this.rs.getString(7);
					String addressCode = this.rs.getString(8);
					String birthDate = this.rs.getString(9);
					String accountNum = this.rs.getString(10);
					String bankName = this.rs.getString(11);
					String accountName = this.rs.getString(12);
					String email = this.rs.getString(13);
					String admDate = this.rs.getString(14);
					String admType = this.rs.getString(15);
					String depName = this.rs.getString(16);
					String mainMajor = this.rs.getString(17);
					String subMajor = this.rs.getString(18);
					String graduate = this.rs.getString(19);
					String degree = this.rs.getString(20);
					String semester = this.rs.getString(21);

					user = new User(userCode, userPassword, userType, userName, gender, phone, address, addressCode,
							birthDate, accountNum, bankName, accountName, email, admDate, admType, depName, mainMajor,
							subMajor, graduate, degree, semester);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("연동 실패");
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return user;
	}

	public String getNamebyUserCode(int usercode) {
		String name = "";

		this.conn = DBManager.getConnection();
		if (conn != null) {
			String sql = "SELECT user_name from user WHERE user_code=?";

			try {
				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setInt(1, usercode);
				this.rs = pstmt.executeQuery();

				this.rs.next();
				name = this.rs.getString(1);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return name;
	}

	// U
	public void updateStudentPart(UserRequestDto userDto) {
		User user = getUserByUserCode(userDto.getUserCode());
		this.conn = DBManager.getConnection();

		if (userDto != null && this.conn != null) {

			user = new User(userDto);

			String sql = "UPDATE user SET user_password=?, user_name=?,  gender=?, phone=?, address=?, address_code=?, birth_date=?, account=?, bank_office=?, bank_name=?, email=? WHERE user_code=?;";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, user.getUserPassword());
				this.pstmt.setString(2, user.getUserName());
				this.pstmt.setString(3, user.getGender());
				this.pstmt.setString(4, user.getPhone());
				this.pstmt.setString(5, user.getAddress());
				this.pstmt.setString(6, user.getAddressCode());
				this.pstmt.setString(7, user.getBirthDate());
				this.pstmt.setString(8, user.getAccountNum());
				this.pstmt.setString(9, user.getBankName());
				this.pstmt.setString(10, user.getAccountName());
				this.pstmt.setString(11, user.getEmail());
				this.pstmt.setInt(12, user.getUserCode());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	public void updateMasterUser(UserRequestDto userDto) {
		User user = getUserByUserCode(userDto.getUserCode());
		this.conn = DBManager.getConnection();

		if (userDto != null && this.conn != null) {

			user = new User(userDto);

			String sql = "UPDATE user SET user_password=?, user_type=?, user_name=?, gender=?, phone=?, address=?, address_code=?, birth_date=?, account=?, bank_office=?, bank_name=?, email=?, admission_date=?, admission_type=?, dep_name=?, main_major=?, sub_major=?, graduate=?, degree=?, semester=?  WHERE user_code=?;";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, user.getUserPassword());
				this.pstmt.setString(2, user.getUserType());
				this.pstmt.setString(3, user.getUserName());
				this.pstmt.setString(4, user.getGender());
				this.pstmt.setString(5, user.getPhone());
				this.pstmt.setString(6, user.getAddress());
				this.pstmt.setString(7, user.getAddressCode());
				this.pstmt.setString(8, user.getBirthDate());
				this.pstmt.setString(9, user.getAccountNum());
				this.pstmt.setString(10, user.getBankName());
				this.pstmt.setString(11, user.getAccountName());
				this.pstmt.setString(12, user.getEmail());
				this.pstmt.setString(13, user.getAdmDate());
				this.pstmt.setString(14, user.getAdmType());
				this.pstmt.setString(15, user.getDepName());
				this.pstmt.setString(16, user.getMainMajor());
				this.pstmt.setString(17, user.getSubMajor());
				this.pstmt.setString(18, user.getGraduate());
				this.pstmt.setString(19, user.getDegree());
				this.pstmt.setString(20, user.getSemester());
				this.pstmt.setInt(21, user.getUserCode());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// D
	public void deleteUserByUserCode(int userCode) {
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "DELETE FROM user WHERE user_code=?";

			try {
				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setInt(1, userCode);
				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
}
