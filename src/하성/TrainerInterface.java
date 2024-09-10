package space.jdbc.gym;

import java.util.List;

public interface TrainerInterface {
	
	boolean insert(Admin admin);
	boolean insert(Charge_List charge_list);
	
	List<Admin> findAll();
	Admin findById(Long num);
	Charge_List findById(int num);
	
	boolean update(Charge_List charge_list);
	boolean update(Admin admin);
	
	boolean deleteById(Long num);
}
