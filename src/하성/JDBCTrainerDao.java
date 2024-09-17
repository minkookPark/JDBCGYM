package 하성;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTrainerDao implements Daomanager {
	private static final String DEFAULT_PASSWORD = "a1234";
	
	public Trainer findByLogin_id(String login_id) {
		
		Trainer trainer = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT TRAINER_NUM FROM GYM_TRAINER WHERE LOGIN_ID = ?")) {
		
		pStatement.setString(1, login_id);	
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
			trainer = new Trainer();
				
			trainer.setTrainer_num(rs.getInt("trainer_num"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return trainer;
	}

	@Override
	public boolean deleteByLogin_id(int trainer_num) {
		boolean result = false;

		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("DELETE FROM GYM_TRAINER WHERE TRAINER_NUM = ?")){
			
			pStatement.setInt(1, trainer_num);
			
			int rows = pStatement.executeUpdate();
			
			if(rows>0) {
				result = true;
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
		return result;
	}

	@Override
	public boolean updatepasswordGym_trainer(String login_id) {
		boolean result = false;
		
		try(Connection conn = DataSource.getDataSource();
			PreparedStatement pStatement
			= conn.prepareStatement("UPDATE GYM_TRAINER SET LOGIN_PW = ? WHERE LOGIN_ID = ?")){
		
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
	public Trainer findByTrainer_num(int trainer_num) {
		Trainer trainer = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT LOGIN_ID FROM GYM_TRAINER WHERE TRAINER_NUM = ?")) {
		
		pStatement.setInt(1, trainer_num);	
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
			trainer = new Trainer();
				
			trainer.setLogin_id(rs.getString("login_id"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return trainer;
	}
}