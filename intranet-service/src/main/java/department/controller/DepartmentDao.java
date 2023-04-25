package department.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import department.Department;
import department.DepartmentRequestDto;
import util.DBManager;

public class DepartmentDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private DepartmentDao() {
	}

	private static DepartmentDao instance = new DepartmentDao();

	public static DepartmentDao getInstance() {
		return instance;
	}

	// C
	public void createDepartemnt(DepartmentRequestDto depDto) {
		Department department = new Department(depDto);
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "INSERT INTO department VALUES(?, ?)";
			try {
				this.pstmt = this.conn.prepareStatement(sql);

				this.pstmt.setString(1, department.getDepName());
				this.pstmt.setInt(2, department.getDepCode());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// R
	public ArrayList<Department> getDepartmentAll() {
		ArrayList<Department> list = new ArrayList<Department>();

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM department";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String depName = this.rs.getString(1);
					int depCode = this.rs.getInt(2);

					Department Department = new Department(depName, depCode);
					list.add(Department);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return list;
	}

	public Department getDepartmentBydepName(String deparmentName) {
		Department department = null;

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM department WHERE dep_name=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, deparmentName);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int depCode = this.rs.getInt(2);

					department = new Department(deparmentName, depCode);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return department;
	}
	
	public Department getDepartmentBydepCode(int deparmentCode) {
		Department department = null;

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT * FROM department WHERE dep_code=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, deparmentCode);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String depName = this.rs.getString(1);

					department = new Department(depName, deparmentCode);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return department;
	}
}
