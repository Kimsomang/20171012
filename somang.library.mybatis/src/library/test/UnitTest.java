package library.test;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

public class UnitTest {
	public static void main(String[] args) throws ParseException {
		
		Utility u = new Utility();
		
		System.out.println(u.today());
		System.out.println(u.periodDate(10));
		
		int test = -2;
		int test2 = -test;
		System.out.println(test2);
		
		Date today = u.today();
		Date testDate = u.periodDate(2);
		
		int compare = today.compareTo(testDate);
		System.out.println(compare);
	}

	public static String toDFormat(int num) {
		DecimalFormat df = new DecimalFormat("000");
		return df.format(num);
	}

	public static StringBuffer secureFormat(String str) {
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		sb.append(str);

		for (int i = 4; i < sb.length(); i++) {
			sb2.append('*');
		}
		sb.replace(4, sb.length(), sb2.toString());
		return sb;
	}
}
