package board.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import board.Board;
import board.BoardRequestDto;
import util.DBManager;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BoardDao() {
	}

	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}

	// C

	public void createBoard(BoardRequestDto boardDto) {
		Board board = new Board(boardDto);

		this.conn = DBManager.getConnection();
		if (conn != null) {
			String sql = "INSERT INTO board VALUES(?,?,?,?,?,?,?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, board.getWriteCode());
				this.pstmt.setInt(2, board.getUserCode());
				this.pstmt.setString(3, board.getCategory());
				this.pstmt.setString(4, board.getTitle());
				this.pstmt.setString(5, board.getContents());
				this.pstmt.setTimestamp(6, board.getRegDate());
				this.pstmt.setTimestamp(7, board.getModDate());

				this.pstmt.execute();

			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// R

	public ArrayList<Board> getBoardAll() {
		ArrayList<Board> list = new ArrayList<>();
		this.conn = DBManager.getConnection();

		if (conn != null) {
			String sql = "SELECT * FROM board";

			try {
				this.pstmt = conn.prepareStatement(sql);
				this.rs = pstmt.executeQuery();

				while (this.rs.next()) {
					int writeCode = this.rs.getInt(1);
					int userCode = this.rs.getInt(2);
					String category = this.rs.getString(3);
					String title = this.rs.getString(4);
					String contents = this.rs.getString(5);
					Timestamp regDate = this.rs.getTimestamp(6);
					Timestamp modDate = this.rs.getTimestamp(7);

					Board board = new Board(writeCode, userCode, category, title, contents, regDate, modDate);
					list.add(board);
				}

			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}
	
	public int getWriteCode() {
		int writeCode = 1;

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "SELECT MAX(write_code) FROM board";
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				this.rs.next();
				writeCode = this.rs.getInt(1);

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return (writeCode+1);
	}
	
	public Board getBoardByWriteCode(int writeCode) {
		Board board = null;
		this.conn = DBManager.getConnection();
		if(conn != null) {
			String sql = "SELECT * FROM board WHERE write_code=?";
			
			try {
				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setInt(1, writeCode);
				this.rs = pstmt.executeQuery();
				
				while (this.rs.next()) {
					int userCode = this.rs.getInt(2);
					String category = this.rs.getString(3);
					String title = this.rs.getString(4);
					String contents = this.rs.getString(5);
					Timestamp regDate = this.rs.getTimestamp(6);
					Timestamp modDate = this.rs.getTimestamp(7);

					board = new Board(writeCode, userCode, category, title, contents, regDate, modDate);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return board;
	}
	
	public int getBoardCount() {
		int count = 0;
		this.conn = DBManager.getConnection();
		if(conn != null) {
			String sql = "SELECT count(*) from board";
			
			try {
				this.pstmt = conn.prepareStatement(sql);
				this.rs = pstmt.executeQuery();
				
				if(this.rs.next()) {
					count = this.rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return count;
	}
	
	public ArrayList<Board> getBoardList(int startIndex, int pageSize){
		ArrayList<Board> list = new ArrayList<>();
		this.conn = DBManager.getConnection();
		if(conn != null) {
			String sql = "SELECT * from board limit ?, ?";
			
			try {
				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setInt(1, startIndex);
				this.pstmt.setInt(2, pageSize);
				this.rs = pstmt.executeQuery();
				
				while(this.rs.next()) {
					int writeCode = this.rs.getInt(1);
					int userCode = this.rs.getInt(2);
					String category = this.rs.getString(3);
					String title = this.rs.getString(4);
					String contents = this.rs.getString(5);
					Timestamp regDate = this.rs.getTimestamp(6);
					Timestamp modDate = this.rs.getTimestamp(7);

					Board board = new Board(writeCode, userCode, category, title, contents, regDate, modDate);
					list.add(board);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		
		return list;
	}
	
	
	// U

	public void modifyBoard(BoardRequestDto boardDto) {
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "UPDATE board SET title=?, contants=?, modified_date=? WHERE write_code=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, boardDto.getTitle());
				this.pstmt.setString(2, boardDto.getContents());
				this.pstmt.setTimestamp(3, boardDto.getModDate());
				this.pstmt.setInt(4, boardDto.getWriteCode());

				this.pstmt.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}

	}
	
	
	
	
	
	// D

	public void deleteBoard(int writeCode, int userCode) {
		
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "DELETE FROM board WHERE write_code=? and user_code=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, writeCode);
				this.pstmt.setInt(2, userCode);
				
				this.pstmt.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
			
		}
	}
	
	public void deleteBoardByUserCode(int userCode) {
		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "DELETE FROM board WHERE user_code=?";

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
