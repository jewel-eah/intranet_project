package currentlySignUp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import currentlySignUp.CurrentlySignUp;
import util.DBManager;

public class CurrentlySignUpDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private CurrentlySignUpDao() {}
	
	private static CurrentlySignUpDao instance = new CurrentlySignUpDao();
	public static CurrentlySignUpDao getInstance() {
		return instance;
	}
	
	public ArrayList<CurrentlySignUp> getCurrentlySignUpByUser(int userCode){
		ArrayList<CurrentlySignUp> list = new ArrayList<CurrentlySignUp>();
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "SELECT * FROM signup_class WHERE user_code=?";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, userCode);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					String classCode = this.rs.getString(2);
					String classification = this.rs.getString(3);
					String className = this.rs.getString(4);
					String major = this.rs.getString(5);
					String department = this.rs.getString(6);
					String userName = this.rs.getString(7);
					String classroom = this.rs.getString(8);
					int credit = this.rs.getInt(9);
					
					CurrentlySignUp currentlySignUp = new CurrentlySignUp(userCode, classCode, classification, className, major, department, userName, classroom, credit);
					list.add(currentlySignUp);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}
	
	
	public void deleteSignUpData(int userCode, String classCode) {
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "DELETE FROM signup_class WHERE user_code=? AND class_code=?";
			
			try {
				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setInt(1, userCode);
				this.pstmt.setString(2, classCode);
				this.pstmt.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
}
