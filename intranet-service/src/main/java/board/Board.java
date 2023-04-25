package board;

import java.sql.Timestamp;

public class Board {

	private int writeCode, userCode;
	private String category, title, contents;
	private Timestamp regDate, modDate;

	public Board(int writeCode, int userCode, String category, String title, String contents, Timestamp regDate,
			Timestamp modDate) {
		this.writeCode = writeCode;
		this.userCode = userCode;
		this.category = category;
		this.title = title;
		this.contents = contents;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public Board(BoardRequestDto boardDto) {
		this.writeCode = boardDto.getWriteCode();
		this.userCode = boardDto.getUserCode();
		this.category = boardDto.getCategory();
		this.title = boardDto.getTitle();
		this.contents = boardDto.getContents();
		this.regDate = boardDto.getRegDate();
		this.modDate = boardDto.getModDate();

	}

	public int getWriteCode() {
		return writeCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public String getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

}
