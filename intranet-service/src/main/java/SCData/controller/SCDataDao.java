package SCData.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import SCData.SCData;
import SCData.SCDataRequestDto;
import util.DBManager;

public class SCDataDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private SCDataDao() {
	}

	private static SCDataDao instance = new SCDataDao();

	public static SCDataDao getInstance() {
		return instance;
	}

	// c

	// r

	// 모든 리스트
	public ArrayList<SCData> getScdataAll() {
		ArrayList<SCData> scList = new ArrayList<SCData>();

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM sc_data ORDER BY class_code";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int userCode = this.rs.getInt(1);
					String classCode = this.rs.getString(2);
					String grade = this.rs.getString(3);

					SCData scData = new SCData(userCode, classCode, grade);
					scList.add(scData);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return scList;
	}

	// scData for student viewTable
	public ArrayList<SCData> getScdataViewByClasscode(String classCode) {
		ArrayList<SCData> view = new ArrayList<>();

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * from scdata_view WHERE class_code=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, classCode);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int userCode = this.rs.getInt(1);
					String userName = this.rs.getString(2);
					String major = this.rs.getString(3);
					String department = this.rs.getString(5);
					String className = this.rs.getString(6);
					String classification = this.rs.getString(7);
					String grade = this.rs.getString(8);
					SCData scData = new SCData(userCode, userName, major, classCode, department, className,
							classification, grade);
					view.add(scData);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}

		return view;
	}

	// scData viewTable by userCode
	public ArrayList<SCData> getScdataViewByUsercode(int userCode) {
		ArrayList<SCData> view = new ArrayList<>();

		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * from scdata_view WHERE user_code=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, userCode);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String userName = this.rs.getString(2);
					String classCode = this.rs.getString(3);
					String major = this.rs.getString(4);
					String department = this.rs.getString(5);
					String className = this.rs.getString(6);
					String classification = this.rs.getString(7);
					String grade = this.rs.getString(8);
					SCData scData = new SCData(userCode, userName, classCode, major, department, className,
							classification, grade);
					view.add(scData);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}

		return view;
	}

	public ArrayList<SCData> getSCDataByClassCode(String classCode) {
		ArrayList<SCData> list = new ArrayList<SCData>();

		this.conn = DBManager.getConnection();
		if (conn != null) {
			String sql = "SELECT * FROM sc_data WHERE class_code=?";

			try {
				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setString(1, classCode);
				this.rs = pstmt.executeQuery();

				while (this.rs.next()) {
					int userCode = this.rs.getInt(1);
					String grade = this.rs.getString(3);

					SCData scData = new SCData(userCode, classCode, grade);
					list.add(scData);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	// u
	public void updateGrade(SCDataRequestDto scdataDto) {
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "UPDATE sc_data SET grade=? WHERE user_code=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, scdataDto.getGrade());
				System.out.println("scdata grade: " + scdataDto.getGrade());
				this.pstmt.setInt(2, scdataDto.getUserCode());
				System.out.println("scdata userCode: " + scdataDto.getUserCode());

				this.pstmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	public SCData getScdataByUsercodeAndClassCode(int userCode, String classCode) {
		SCData scData = null;
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * from scdata_view WHERE user_code=? AND class_code=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, userCode);
				this.pstmt.setString(2, classCode);
				
				this.rs = this.pstmt.executeQuery();

				if (this.rs.next()) {
					String userName = this.rs.getString(2);
					String major = this.rs.getString(4);
					String department = this.rs.getString(5);
					String className = this.rs.getString(6);
					String classification = this.rs.getString(7);
					String grade = this.rs.getString(8);
					
					scData = new SCData(userCode, userName, classCode, major, department, className,
							classification, grade);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}

		return scData;
	}
	
	public void deleteSCDataByUserCode(int userCode) {
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "DELETE FROM sc_data WHERE user_code=?";

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
