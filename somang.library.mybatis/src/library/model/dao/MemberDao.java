package library.model.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import library.model.dto.Member;

public class MemberDao {
	private FactoryDao factory = FactoryDao.getInstance();
	private static MemberDao instance = new MemberDao();
	
	private MemberDao() {}
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	/**
	 * ȸ�� ��� �޼ҵ�
	 * @param member ȸ����ü
	 * @return ���н� 0, ������ ��ϵ� ���ڵ� ��� ��ȯ
	 */
	public int insert(Member member) {
		SqlSession session = factory.getSqlSession(true);
		int count = 0;
		try {
			count = session.insert("member.insert", member);
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * ȸ�����̵� �ߺ� ��ȸ �޼ҵ�
	 * @param id ȸ�����̵�
	 * @return �����ϸ� true, �������� ������ false ��ȯ
	 */
	public boolean isMemberId(String memberId) {
		SqlSession session = factory.getSqlSession();
		boolean isId = false;
		String duplicate = null;
		try {
			duplicate = session.selectOne("member.isId", memberId);
			if(duplicate != null) {
				isId = true;
			}
		} finally {
			session.close();
		}
		return isId;
	}
	
	/**
	 * ����ó �ߺ� ��ȸ �޼ҵ�
	 * @param mobile ����ó
	 * @return �����ϸ� true, �������� ������ false ��ȯ
	 */
	public boolean isMobile(String mobile) {
		SqlSession session = factory.getSqlSession();
		boolean isTel = false;
		String duplicate = null;
		try {
			duplicate = session.selectOne("member.isMobile", mobile);
			if(duplicate != null) {
				isTel = true;
			}
		} finally {
			session.close();
		}
		return isTel;
	}
	
	/**
	 * �α��ν� ���̵� ��й�ȣ ��ġ ��ȸ �޼ҵ�
	 * @param id ���̵�
	 * @return ��й�ȣ
	 */
	public String isLogin(String memberId) {
		SqlSession session = factory.getSqlSession();
		String password = null;
		try {
			password = session.selectOne("member.isLogin", memberId);
		} finally {
			session.close();
		}
		return password;
	}
	
	/**
	 * ���̵� ã�� ��ȸ �޼ҵ�
	 * @param name ȸ���̸�
	 * @param mobile ����ó
	 * @return ���̵�
	 */
	public String selectId(String name, String mobile) {
		SqlSession session = factory.getSqlSession();
		HashMap<String, String> idMap = new HashMap<>();
		idMap.put("name", name);
		idMap.put("mobile", mobile);
		String memberId = null;
		try {
			memberId = session.selectOne("member.selectId", idMap);
		} finally {
			session.close();
		}
		return memberId;
	}
	
	/**
	 * ��й�ȣ ã�� ��ȸ �޼ҵ�
	 * @param id ȸ�����̵�
	 * @param name ȸ���̸�
	 * @return ��й�ȣ
	 */
	public String selectPw(String memberId, String name, String mobile) {
		SqlSession session = factory.getSqlSession();
		HashMap<String, String> pwMap = new HashMap<>();
		pwMap.put("memberId", memberId);
		pwMap.put("name", name);
		pwMap.put("mobile", mobile);
		String password = null;
		try {
			password = session.selectOne("member.selectPw", pwMap);
		} finally {
			session.close();
		}
		return password;
	}
	
	/**
	 * ȸ�� ���� ��ȸ �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @return ȸ�� ��ü ����
	 */
	public Member selectUser(String memberId) {
		SqlSession session = factory.getSqlSession();
		Member dto = null;
		try {
			dto = session.selectOne("member.selectUser", memberId);
		} finally {
			session.close();
		}
		return dto;
	}
	
	/**
	 * ȸ�� ���� ��ü ��� ��ȸ �޼ҵ�
	 * @return ȸ�� ���� ���
	 */
	public List<Member> selectAll() {
		SqlSession session = factory.getSqlSession();
		List<Member> members = null;
		try {
			members = session.selectList("member.selectUsers");
		} finally {
			session.close();
		}
		return members;
	}
	
	/**
	 * ��й�ȣ ���� �޼ҵ�
	 * @param id ���̵�
	 * @param pw ��й�ȣ
	 * @return ������ ���� ���� ���, ���н� 0 ��ȯ
	 */
	public int updatePw(String id, String pw) {
		SqlSession session = factory.getSqlSession(true);
		HashMap<String, String> memberMap = new HashMap<>();
		memberMap.put("memberId", id);
		memberMap.put("password", pw);
		int count = 0;
		try {
			count = session.update("member.updatePw", memberMap);
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * ����ó ���� �޼ҵ�
	 * @param id ���̵�
	 * @param mobile ����ó
	 * @return ���� ���� ���, ���н� 0 ��ȯ
	 */
	public int updateMobile(String id, String mobile) {
		SqlSession session = factory.getSqlSession(true);
		HashMap<String, String> memberMap = new HashMap<>();
		memberMap.put("memberId", id);
		memberMap.put("mobile", mobile);
		int count = 0;
		try {
			count = session.update("member.updateMobile", memberMap);
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * �ּ� ���� �޼ҵ�
	 * @param id ���̵�
	 * @param address �ּ�
	 * @return ���� ���� ���, ���н� 0 ��ȯ
	 */
	public int updateAddress(String id, String address) {
		SqlSession session = factory.getSqlSession(true);
		HashMap<String, String> memberMap = new HashMap<>();
		memberMap.put("memberId", id);
		memberMap.put("address", address);
		int count = 0;
		try {
			count = session.update("member.updateAddress", memberMap);
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * ȸ�� Ż�� �޼ҵ�
	 * @param id ���̵�
	 * @return Ż�� ���� ���, ���н� 0
	 */
	public int withdrawUser(String memberId) {
		SqlSession session = factory.getSqlSession(true);
		int count = 0;
		try {
			count = session.delete("member.delete", memberId);
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * ȸ��Ż��� �������� �ִ� ������� ��������
	 * @param memberId ȸ�� ���̵�
	 * @return �������� ���� ���, ���н� 0
	 */
	public int deleteUser(String memberId) {
		SqlSession session = factory.getSqlSession(true);
		int count = 0;
		try {
			count = session.update("member.deleteUser", memberId);
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * ȸ�� �������� ���� ���� ��ȸ �޼ҵ�
	 * @param id ���̵�
	 * @return ���Ⱑ���̸� true, ����Ұ��� false
	 */
	public boolean isCondition(String memberId) {
		SqlSession session = factory.getSqlSession();
		boolean isStatus = false;
		try {
			String condition = session.selectOne("member.isCondition", memberId);
			if(condition.equals("���Ⱑ��"))
				isStatus=true;
		} finally {
			session.close();
		}
		return isStatus;
	}
	
	/**
	 * ȸ�� ���Ⱑ�� ���� ���� ���� �޼ҵ�
	 * @param id ���̵�
	 * @return ���� ���� ���, ���н� 0
	 */
	public int updateCondition(String id) {
		SqlSession session = factory.getSqlSession(true);
		HashMap<String, String> memberMap = new HashMap<>();
		memberMap.put("memberId", id);
		memberMap.put("condition", "����Ұ�");
		int count = 0;
		try {
			count = session.update("member.updateCondition", memberMap);
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * ȸ���� ����Ǽ� ��ȸ �޼ҵ�
	 * @param id ���̵�
	 * @return ����Ǽ�
	 */
	public int selectLend(String memberId) {
		SqlSession session = factory.getSqlSession();
		int lend = 0;
		try {
			String lending = session.selectOne("member.selectLend", memberId);
			lend = Integer.parseInt(lending.substring(0, 1));
		} finally {
			session.close();
		}
		return lend;
	}
	
	/**
	 * ȸ���� ����Ǽ� ���� ���� �޼ҵ�
	 * @param id ���̵�
	 * @return ���� ���� ���, ���н� 0
	 */
	public int updateLending(String id) {
		SqlSession session = factory.getSqlSession(true);
		int n = selectLend(id);
		int count = 0;
		if(n == 5) {
			System.out.println("���Ⱑ�� �Ǽ��� �ʰ��Ͽ����ϴ�.");
			return count;
		}
		HashMap<String, String> lendMap = new HashMap<>();
		lendMap.put("memberId", id);
		lendMap.put("lendBook", (++n)+"/5");
		try {
			count = session.update("member.updateLend", lendMap);
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * ȸ���� ����Ǽ� ���� ���� �޼ҵ�
	 * @param id ���̵�
	 * @return ���� ���� ���, ���н� 0
	 */
	public int updateReturn(String id) {
		SqlSession session = factory.getSqlSession(true);
		int n = selectLend(id);
		int count = 0;
		HashMap<String, String> returnMap = new HashMap<>();
		returnMap.put("memberId", id);
		returnMap.put("lendBook", (--n)+"/5");
		try {
			count = session.update("member.updateLend", returnMap);
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * ȸ���� ����Ұ��Ⱓ ���� �޼ҵ�
	 * @param id ���̵�
	 * @param overdue ����Ұ��Ⱓ
	 * @return ���� ���� ���, ���н� 0
	 */
	public int updateOverDate(String id, Date overdue) {
		SqlSession session = factory.getSqlSession(true);
		int count = 0;
		HashMap<String, Object> overMap = new HashMap<>();
		overMap.put("memberId", id);
		overMap.put("overdue", overdue);
		try {
			count = session.update("member.updateOverDate",	 overMap);
		} finally {
			session.close();
		}
		return count;
	}
}
