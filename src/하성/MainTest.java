package 하성;

import java.sql.Timestamp;
import java.util.List;



public class MainTest {
	public static void main(String[] args) {
		
//		Admin admin = new Admin();
//		
//		admin.setManager_num(7777);
//		admin.setPosition("테스터");
		
//		JDBCAdminDao jdbcadmindao = new JDBCAdminDao();
//		jdbcadmindao.insert(admin);
		
		
//		List<Admin> admin1 = jdbcadmindao.findAll();
//		for (Admin admin2 : admin1) {
//			System.out.println(admin2);
//		}
		
//		Admin admin2 = new Admin();
//		admin2.setManager_num(3214);
//		admin2.setPosition("테스터");
		
		Charge chargeList = new Charge();
		
		chargeList.setCharge_num(77);
		chargeList.setPeriod_date(12);
		chargeList.setPt_count(5);
		
		JDBCChargeDao jdbcchargedao = new JDBCChargeDao();
//		jdbcchargedao.insert(chargeList);
		
//		for (Charge chargeList2 : jdbcchargedao.findAll()) {
//			System.out.println(chargeList2);
//		}
		
//		System.out.println(jdbcchargedao.findByCharge_num(77));
		
//		jdbcchargedao.update(chargeList);
		
		jdbcchargedao.deleteByCharge_Num(77);
		
//		for (Admin charge_list2 : jdbcadmindao.findAll()) {
//			System.out.println(charge_list2);
//		}
		
//		System.out.println(jdbcadmindao.findByManager_num(7777));
		
//		jdbcadmindao.deleteByManager_num(7777);
		
	}
}
