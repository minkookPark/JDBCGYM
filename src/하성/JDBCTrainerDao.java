package space.jdbc.gym;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import space.jdbc.member1.Customer1;
import space.jdbc.memo.DataSource;

public class JDBCTrainerDao implements TrainerInterface {

	@Override
	public boolean insert(Admin admin) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
					= connection.prepareStatement("INSERT INTO ADMIN (MANAGER_NUM,POSITION)"
							+ " VALUES (?, ?)")) {
			
			pStatement.setLong(1, admin.getManager_num());
			pStatement.setString(2, admin.getPosition());
			
			int rows = pStatement.executeUpdate();
			
			if(rows > 0) {
				result = true;
			}
			
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Admin> findAll() {
		List<Admin> admin = new ArrayList<Admin>();
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM ADMIN ORDER BY ID DESC FETCH FIRST 2 ROWS ONLY");
		ResultSet rs = pStatement.executeQuery()) {
		
		while(rs.next()) {
			Admin admin2 = new Admin(
					rs.getLong("manager_num"),
					rs.getString("position"));
			
			admin.add(admin2);
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public Admin findById(Long num) {
		Admin admin  = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM ADMIN WHERE MANAGER_NUM = ?")
		) {
		
		pStatement.setLong(1, 10);	
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
			admin = new Admin();
				
			admin.setManager_num(num);
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public boolean update(Charge_List charge_list) {
		boolean result = false;
		
		try(Connection conn = DataSource.getDataSource();
			PreparedStatement pStatement
			= conn.prepareStatement("UPDATE CHARGE_LIST SET PERIOD = ? , PT_COUNT = ? WHERE CHARGE_NUM = ?")){
		
			pStatement.setDate(1, charge_list.getPeriod());
			pStatement.setInt(2, charge_list.getPt_count());
			pStatement.setInt(3, charge_list.getCharge_num());
			
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
	public boolean deleteById(Long num) {
		boolean result = false;

		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement
					= connection.prepareStatement("DELETE FROM CHARGE_LIST WHERE CHARGE_NUM = ?")){
			
			pStatement.setLong(1, 5234);
			
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
	public Charge_List findById(int num) {
		Charge_List charge_list  = null;
		
		try (Connection connection = DataSource.getDataSource();
		PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM CHARGE_LIST WHERE CHARGE_NUM = ?")
		) {
		
		pStatement.setLong(1, 140);	
		ResultSet rs = pStatement.executeQuery();
		
		if(rs.next()) {
			charge_list = new Charge_List();
				
			charge_list.setCharge_num(num);
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return charge_list;
	}

	@Override
	public boolean insert(Charge_List charge_list) {
		boolean result = false;
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement 
					= connection.prepareStatement("INSERT INTO CHARGE_LIST (CHARGE_NUM,PERIOD,PT_COUNT)"
							+ " VALUES (?, ?, ?)")) {
			
			pStatement.setInt(1, charge_list.getCharge_num());
			pStatement.setDate(2, charge_list.getPeriod());
			pStatement.setInt(3, charge_list.getPt_count());
			
			int rows = pStatement.executeUpdate();
			
			if(rows > 0) {
				result = true;
			}
			
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean update(Admin admin) {
boolean result = false;
		
		try(Connection conn = DataSource.getDataSource();
			PreparedStatement pStatement
			= conn.prepareStatement("UPDATE ADMIN SET MANAGER_NUM = ? , POSITION = ? WHERE CHARGE_NUM = ?")){
		
			pStatement.setLong(1, admin.getManager_num());
			pStatement.setString(2, admin.getPosition());
			
			int affectedRows = pStatement.executeUpdate();
				
			if(affectedRows > 0) {
				result = true;
			}
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return result;
	}
	
}
