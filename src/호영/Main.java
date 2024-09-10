package 호영;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//  Gym_Member member = new Gym_Member();
		/*	member.setMember_num();
        	member.setPt_count();
        	member.setReg_date();
        	member.setExp_date();
        	member.setLogin_id();
        	member.setLogin_pw();
        	member.setGender(;
        	member.setAge();
        	member.setName();
        	member.setCharge_num();
        	member.setTrainer_num();
        	*/
        	JdbcGym_MemberDao dao = new JdbcGym_MemberDao();
    	//	dao.insert(member);
					
			List<Gym_Member> lLst =  new ArrayList<Gym_Member>();
			for (Gym_Member gym_Member : lLst) {
				System.out.println(gym_Member);
			}
			Gym_Member member = dao.findByMember_Num(3333);
			dao.update(member);
			
			
		
	}

}
