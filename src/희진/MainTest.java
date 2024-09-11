package 희진;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
/*// -----------------------------------------------------------------------
		JDBCInbodyDao a = new JDBCInbodyDao();
// -----------------------------------------------------------------------
		Inbody newInbody = new Inbody();
		newInbody.setM_date(new Timestamp(System.currentTimeMillis())); // 현재 시간
		newInbody.setWeight(70.5);
		newInbody.setHeight(175.0);
		newInbody.setFat(20.0);
		newInbody.setMuscle(30.0);
		newInbody.setBody_age(25);
		newInbody.setBody_score(80);
		newInbody.setMember_num(1);

		a.insert(newInbody);
// -----------------------------------------------------------------------
		List<Inbody> inbodys = a.findAll();
		for (Inbody inbody : inbodys) {
			System.out.println(inbody);
		}

// -----------------------------------------------------------------------
		Inbody inbody2 = a.findBybodynum(2);

		if (inbody2 != null) {
			System.out.println("M_date: " + inbody2.getM_date() + ", Weight: " + inbody2.getWeight() + ", Height: "
					+ inbody2.getHeight() + ", Fat: " + inbody2.getFat() + ", Muscle: " + inbody2.getMuscle()
					+ ", Muscle: " + inbody2.getMuscle() + ", Body_age: " + inbody2.getBody_age() + ", Body_score: "
					+ inbody2.getBody_score() + ", Member_num: " + inbody2.getMember_num());
		}
// -----------------------------------------------------------------------
		boolean deleted = a.deleteBybodynum(2);

// -----------------------------------------------------------------------
*/		
		JDBCInbodyDao dao = new JDBCInbodyDao();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("기록일자를 입력하세요 (형식: yyyy-MM-dd HH:mm):");
		String dateInput = scanner.nextLine();
		
		Timestamp m_date = null;
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try {
			java.util.Date parseDate = date.parse(dateInput);
			m_date = new Timestamp(parseDate.getTime());
		} catch (ParseException e) {
			System.out.println("날짜 형식이 올바르지 않습니다");
			e.printStackTrace();
			scanner.close();
			return;
		}
		
		System.out.println("몸무게를 입력하세요");
		double Weight = scanner.nextDouble();
		
		System.out.println("키를 입력하세요");
		double height = scanner.nextDouble();
		
		System.out.println("지방량을 입력하세요");
		double fat = scanner.nextDouble();
		
		System.out.println("근육량을 입력하세요");
		double muscle = scanner.nextDouble();
		
		System.out.println("신체나이를 입력하세요");
		int Body_age = scanner.nextInt();
		
		System.out.println("신체점수를 입력하세요");
		int body_score = scanner.nextInt();
		
		System.out.println("회원번호를 입력하세요");
		int member_num = scanner.nextInt();
		
		Inbody inbody = new Inbody(m_date, Weight, height, fat, muscle, Body_age, body_score, member_num);
		
		try {
			boolean result= dao.insert(inbody);
			System.out.println("입력된 정보가 저장되었습니다."+result);
		} catch(Exception e) {
			System.out.println("입력된 정보가 저장되지 않았습니다.");
			e.printStackTrace();
		}	
		scanner.close();
	}
}