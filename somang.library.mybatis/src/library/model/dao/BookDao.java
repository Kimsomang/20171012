package library.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import library.model.dto.Book;

public class BookDao {
	private FactoryDao factory = FactoryDao.getInstance();
	private static BookDao instance = new BookDao();
//	private ResourceBundle queryBundle;
	
	private BookDao() {
//		queryBundle = ResourceBundle.getBundle("conf/query");
	}
	
	public static BookDao getInstance() {
		return instance;
	}
	
	/**
	 * ���� ��� �޼ҵ�
	 * @param book ���� ����
	 * @return ��� ���� ���, ���н� 0
	 */
	public int insert(Book book) {
		SqlSession session = factory.getSqlSession(true);
		int count = 0;
		try {
			count = session.insert("book.insert", book);
		} finally {
			session.close();
		}
		return count;
	}

	/**
	 * ���� ���հ˻� �޼ҵ�
	 * @param searchInfo
	 * @return �˻� ����Ʈ
	 */
	public List<Book> selectKeyword(HashMap<String, String> searchInfo) {
		SqlSession session = factory.getSqlSession();
		List<Book> books = null;
		
		try {
			books = session.selectList("book.selectKeyword", searchInfo);
		} finally {
			session.close();
		}
		return books;
	}
	
	/**
	 * ���� ��� ��ȸ �޼ҵ�
	 * @return ���� ���� ���
	 */
	public List<Book> selectBooks(){
		SqlSession session = factory.getSqlSession();
		List<Book> books = null;
		try {
			books = session.selectList("book.selectBooks");
		} finally {
			session.close();
		}
		return books;
	}
	
	/**
	 * ���� ���� ��ġ ���� �޼ҵ�
	 * @param bookNo ������ȣ
	 * @param location ���� ��ġ
	 * @return ������ ���� ���� ��� ��ȯ, ���н� 0
	 */
	public int updateLoc(String bookNo, String location) {
		SqlSession session = factory.getSqlSession(true);
		HashMap<String, String> bookMap = new HashMap<>();
		bookMap.put("bookNo", bookNo);
		bookMap.put("location", location);
		int count = 0;
		try {
			count = session.update("book.updateLocation", bookMap);
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * ���� �ڷ���� ���� �޼ҵ�
	 * @param bookNo ������ȣ
	 * @param condition �ڷ����
	 * @return ������ ���� ���� ��� ��ȯ, ���н� 0
	 */
	public int updateCondition(String bookNo, String condition) {
		SqlSession session = factory.getSqlSession(true);
		HashMap<String, String> bookMap = new HashMap<>();
		bookMap.put("bookNo", bookNo);
		bookMap.put("condition", condition);
		int count = 0;
		try {
			count = session.update("book.updateCondition", bookMap);
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * ���� ���� �޼ҵ�
	 * @param bookNo ������ȣ
	 * @return ������ ���� ���� ���, ���н� 0
	 */
	public int delete(String bookNo) {
		SqlSession session = factory.getSqlSession(true);
		int count = 0;
		try { 
			count = session.delete("book.delete", bookNo);
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * �����̷��� �����ִ� ������ ��� ������ ��������
	 * @param bookNo ������ȣ
	 * @return ������ ���� �������, ���н� 0
	 */
	public int deleteBook(String bookNo) {
		SqlSession session = factory.getSqlSession(true);
		int count = 0;
		HashMap<String, String> bookMap = new HashMap<>();
		bookMap.put("bookNo", bookNo);
		bookMap.put("condition", "��������");
		try {
			count = session.update("book.updateCondition", bookMap);
		} finally {
			session.close();
		}
		return count;
	}
}
