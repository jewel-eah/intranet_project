package signUpClass.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import signUpClass.SignUpClass;
import signUpClass.SignUpClassRequestDto;
import util.DBManager;

public class SignUpClassDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private SignUpClassDao() {
	}

	private static SignUpClassDao instance = new SignUpClassDao();

	public static SignUpClassDao getInstance() {
		return instance;
	}
	
	
	
	public void createSignUpList(SignUpClassRequestDto signupClassDto) {
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "INSERT INTO signup_class (user_code, class_code, classification, class_name, major, department, user_name, classroom, credit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, signupClassDto.getUserCode());
				this.pstmt.setString(2, signupClassDto.getClassCode());
				this.pstmt.setString(3, signupClassDto.getClassification());
				this.pstmt.setString(4, signupClassDto.getClassName());
				this.pstmt.setString(5, signupClassDto.getMajor());
				this.pstmt.setString(6, signupClassDto.getDepartment());
				this.pstmt.setString(7, signupClassDto.getProfessorName());
				this.pstmt.setString(8, signupClassDto.getClassroom());
				this.pstmt.setInt(9, signupClassDto.getCredit());
				
				this.pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
	
	
	public ArrayList<SignUpClass> getSignUpClassAll(){
		ArrayList<SignUpClass> list = new ArrayList<SignUpClass>();
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM regist_lecture";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int userCode = this.rs.getInt(1);
					String classification = this.rs.getString(2);
					String className = this.rs.getString(3);
					String major = this.rs.getString(4);
					String department = this.rs.getString(5);
					String professorName = this.rs.getString(6);
					String classroom = this.rs.getString(7);
					int credit = this.rs.getInt(8);

					SignUpClass signupClass = new SignUpClass(userCode, classification, className, major, department,
							professorName, classroom, credit);
					list.add(signupClass);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}

		return list;
	}

	// D
	public void deleteSignUpClassByUserCode(int userCode) {
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "DELETE FROM signup_class WHERE user_code=?";

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
