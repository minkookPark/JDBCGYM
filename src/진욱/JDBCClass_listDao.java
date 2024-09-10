package 진욱;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCClass_listDao implements Class_listDao {

    @Override
    public List<Class_list> findAll() {
        List<Class_list> allList = new ArrayList<>();
        String sql = "SELECT A.*, B.NAME trainer_name, C.NAME member_name\n" +
                "    FROM CLASS_LIST A\n" +
                "    JOIN GYM_TRAINER B ON A.TRAINER_NUM = B.TRAINER_NUM\n" +
                "    JOIN GYM_MEMBER C ON A.MEMBER_NUM = C.MEMBER_NUM";

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int class_num = rs.getInt("class_num");
                String class_detail = rs.getString("class_detail");
                Timestamp prog_time = rs.getTimestamp("prog_time");
                int trainer_num = rs.getInt("trainer_num");
                int member_num = rs.getInt("member_num");
                String trainer_name = rs.getString("trainer_name");
                String member_name = rs.getString("member_name");
                allList.add(new Class_list(class_num, class_detail, prog_time, new Trainer(trainer_num, trainer_name), new Member(member_num, member_name)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return allList;
    }
}
