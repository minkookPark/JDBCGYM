package 하성;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMemberDao implements MemberDao {

private static final String DEFAULT_PASSWORD = "a1234";

public boolean updatepasswordGym_member(String login_id) {
	boolean result = false;
	
	try(Connection conn = DataSource.getDataSource();
		PreparedStatement pStatement
		= conn.prepareStatement("UPDATE GYM_MEMBER SET LOGIN_PW = ? WHERE LOGIN_ID = ?")){
	
		pStatement.setString(1, DEFAULT_PASSWORD);
		pStatement.setString(2, login_id);
		
		int affectedRows = pStatement.executeUpdate();
			
		if(affectedRows > 0) {
			result = true;
		}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Gym_Member findByLoginData(int member_num, int pt_count, String login_id, String login_pw, String gender, int age, String name, int trainer_num, int charge_num) {
		Gym_Member member = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM GYM_MEMBER WHERE MEMBER_NUM = ? AND PT_COUNT = ? AND LOGIN_ID = ? AND LOGIN_PW = ? AND GENDER = ? AND AGE = ? AND NAME = ? AND TRAINER_NUM = ? AND CHARGE_NUM = ?")) {
		
		pStatement.setInt(1, member_num);	
		pStatement.setInt(2, pt_count);
		pStatement.setString(3, login_id);
		pStatement.setString(4, login_pw);
		pStatement.setString(5, gender);
		pStatement.setInt(6, age);
		pStatement.setString(7, name);
		pStatement.setInt(8, trainer_num);
		pStatement.setInt(9, charge_num);
		
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
			member = new Gym_Member();
				
			member.setLogin_id(rs.getString("login_id"));
			member.setMember_num(rs.getInt("member_num"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
}
