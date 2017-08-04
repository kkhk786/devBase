package test.board;

public class FileVO {
	private int filenum;
	private int boardnum;
	private String savedfile;
	private String originalfile;
	
	public FileVO() {
		super();
	}
	public FileVO(int filenum, int boardnum, String savedfile, String originalfile) {
		super();
		this.filenum = filenum;
		this.boardnum = boardnum;
		this.savedfile = savedfile;
		this.originalfile = originalfile;
	}
	public int getFilenum() {
		return filenum;
	}
	public void setFilenum(int filenum) {
		this.filenum = filenum;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getSavedfile() {
		return savedfile;
	}
	public void setSavedfile(String savedfile) {
		this.savedfile = savedfile;
	}
	public String getOriginalfile() {
		return originalfile;
	}
	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}
	@Override
	public String toString() {
		return "FileVO [filenum=" + filenum + ", boardnum=" + boardnum
				+ ", savedfile=" + savedfile + ", originalfile=" + originalfile
				+ "]";
	}
	
}
