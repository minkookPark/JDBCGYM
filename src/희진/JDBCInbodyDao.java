package 희진;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCInbodyDao implements InbodyDao {
	
	@Override
	public boolean insert(Inbody inbody) {
		boolean result = false;

		String sql = "INSERT INTO " + "INBODY(M_DATE, WEIGHT, HEIGHT, FAT, MUSCLE, BODY_AGE, BODY_SCORE, MEMBER_NUM) "
				+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(sql)) {

			pStatement.setTimestamp(1, inbody.getM_date());
			pStatement.setDouble(2, inbody.getWeight());
			pStatement.setDouble(3, inbody.getHeight());
			pStatement.setDouble(4, inbody.getFat());
			pStatement.setDouble(5, inbody.getMuscle());
			pStatement.setInt(6, inbody.getBody_age());
			pStatement.setInt(7, inbody.getBody_score());
			pStatement.setInt(8, inbody.getMember_num());

			pStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean deleteBybodynum(int Inbody_num) {

		String sql = "DELETE FROM INBODY WHERE INBODY_NUM = ?";

		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(sql)) {

			pStatement.setInt(1, Inbody_num);

			int rows = pStatement.executeUpdate();
			return rows > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Inbody> findAll() {

		List<Inbody> inbodys = new ArrayList<>();
		String sql = "SELECT * FROM INBODY ORDER BY INBODY_NUM DESC";

		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(sql);
				ResultSet rs = pStatement.executeQuery()) {

			while (rs.next()) {
				Inbody inbody = new Inbody();
				inbody.setInbody_Num(rs.getInt("inbody_num"));
				inbody.setM_date(rs.getTimestamp("m_date"));
				inbody.setWeight(rs.getDouble("weight"));
				inbody.setHeight(rs.getDouble("height"));
				inbody.setFat(rs.getDouble("fat"));
				inbody.setMuscle(rs.getDouble("muscle"));
				inbody.setBody_age(rs.getInt("body_age"));
				inbody.setBody_score(rs.getInt("body_score"));
				inbody.setMember_num(rs.getInt("member_num"));

				inbodys.add(inbody);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inbodys;
	}

	public Inbody findBybodynum(int Inbody_num) {

		Inbody inbody = null;
		String sql = "SELECT * FROM INBODY WHERE INBODY_NUM = ?";

		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(sql)) {

			pStatement.setInt(1, Inbody_num);

			try (ResultSet rs = pStatement.executeQuery()) {

				if (rs.next()) {
					inbody = new Inbody();
					inbody.setInbody_Num(rs.getInt("Inbody_Num"));
					inbody.setM_date(rs.getTimestamp("M_date"));
					inbody.setWeight(rs.getDouble("Weight"));
					inbody.setHeight(rs.getDouble("Height"));
					inbody.setFat(rs.getDouble("Fat"));
					inbody.setMuscle(rs.getDouble("Muscle"));
					inbody.setBody_age(rs.getInt("Body_age"));
					inbody.setBody_score(rs.getInt("Body_score"));
					inbody.setMember_num(rs.getInt("Member_num"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		return inbody;
	}
	}
