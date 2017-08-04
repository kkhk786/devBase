package test.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;

import test.common.FileService;
import test.common.PageNavigator;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BoardAction extends ActionSupport implements SessionAware {
	Board board;		//게시글 정보
	Map<String, Object> session;
	int boardnum;		//게시글 보기, 삭제시 글번호
	int replynum;		//삭제시 리플 번호
	
	List<Board> boardlist;			//게시물 목록
	PageNavigator pagenavi;			//페이징 관련 정보
	int currentPage = 1;			//게시물 목록의 현재 페이지
	String searchText;				//검색어
	int totalRecordsCount;			//전체게시물 수 
	
	Reply reply;					//리플 정보
	FileVO file;
	List<Reply> replylist;		//하나의 글에 달린 리플 목록
	List<FileVO> filelist;
	
	private List<File> upload;					//업로드할 파일. Form의 <file> 태그의 name.
	private List<String> uploadFileName;			//업로드할 파일의 파일명 (File타입 속성명 + "FileName")
	private List<String> uploadContentType;		//업로드할 파일의 컨텐츠 타입 (File타입 속성명 + "ContentType")
	
	private InputStream inputStream;
	private String contentType;
	private String contentDisposition;
	private long contentLength;
	
	//신규 게시물 저장
	//로그인 여부 확인
	public String insertBoard() throws Exception {
		BoardDAO dao = new BoardDAO();
		FileVO file = new FileVO();
		FileService fileService = new FileService();
		String basePath = getText("board.uploadpath");
		
		board.setId((session.get("id")).toString());
		java.util.Date utilDate = new java.util.Date();
		Date date = new Date(utilDate.getTime());
		board.setInputdate(date);
		dao.insertBoard(board);
		if(upload != null) {
			for(int i = 0; i < upload.size(); i++) {
				String savedfile = fileService.saveFile(upload.get(i), basePath, uploadFileName.get(i));
				file.setBoardnum(board.getBoardnum());
				file.setOriginalfile(uploadFileName.get(i));
				file.setSavedfile(savedfile);
				dao.insertFile(file);
			}
		}
		listBoard();
		return SUCCESS;
	}

	

	//게시판 글목록 보기
	public String listBoard() throws Exception {
		//user.properties에서 지정한 페이징 관련 상수들 읽기
		int countPerPage = Integer.parseInt(getText("board.countperpage"));		//페이지당 글목록 수
		int pagePerGroup = Integer.parseInt(getText("board.pagepergroup"));		//그룹당 페이지 수
		
		BoardDAO dao = new BoardDAO();
		totalRecordsCount = dao.getTotal(searchText);
		
		pagenavi = new PageNavigator(countPerPage, pagePerGroup, currentPage, totalRecordsCount);
		boardlist = dao.listBoard(searchText, pagenavi.getStartRecord(), pagenavi.getCountPerPage());
		
		return SUCCESS;
	}

	//글 읽기 (해당글의 리플목록 포함)
	public String readBoard() throws Exception {
		BoardDAO dao = new BoardDAO();
		if(boardnum == 0) {
			dao.updateViewcount(board);
		}
		board = dao.getBoard(board.getBoardnum());
		replylist = new BoardDAO().listReply(board.getBoardnum());
		filelist = new BoardDAO().getFile(board.getBoardnum());
		return SUCCESS;
	}

	//다운로드
	public String fileDownload() throws Exception {
		BoardDAO dao = new BoardDAO();
		filelist = new BoardDAO().getFile(boardnum);
		String basePath = getText("board.uploadpath");
		for(int i = 0; i <filelist.size(); i++) {
			if((filelist.get(i).getSavedfile()).equals(file.getSavedfile())) {
				File f = new File(basePath + "/" + filelist.get(i).getSavedfile());
				setContentLength(f.length());
				setContentDisposition("attachment ; filename = " + URLEncoder.encode(filelist.get(i).getOriginalfile()));
				setInputStream(new FileInputStream(f));
			}
		}
		return SUCCESS;
	}
	
	//글 삭제 (리플, 첨부파일 포함)
	public String deleteBoard() throws Exception {
		BoardDAO dao = new BoardDAO();
		String basePath = getText("board.uploadpath");
		board = dao.getBoard(boardnum);
		List<FileVO> filelist = dao.getFile(boardnum);
		if(filelist.size() != 0) {
			for (int i = 0; i < filelist.size(); i++) {
				System.out.println(filelist.get(i));
				dao.deleteFile(filelist.get(i));
				File f = new File(basePath + "/" + filelist.get(i).getSavedfile());
				f.delete();
			}
		}
		dao.deleteBoard(boardnum);
		listBoard();
		return SUCCESS;
	}
	
	//글 수정 폼으로
    //본인이 작성한 글이 아니면 INPUT 결과 반환
	public String editForm() throws Exception {
		BoardDAO dao = new BoardDAO();
		filelist = dao.getFile(boardnum);
		board = dao.getBoard(boardnum);
		return SUCCESS;	//본인 글이면
		//return INPUT;		//본인글이 아니면
	}
	
	//글 수정 처리
	public String editBoard() throws Exception {
		BoardDAO dao = new BoardDAO();
		FileVO file = new FileVO();
		
		//첨부파일이 null이 아니면 기존 파일 먼저 삭제하고 새로운 첨부파일 정보 포함하여 수정
		if (upload != null) {
			String basePath = getText("board.uploadpath");		//user.properties에 지정된 파일 저장 경로
			List<FileVO> beforeFile = dao.getFile(board.getBoardnum());	//수정 전의 파일 정보
			FileService fs = new FileService();
			for (int i = 0; i < beforeFile.size(); i++) {
				fs.fileDelete(basePath + "/" + beforeFile.get(i).getSavedfile());	//저장된 파일의 전체경로를 전달하여 파일 삭제
				file.setFilenum(beforeFile.get(i).getFilenum());
				dao.deleteFile(file);
			}
			for (int i = 0; i < upload.size(); i++) {
				String savedfile = fs.saveFile(upload.get(i), basePath, uploadFileName.get(i));	//서버에 임시 업로드된 파일객체, 저장경로, 업로드당시의 파일명 전달하고 실제 저장된 파일명 리턴받음
				file.setSavedfile(savedfile);
				file.setOriginalfile(uploadFileName.get(i));
				file.setBoardnum(board.getBoardnum());
				dao.insertFile(file);
			}//업데이트를 할 수 없다. 이전에 것을 삭제하고 새로운것을 추가해야 한다.
			
			
		}
		dao.updateBoard(board);
		//수정된 글 읽기로 돌아가기 위해
		boardnum = board.getBoardnum();
		readBoard();
		return SUCCESS;
	}
	
	
	//------------------- 리플 관련 ----------------------------//
	//게시판 글에 리플달기
	public String insertReply() throws Exception {
		//reply객체에 세션 ID를 읽어서 세팅
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = (Map<String, Object>) context.getSession();
		String loginId = (String) session.get("id");
		if (loginId == null) return LOGIN;
		
		reply.setId(loginId);
		java.util.Date utilDate = new java.util.Date();
		Date date = new Date(utilDate.getTime());
		reply.setInputdate(date);
		//DAO로 reply객체를 전달하여 DB에 저장
		new BoardDAO().insertReply(reply);

		replynum = reply.getReplynum();
		boardnum = reply.getBoardnum();		//되돌아갈 본문 글 번호
		
		replylist = new BoardDAO().listReply(boardnum);
		board = new Board();
		board.setBoardnum(boardnum);
		readBoard();
		return SUCCESS;
	}
	
	//리플 삭제
	public String deleteReply() throws Exception {
		//세션 ID 읽기
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = (Map<String, Object>) context.getSession();
		String loginId = (String) session.get("id");
		
		//DAO로 리플 번호와 로그인 아이디를 전달하여 리플 삭제
		new BoardDAO().deleteReply(replynum, loginId);
		board = new Board();
		board.setBoardnum(boardnum);
		readBoard();
		return SUCCESS;
	}
	
	//리플 수정
	public String updateReply() throws Exception {
		//세션 ID 읽기
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = (Map<String, Object>) context.getSession();
		String loginId = (String) session.get("id");
		
		reply.setId(loginId);

		//DAO로 reply객체를 전달하여 DB에서 수정
		new BoardDAO().updateReply(reply);
		boardnum = reply.getBoardnum();		//되돌아갈 본문 글 번호
		board = new Board();
		board.setBoardnum(boardnum);
		readBoard();
		return SUCCESS;
	}
	


	
	//Getters and Setters
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public List<Board> getBoardlist() {
		return boardlist;
	}

	public void setBoardlist(List<Board> boardlist) {
		this.boardlist = boardlist;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public PageNavigator getPagenavi() {
		return pagenavi;
	}

	public void setPagenavi(PageNavigator pagenavi) {
		this.pagenavi = pagenavi;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getReplynum() {
		return replynum;
	}

	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public List<Reply> getReplylist() {
		return replylist;
	}

	public void setReplylist(List<Reply> replylist) {
		this.replylist = replylist;
	}

	public int getTotalRecordsCount() {
		return totalRecordsCount;
	}

	public void setTotalRecordsCount(int totalRecordsCount) {
		this.totalRecordsCount = totalRecordsCount;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}
	
	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public List<File> getUpload() {
		return upload;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	public List<FileVO> getFilelist() {
		return filelist;
	}

	public void setFilelist(List<FileVO> filelist) {
		this.filelist = filelist;
	}

	public FileVO getFile() {
		return file;
	}

	public void setFile(FileVO file) {
		this.file = file;
	}
	
	
}
