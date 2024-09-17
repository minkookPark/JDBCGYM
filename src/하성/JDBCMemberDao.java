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
	public Member findByLogin_id(String login_id) {
		Member member = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT MEMBER_NUM FROM GYM_MEMBER WHERE LOGIN_ID = ?")) {
		
		pStatement.setString(1, login_id);	
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
			member = new Member();
				
			member.setMember_num(rs.getInt("member_num"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public Member findByMember_num(int member_num) {
		Member member = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT LOGIN_ID FROM GYM_MEMBER WHERE MEMBER_NUM = ?")) {
		
		pStatement.setInt(1, member_num);	
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
			member = new Member();
				
			member.setLogin_id(rs.getString("login_id"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
}
