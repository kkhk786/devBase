package test.board;

import java.sql.Date;

public class Reply {
	private int replynum;
	private int boardnum;
	private String id;
	private String retext;
	private Date inputdate;
	public Reply() {
		super();
	}
	public int getReplynum() {
		return replynum;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public String getId() {
		return id;
	}
	public String getRetext() {
		return retext;
	}
	public Date getInputdate() {
		return inputdate;
	}
	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setRetext(String retext) {
		this.retext = retext;
	}
	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}
	@Override
	public String toString() {
		return "Reply [replynum=" + replynum + ", boardnum=" + boardnum
				+ ", id=" + id + ", retext=" + retext + ", inputdate="
				+ inputdate + "]";
	}
	
}
