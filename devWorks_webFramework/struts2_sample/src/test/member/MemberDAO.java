package test.member;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.common.MybatisConfig;

//회원관련 DB 처리
public class MemberDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	//회원정보 저장
	public void insertMember(Member member) throws SQLException {
		SqlSession sqlSession = null;
		try {
			sqlSession = factory.openSession();
			int re = sqlSession.insert("member.insertMember", member);
			System.out.println(re);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	//회원정보 읽기
	public Member getMember(String id) throws SQLException {
		SqlSession sqlSession = null;
		Member member = null;
		try {
			sqlSession = factory.openSession();
			member = sqlSession.selectOne("member.getMember", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return member;
	}

	//우편번호 검색
	public List<Zipcode> selectZipcode(String searchText) throws SQLException {
		SqlSession sqlSession = null;
		List<Zipcode> zipcodeList = null;
		try {
			sqlSession = factory.openSession();
			zipcodeList = sqlSession.selectList("member.selectZipcode", searchText);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return zipcodeList;
	}

	//회원정보 수정
	public int updateMember(Member member) throws SQLException {
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = factory.openSession();
			result = sqlSession.update("member.updateMember", member);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}

}


/*package test.member;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.common.MybatisConfig;

//���愿�� DB 泥�━
public class MemberDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 留��諛����媛�껜

	//�����낫 ���
	public void insertMember(Member member) throws SQLException {
		SqlSession sqlSession = null;
		try {
			sqlSession = factory.openSession();
			int re = sqlSession.insert("member.insertMember", member);
			System.out.println(re);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	//�����낫 �쎄린
	public Member getMember(String id) throws SQLException {
		SqlSession sqlSession = null;
		Member member = null;
		try {
			sqlSession = factory.openSession();
			member = sqlSession.selectOne("member.getMember", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return member;
	}

	//�고�踰�� 寃��
	public List<Zipcode> selectZipcode(String searchText) throws SQLException {
		SqlSession sqlSession = null;
		List<Zipcode> zipcodeList = null;
		try {
			sqlSession = factory.openSession();
			zipcodeList = sqlSession.selectList("member.selectZipcode", searchText);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return zipcodeList;
	}

	//�����낫 ���
	public int updateMember(Member member) throws SQLException {
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = factory.openSession();
			result = sqlSession.update("member.updateMember", member);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}

}
*/