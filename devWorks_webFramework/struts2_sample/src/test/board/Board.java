package test.board;

import java.sql.Date;

public class Board {
	private int boardnum;
	private String id;
	private Date inputdate;
	private int viewcount;
	private String title;
	private String content;
	private String savedfile;
	private String originalfile;
	public Board() {
		super();
	}
	public int getBoardnum() {
		return boardnum;
	}
	public String getId() {
		return id;
	}
	public Date getInputdate() {
		return inputdate;
	}
	public int getViewcount() {
		return viewcount;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getSavedfile() {
		return savedfile;
	}
	public String getOriginalfile() {
		return originalfile;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setSavedfile(String savedfile) {
		this.savedfile = savedfile;
	}
	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}
	@Override
	public String toString() {
		return "Board [boardnum=" + boardnum + ", id=" + id + ", inputdate="
				+ inputdate + ", viewcount=" + viewcount + ", title=" + title
				+ ", content=" + content + ", savedfile=" + savedfile
				+ ", originalfile=" + originalfile + "]";
	}
	
	
}
