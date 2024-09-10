package 호영;

import java.util.List;

public interface Gym_MemberDao {
	
	boolean insert(Gym_Member member);
	
	List<Gym_Member> findAll();
	
	Gym_Member findByMember_Num(int member_num);
	
	boolean update (Gym_Member member);
	
	boolean deleteByMember_Num(int member_num);
	
	
}
