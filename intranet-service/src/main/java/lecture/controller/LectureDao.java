package lecture.controller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import board.Board;
import lecture.Lecture;
import lecture.LectureRequestDto;
import util.DBManager;

public class LectureDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private LectureDao() {
	}

	private static LectureDao instance = new LectureDao();

	public static LectureDao getInstance() {
		return instance;
	}

	// C

	// R
	public ArrayList<Lecture> getLectureAll() {
		ArrayList<Lecture> list = new ArrayList<Lecture>();

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM lecture ORDER BY user_code";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (rs.next()) {
					String classCode = this.rs.getString(1);
					int userCode = this.rs.getInt(2);
					String major = this.rs.getString(3);
					String department = this.rs.getString(4);
					String className = this.rs.getString(5);
					String classification = this.rs.getString(6);
					int credit = this.rs.getInt(7);
					String classroom = this.rs.getString(8);
					String information = this.rs.getString(9);

					Lecture lecture = new Lecture(classCode, userCode, major, department, className, classification,
							credit, classroom, information);

					list.add(lecture);

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}

		return list;
	}

	public Lecture getLectureByClassCode(String classCode) {
		Lecture lecture = null;

		this.conn = DBManager.getConnection();
		if (conn != null) {
			String sql = "SELECT * FROM lecture WHERE class_code=?";

			try {
				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setString(1, classCode);
				this.rs = pstmt.executeQuery();

				while (this.rs.next()) {
					int userCode = this.rs.getInt(2);
					String major = this.rs.getString(3);
					String department = this.rs.getString(4);
					String className = this.rs.getString(5);
					String classification = this.rs.getString(6);
					int credit = this.rs.getInt(7);
					String classroom = this.rs.getString(8);
					String information = this.rs.getString(9);

					lecture = new Lecture(classCode, userCode, major, department, className, classification, credit,
							classroom, information);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return lecture;
	}
	
	public Lecture getLectureByName(String className) {
		Lecture lecture = null;
		
		this.conn = DBManager.getConnection();
		if(conn != null) {
			String sql = "SELECT * FROM lecture WHERE class_name=?";
			
			try {
				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setString(1, className);
				this.rs = pstmt.executeQuery();
				
				while (this.rs.next()) {
					String classCode = this.rs.getString(1);
					int userCode = this.rs.getInt(2);
					String major = this.rs.getString(3);
					String department = this.rs.getString(4);
					String classification = this.rs.getString(6);
					int credit = this.rs.getInt(7);
					String classroom = this.rs.getString(8);
					String information = this.rs.getString(9);
					
					lecture = new Lecture(classCode, userCode, major, department, className, classification, credit, classroom, information);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return lecture;
	}
	

	// 교수 (1명) 이 가진 수업리스트
	public ArrayList<Lecture> getLectureByUserCode(int userCode) {
		ArrayList<Lecture> list = new ArrayList<Lecture>();

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM lecture WHERE user_code = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, userCode);
				this.rs = this.pstmt.executeQuery();

				while (rs.next()) {
					String classCode = this.rs.getString(1);
					String major = this.rs.getString(3);
					String department = this.rs.getString(4);
					String className = this.rs.getString(5);
					String classification = this.rs.getString(6);
					int credit = this.rs.getInt(7);
					String classroom = this.rs.getString(8);
					String information = this.rs.getString(9);

					Lecture lecture = new Lecture(classCode, userCode, major, department, className, classification,
							credit, classroom, information);

					list.add(lecture);

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}

		return list;
	}

	public ArrayList<Lecture> getLuctureByClassCode(String classCode) {
		ArrayList<Lecture> list = new ArrayList<Lecture>();

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM lecture WHERE class_code=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, classCode);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int userCode = this.rs.getInt(2);
					String major = this.rs.getString(3);
					String department = this.rs.getString(4);
					String className = this.rs.getString(5);
					String classification = this.rs.getString(6);
					int credit = this.rs.getInt(7);
					String classroom = this.rs.getString(8);
					String information = this.rs.getString(9);

					Lecture lecture = new Lecture(classCode, userCode, major, department, className, classification,
							credit, classroom, information);

					list.add(lecture);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		return list;
	}

	// U
	public void modifyLectureInfo(LectureRequestDto lectureDto) {
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "UPDATE lecture SET information=? WHERE class_code=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, lectureDto.getInformation());
				this.pstmt.setString(2, lectureDto.getClassCode());

				this.pstmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
	// D
	public void deletelectureByUserCode(int userCode) {
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "DELETE FROM lecture WHERE user_code=?";

			try {
				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setInt(1, userCode);
				this.rs = pstmt.executeQuery();

				this.rs.next();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
