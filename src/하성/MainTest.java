package 하성;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;



public class MainTest {
	public static void main(String[] args) {
		
		Admin admin = new Admin();
		
		admin.setManager_num(3214);
		admin.setPosition("테스터");
		
		JDBCTrainerDao jdbctrainerdao = new JDBCTrainerDao();
		jdbctrainerdao.insert(admin);
		
		List<Admin> admin1 = jdbctrainerdao.findAll();
		
		Admin admin2 = new Admin();
		admin2.setManager_num(3214);
		admin2.setPosition("테스터");
		
		Charge_List charge_list = new Charge_List();
		
		charge_list.setCharge_num(35);
		charge_list.setPeriod(Date.valueOf("2025-11-16"));
		charge_list.setPt_count(5);
		
		jdbctrainerdao.insert(charge_list);
		
		charge_list.setCharge_num(14);
		charge_list.setPeriod(Date.valueOf("2025-03-08"));
		charge_list.setPt_count(3);
		
		jdbctrainerdao.update(charge_list);
		
		for (Admin charge_list2 : jdbctrainerdao.findAll()) {
			System.out.println(charge_list2);
		}
	}
}
