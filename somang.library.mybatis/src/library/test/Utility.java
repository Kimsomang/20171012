package library.test;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utility {

	/**
	 * �����ڵ������ ���� ��¥�������� ����ϴ� �޼ҵ�
	 * @return ������ ���Ŀ� ���߾� ��¥ ���
	 */
	public String dateNumber() {
		SimpleDateFormat codeformat = new SimpleDateFormat("yyyyMMdd");
		String number = codeformat.format(new java.util.Date());
		return number;
	}
	
	/**
	 * �ð��������� ����ϴ� �޼ҵ�
	 * @return ������ ���Ŀ� ���߾� �ð� ���
	 */
	public String lending() {
		GregorianCalendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		String date = hour+":"+minute+":"+second;
		return date;
	}
	
	/**
	 * ��¥�������� ����ϴ� �޼ҵ�
	 * @return ������ ���Ŀ� ���߾� ��¥ ���
	 */
	public Date today() {
		return new Date();
	}
	
	/**
	 * �ƱԸ�Ʈ�� ���� �ϼ���ŭ ���� ��¥�� ���Ŀ� ���߾� ����ϴ� �޼ҵ�
	 * @return ������ ���Ŀ� ���߾� ��¥ ���
	 */
	public Date periodDate(int plus) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DATE, plus);
		return calendar.getTime();
	}
}
