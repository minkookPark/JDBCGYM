package 하성;

public interface MemberDao {
	boolean updatepasswordGym_member(String login_id);
	Member findByLogin_id(String login_id);
	Member findByMember_num(int member_num);
}
