package 호영;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		JdbcGym_MemberDao mDao = new JdbcGym_MemberDao();
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
        	
    	//	dao.insert(member);
					
			List<Gym_Member> lLst =  new ArrayList<Gym_Member>();
			for (Gym_Member gym_Members : lLst) {
				System.out.println(gym_Members);
			}
			//Gym_Member member = new Gym_Member();
			Gym_Member member = mDao.findByMember_Num(1);
			//Gym_Member member = new Gym_Member();
			//mDao.findByMember_Num(1);
			mDao.update2(member);
			
			for(Gym_Member m : mDao.findAll())
			{
				System.out.println(m);
			}
				
			
			
			
			
		
	}

}
