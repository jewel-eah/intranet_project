package major.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import major.Major;
import major.MajorRequestDto;
import util.DBManager;

public class MajorDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private MajorDao() {
	}

	private static MajorDao instance = new MajorDao();

	public static MajorDao getInstance() {
		return instance;
	}

	public int getMajorCode() {
		int rNum = 0;
		Random random = new Random();

		while (true) {
			rNum = random.nextInt(8999) + 1000;
			if (getMajorByMajorCode(rNum) == null) {
				break;
			}
		}

		return rNum;
	}

	// C
	public void createMajor(MajorRequestDto majorDto) {
		Major major = new Major(majorDto);
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "INSERT INTO major VALUES(?, ?, ?)";
			try {
				this.pstmt = this.conn.prepareStatement(sql);

				this.pstmt.setString(1, major.getMajorName());
				this.pstmt.setInt(2, major.getDepCode());
				this.pstmt.setInt(3, major.getMajorCode());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// R
	public ArrayList<Major> getMajorAll() {
		ArrayList<Major> list = new ArrayList<Major>();

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM major";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String majorName = this.rs.getString(1);
					int depCode = this.rs.getInt(2);
					int majorCode = this.rs.getInt(3);

					Major major = new Major(majorName, depCode, majorCode);
					list.add(major);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return list;
	}

	public ArrayList<Major> getMajorByDepartment(int departmentCode) {
		ArrayList<Major> list = new ArrayList<Major>();

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM major WHERE dep_code=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, departmentCode);

				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String majorName = this.rs.getString(1);
					int majorCode = this.rs.getInt(3);

					Major major = new Major(majorName, departmentCode, majorCode);
					list.add(major);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return list;
	}

	public Major getMajorByMajorName(String majorName) {
		Major major = null;

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM mejor WHERE major_name=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, majorName);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int depCode = this.rs.getInt(2);
					int majorCode = this.rs.getInt(3);

					major = new Major(majorName, depCode, majorCode);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return major;
	}

	public Major getMajorByMajorCode(int majorCode) {
		Major major = null;

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM mejor WHERE major_code=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, majorCode);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String majorName = this.rs.getString(1);
					int depCode = this.rs.getInt(2);

					major = new Major(majorName, depCode, majorCode);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return major;
	}
}
