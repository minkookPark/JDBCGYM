package 희진;

import java.sql.Timestamp;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
// -----------------------------------------------------------------------
		JDBCInbodyDao dao = new JDBCInbodyDao();
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

		dao.insert(newInbody);
// -----------------------------------------------------------------------
		List<Inbody> inbodys = dao.findAll();
		for (Inbody inbody : inbodys) {
			System.out.println(inbody);

// -----------------------------------------------------------------------
			Inbody inbody2 = dao.findBybodynum(2);

			if (inbody2 != null) {
				System.out.println("M_date: " + inbody2.getM_date() + ", Weight: " + inbody2.getWeight() + ", Height: "
						+ inbody2.getHeight() + ", Fat: " + inbody2.getFat() + ", Muscle: " + inbody2.getMuscle()
						+ ", Muscle: " + inbody2.getMuscle() + ", Body_age: " + inbody2.getBody_age() + ", Body_score: "
						+ inbody2.getBody_score() + ", Member_num: " + inbody2.getMember_num());
			} else {
				System.out.println("인바디 정보가 없습니다.");
			}
// -----------------------------------------------------------------------
			boolean deleted = dao.deleteBybodynum(2);
		}
	}
}