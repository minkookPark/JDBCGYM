package 호영;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JdbcGym_MemberDao implements Gym_MemberDao{

	@Override
	public boolean insert(Gym_Member member) {
		{
	        boolean result = false;	    
	        try(Connection conn = DataSource.getDataSource();
	            PreparedStatement pStatement = conn.prepareStatement(
	            		"INSERT INTO GYM_MEMBER (MEMBER_NUM, PT_COUNT, REG_DATE, EXP_DATE, LOGIN_ID, LOGIN_PW, GENDER, AGE, TRAINER_NUM, CHARGE_NUM, NAME)"
	            		+ "VALUES (?, ?, ? , ? ,? , ? , ? , ? , ? , ? , ?)"))
	            		
	        {
	        	pStatement.setInt(1, member.getMember_num());
	            pStatement.setInt(2 , member.getPt_count());
	            pStatement.setTimestamp(3 , member.getReg_date());
	            pStatement.setDate(4 , member.getExp_date());
	            pStatement.setString(5 , member.getLogin_id());
	            pStatement.setString(6 , member.getLogin_pw());
	            pStatement.setString(7 , member.getGender());
	            pStatement.setInt(8 , member.getAge());
	            pStatement.setInt(9 , member.getTrainer_num());
	            pStatement.setInt(10 , member.getCharge_num());
	            pStatement.setString(11 , member.getName());
	            
	            //수정된 줄이 반환된다.
	            int rows = pStatement.executeUpdate();
	            
	            if(rows > 0)
	            {
	                result = true;
	            }
	        }
	        catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
	        
	        if(result)
	            System.out.println("성공적으로 보냄");
	        else
	            System.out.println("전송 실패");
	        
	        
	        return result;
		}
}

	@Override
	public List<Gym_Member> findAll() {
		List<Gym_Member> mLst = new ArrayList<Gym_Member>();
        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStatement = conn.prepareStatement("SELECT * FROM Gym_Member ORDER BY Member_Num");
             ResultSet rs = pStatement.executeQuery()) {

            while (rs.next()) {
            	Gym_Member gm = new Gym_Member(
                		rs.getInt("member_num"),
                		rs.getInt("pt_count"),
                		rs.getTimestamp("reg_date"),
                		rs.getDate("exp_date"),
                		rs.getString("login_id"),
                		rs.getString("login_pw"),
                		rs.getString("gender"),
                		rs.getInt("age"),
                		rs.getString("name"),
                		rs.getInt("charge_num"),
                		rs.getInt("trainer_num")
                        );
                mLst.add(gm);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
     return mLst;
	}

	@Override
	public Gym_Member findByMember_Num(int member_num) {
		Gym_Member member = null;
		
		try (Connection conn = DataSource.getDataSource();
				PreparedStatement pStatement = conn.prepareStatement(
						"select * from gym_member where member_num = ?")
						) {
			
			pStatement.setInt(1, member_num);
			ResultSet rs = pStatement.executeQuery();
			if (rs.next()) {
				member = new Gym_Member();
				member.setMember_num(rs.getInt("member_num"));
				member.setPt_count(rs.getInt("pt_count"));
				member.setReg_date(rs.getTimestamp("reg_date"));
				member.setExp_date(rs.getDate("exp_date"));
				member.setLogin_id(rs.getString("login_id"));
				member.setLogin_pw(rs.getString("login_pw"));
				member.setGender(rs.getString("gender"));
				member.setAge(rs.getInt("age"));
				member.setName(rs.getString("name"));
				member.setCharge_num(rs.getInt("charge_num"));
				member.setTrainer_num(rs.getInt("trainer_num"));
				}

	            }
			catch (SQLException e) {
	              throw new RuntimeException(e);
	        }

	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }

	        return member;       
			}

	@Override
	public boolean update(Gym_Member member) {
		 boolean result = false;

		 try (Connection conn = DataSource.getDataSource();
	          PreparedStatement pStatement = conn.prepareStatement(
	            		 "update gym_member set pt_count = ? , reg_date = ? , exp_date = ? , login_id = ?"
	            		 + "login_pw = ? , gender = ? , age = ?, trainer_num = ? , charger_num = ? , name = ?,"
	            		 + " where member_num = ?"))
	        {
	   
	        	pStatement.setInt(1, member.getMember_num());
	            pStatement.setInt(2 , member.getPt_count());
	            pStatement.setTimestamp(3 , member.getReg_date());
	            pStatement.setDate(4 , member.getExp_date());
	            pStatement.setString(5 , member.getLogin_id());
	            pStatement.setString(6 , member.getLogin_pw());
	            pStatement.setString(7 , member.getGender());
	            pStatement.setInt(8 , member.getAge());
	            pStatement.setInt(9 , member.getTrainer_num());
	            pStatement.setInt(10 , member.getCharge_num());
	            pStatement.setString(11 , member.getName());

	            pStatement.executeUpdate();
	            if(0 < pStatement.executeUpdate())
	            {
	            	result = true;
	            }

	            if(0 < pStatement.executeUpdate())
				{
					result = true;
				}

	        }
		 	
	        catch (Exception e)
	        {
	            e.printStackTrace();

	        }		
		 	
	        

	        }

	        return result;
	}

	public boolean update2(Gym_Member member) {
		 boolean result = false;
		 try (Connection conn = DataSource.getDataSource();
	          PreparedStatement pStatement = conn.prepareStatement(
	            		 "update gym_member set login_pw = ? where login_id = ?"))
	        {
	   
	        	pStatement.setString(1 , member.getLogin_pw());
	            pStatement.setString(2 , member.getLogin_id());	            	      
	            
	            if(0 < pStatement.executeUpdate()) {
	            	result  = true;
	            }
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
		 	
		 	
	        return result;
	}
	@Override
	public boolean deleteByMember_Num(int member_num) {
		boolean result = false;
		try (Connection conn = DataSource.getDataSource();
	         PreparedStatement pStatement = conn.prepareStatement("delete from gym_member where member_num = ?"))
	        {
	            pStatement.setInt(1, 1);
	            
	            pStatement.executeUpdate();
	            
	            if(0 < pStatement.executeUpdate()) {
	            	result = true;
	            }
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }



	        return result;

	}
	
}
