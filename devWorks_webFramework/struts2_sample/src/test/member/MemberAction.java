package test.member;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MemberAction extends ActionSupport implements SessionAware{
	Member member;
	String searchText;			//전달된 검색어
	boolean idCheck;			//ID 사용 가능 여부
	List<Zipcode> zipcodeList;	//검색된 우편번호 목록
	Map<String, Object> session;
	
	String id;
	String password;
	
	
	//회원가입 처리
	public String insertMember() throws Exception {
		java.util.Date utilDate = new java.util.Date();
		Date date = new Date(utilDate.getTime());
		member.setInputdate(date);
		MemberDAO dao = new MemberDAO();
		dao.insertMember(member);
		return SUCCESS;
	}

	//ID 중복 검사
	public String idCheck() throws Exception {
		idCheck = true;
		MemberDAO dao = new MemberDAO();
		member = dao.getMember(searchText);
		if(member != null) {
			idCheck = false;
		}
		return SUCCESS;
	}
	
	//우편번호 검색
	public String zipcode() throws Exception {
		MemberDAO dao = new MemberDAO();
		zipcodeList = dao.selectZipcode(searchText);
		return SUCCESS;
	}
	
	//로그인 처리
	public String login() throws Exception {
		if(session.get("id") != null) {
			id = session.get("id")+"";
		} else {
			
			MemberDAO dao = new MemberDAO();
			member = dao.getMember(id);
			if(member == null || !password.equals(member.getPassword())) {
				return Action.LOGIN;
			}
			session.put("id", member.getId());
		}
		return SUCCESS;	
	}
	
	//로그아웃 처리
	public String logout() throws Exception {
		session.remove("id");
		return SUCCESS;
	}
	
	//회원정보 수정 폼으로
	//로그인 여부 확인
	public String updateMemberForm() throws Exception {
		Object tmp = session.get("id");
		if(tmp == null) {
			return Action.LOGIN;
		}
		MemberDAO dao = new MemberDAO();
		member = dao.getMember(id);
		return SUCCESS;
	}
	
	//회원정보 수정
	//로그인 여부 확인
	public String updateMember() throws Exception {
		Object tmp = session.get("id");
		if(tmp == null) {
			return Action.LOGIN;
		}
		MemberDAO dao = new MemberDAO();
		java.util.Date utilDate = new java.util.Date();
		Date date = new Date(utilDate.getTime());
		member.setInputdate(date);
		dao.updateMember(member);
		return SUCCESS;
	}
	
	
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public boolean isIdCheck() {
		return idCheck;
	}

	public void setIdCheck(boolean idCheck) {
		this.idCheck = idCheck;
	}

	public List<Zipcode> getZipcodeList() {
		return zipcodeList;
	}

	public void setZipcodeList(List<Zipcode> zipcodeList) {
		this.zipcodeList = zipcodeList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
