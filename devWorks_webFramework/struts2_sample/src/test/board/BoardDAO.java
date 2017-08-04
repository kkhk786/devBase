package test.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.common.MybatisConfig;


//게시판 관련
public class BoardDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); 
	SqlSession ss = null;

	//글 저장
	public void insertBoard(Board board) {
		try {
			ss = factory.openSession();	
			ss.insert("board.insertBoard", board);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}

	//전체 게시물 수 가져오기
	public int getTotal(String searchText) throws SQLException {
		int total = 0;
		
		//Mybatis로 전달할 Parameter들
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchText", searchText);

		try {
			ss = factory.openSession();
			total = ss.selectOne("board.getTotal", map);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return total;
	}
	
	//글 목록
	public List<Board> listBoard(String searchText, int startRecord, int countPerPage) {
		List<Board> boardlist = null;
		
		//RowBounds 방식을 이용한 페이징 처리
		
		//Mybatis로 전달할 Parameter들
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchText", searchText);
		
		//결과중 읽을 위치와 개수 //startRecord의 위치에서 countPerPage만큼을 조회해서 결과를 조회
		RowBounds bound = new RowBounds(startRecord, countPerPage);
		
		try {
			ss = factory.openSession();
			boardlist = ss.selectList("board.listBoard", map, bound);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ss.close();
		}
		
		//Pagination 쿼리를 이용한 페이징 처리
		/*HashMap map = new HashMap();
		map.put("searchText", searchText);
		map.put("start", startRecord);
		map.put("end", countPerPage);
		
		try {
			ss = factory.openSession();
			boardlist = ss.selectList("board.listBoard", map);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ss.close();
		}*/
		
		return boardlist;
	}	
	
	public void updateViewcount(Board board) {
		ss = factory.openSession();
		ss.update("board.viewcount", board);
		ss.commit();
		ss.close();
	}
	
	//글 읽기
	public Board getBoard(int boardnum) {
		Board board = null;
		
		try {
			ss = factory.openSession();
			board = ss.selectOne("board.getBoard", boardnum);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ss.close();
		}
		return board;
	}	
	
	//글 삭제
	public int deleteBoard(int boardnum) {
		int result = 0;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardnum", boardnum);
		try {
			ss = factory.openSession();	
			ss.delete("board.deleteReply", map);
			result = ss.delete("board.deleteBoard", boardnum);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return result;
	}
	
	//글 수정
	public int updateBoard(Board board) {
		int result = 0;
		try {
			ss = factory.openSession();	
			result = ss.update("board.updateBoard", board);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return result;
	}
	
	//리플 저장
	public void insertReply(Reply reply) {
		try {
			ss = factory.openSession();
			ss.insert("board.insertReply", reply);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}
	
	//한 게시물의 리플 목록
	public List<Reply> listReply(int boardnum) {
		List<Reply> replylist = null;
		
		try {
			ss = factory.openSession();
			replylist = ss.selectList("board.listReply", boardnum);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ss.close();
		}		
		return replylist;
	}
	
	//리플 삭제
	public int deleteReply(int replynum, String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("replynum", replynum);
		map.put("id", id);
		
		int result = 0;
		try {
			ss = factory.openSession();	
			result = ss.delete("board.deleteReply", map);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return result;
	}
	
	//리플 수정
	public int updateReply(Reply reply) {
		int result = 0;
		try {
			ss = factory.openSession();	
			result = ss.update("board.updateReply", reply);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return result;
	}

	public void insertFile(FileVO file) {
		try {
			ss = factory.openSession();
			ss.insert("board.insertFile", file);
			ss.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ss != null) ss.close();
		}
	}
	
	public List<FileVO> getFile(int boardnum) {
		List<FileVO> list = null;
		try {
			ss = factory.openSession();
			list = ss.selectList("board.getFile", boardnum);
			ss.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ss != null) ss.close();
		}
		return list;
	}
	
	public void deleteFile(FileVO file) {
		try {
			ss = factory.openSession();
			ss.update("board.deleteFile", file);
			ss.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ss != null) ss.close();
		}
	}
}
