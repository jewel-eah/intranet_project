package board;

import java.sql.Timestamp;

public class BoardRequestDto {

	private int writeCode, userCode;
	private String category, title, contents;
	private Timestamp regDate, modDate;

	public BoardRequestDto(int writeCode, int userCode, String category, String title, String contents,
			Timestamp regDate, Timestamp modDate) {
		this.writeCode = writeCode;
		this.userCode = userCode;
		this.category = category;
		this.title = title;
		this.contents = contents;
		this.regDate = new Timestamp(System.currentTimeMillis());
		this.modDate = modDate;
	}

	public int getWriteCode() {
		return writeCode;
	}

	public void setWriteCode(int writeCode) {
		this.writeCode = writeCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}

}
