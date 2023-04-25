package evaluation.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBManager;

public class EvaluationDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private EvaluationDao() {
	}

	private static EvaluationDao instance = new EvaluationDao();

	public static EvaluationDao getInstance() {
		return instance;
	}

	// C

	// R

	// U

	// D
	public void deleteEvaluationByUserCode(int userCode) {
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "DELETE FROM evaluation WHERE user_code=?";

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