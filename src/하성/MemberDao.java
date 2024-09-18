package 하성;

public interface MemberDao {
	boolean updatepasswordGym_member(String login_id);
	Gym_Member findByLoginData(int member_num, int pt_count, String login_id, String login_pw, String gender, int age, String name, int trainer_num, int charge_num);
}
