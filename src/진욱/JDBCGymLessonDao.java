package 진욱;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCGymLessonDao implements Gym_LessonDao {
    @Override
    public List<Gym_Lesson> findAll() {
        List<Gym_Lesson> allList = new ArrayList<>();
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
                allList.add(new Gym_Lesson(class_num, class_detail, prog_time, new Trainer(trainer_num, trainer_name), new Member(member_num, member_name)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return allList;
    }

    @Override
    public int insertClass(Gym_Lesson classList) {
        int result = 0;
        String sql = "INSERT INTO CLASS_LIST (CLASS_DETAIL, PROG_TIME, TRAINER_NUM, MEMBER_NUM) \n" +
                "VALUES (?, SYSTIMESTAMP, ?, ?)";
        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, classList.getClass_detail());
                pstmt.setInt(2, classList.getTrainer().getTrainer_num());
                pstmt.setInt(3, classList.getMember().getMember_num());
                result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int updateClass(Gym_Lesson classList) { // 수업 내용의 상세 / 회원 / 트레이너 정보를 변경 가능.
        int result = 0;
        String sql = "update class_list set class_detail = ?,\n" +
                "    trainer_num = (select trainer_num from gym_trainer where name = ?),\n" +
                "    member_num = (select member_num from gym_member where name = ?)    \n" +
                "    where member_num = ?";
        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, classList.getClass_detail());
            pstmt.setString(2, classList.getTrainer().getName());
            pstmt.setString(3, classList.getMember().getName());
            pstmt.setInt(4, classList.getMember().getMember_num());
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int deleteClass(int class_num){
        int result = 0;
        String sql = "DELETE FROM CLASS_LIST WHERE CLASS_NUM = ?";

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, class_num);
                result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
