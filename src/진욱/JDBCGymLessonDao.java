package 진욱;

import DataSource.DataSource;
import Gym.Logic.Common.Gym;
import 민국.Trainer;
import 호영.Gym_Member;

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
                "    JOIN GYM_MEMBER C ON A.MEMBER_NUM = C.MEMBER_NUM ORDER BY A.CLASS_NUM";

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
                allList.add(new Gym_Lesson(class_num, class_detail, prog_time, new Trainer(trainer_num, trainer_name), new Gym_Member(member_num, member_name)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return allList;
    }

    public List<Gym_Lesson> findByTrainer(int number){
        List<Gym_Lesson> trainerLesson = new ArrayList<Gym_Lesson>();
        String sql = "SELECT A.*, B.NAME trainer_name, C.NAME member_name\n" +
                "                FROM CLASS_LIST A\n" +
                "                JOIN GYM_TRAINER B ON A.TRAINER_NUM = B.TRAINER_NUM\n" +
                "                JOIN GYM_MEMBER C ON A.MEMBER_NUM = C.MEMBER_NUM \n" +
                "                WHERE B.TRAINER_NUM = ?\n" +
                "                ORDER BY A.CLASS_NUM";

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, number);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int class_num = rs.getInt("class_num");
                String class_detail = rs.getString("class_detail");
                Timestamp prog_time = rs.getTimestamp("prog_time");
                int trainer_num = rs.getInt("trainer_num");
                int member_num = rs.getInt("member_num");
                String trainer_name = rs.getString("trainer_name");
                String member_name = rs.getString("member_name");
                trainerLesson.add(new Gym_Lesson(class_num, class_detail, prog_time, new Trainer(trainer_num, trainer_name), new Gym_Member(member_num, member_name)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return trainerLesson;
    }

    @Override
    public List<Gym_Lesson> findByMember_loginId(String login_id) {
        List<Gym_Lesson> membersLessonList = new ArrayList<>();
        String sql = "SELECT A.*, B.NAME trainer_name, C.NAME member_name, C.login_id member_id\n" +
                "                FROM CLASS_LIST A\n" +
                "                JOIN GYM_TRAINER B ON A.TRAINER_NUM = B.TRAINER_NUM\n" +
                "                JOIN GYM_MEMBER C ON A.MEMBER_NUM = C.MEMBER_NUM   \n" +
                "                WHERE C.LOGIN_ID = ? \n" +
                "                ORDER BY A.CLASS_NUM;";

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, login_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                membersLessonList.add(new Gym_Lesson(rs.getInt("CLASS_NUM"),
                        rs.getString("CLASS_DETAIL"),
                        rs.getTimestamp("PROG_TIME"),
                        new Trainer(rs.getInt("TRAINER_NUM"), rs.getString("TRAINER_NAME")),
                        new Gym_Member(rs.getInt("MEMBER_NUM"), rs.getString("MEMBER_NAME"), rs.getString("MEMBER_ID"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return membersLessonList;
    }

    public Gym_Lesson getALesson(int lessonNumber){ // Review에서 숫자를 입력했을 때, 해당하는 Lesson 객체를 반환함.
        Gym_Lesson lesson = null;
        String sql = "SELECT A.*, B.NAME trainer_name, C.NAME member_name\n" +
                "       FROM CLASS_LIST A\n" +
                "       JOIN GYM_TRAINER B ON A.TRAINER_NUM = B.TRAINER_NUM\n" +
                "       JOIN GYM_MEMBER C ON A.MEMBER_NUM = C.MEMBER_NUM\n" +
                "       WHERE CLASS_NUM = ?";


        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, lessonNumber);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()){
                    int class_num = rs.getInt("class_num");
                    String class_detail = rs.getString("class_detail");
                    Timestamp prog_time = rs.getTimestamp("prog_time");
                    int trainer_num = rs.getInt("trainer_num");
                    int member_num = rs.getInt("member_num");
                    String trainer_name = rs.getString("trainer_name");
                    String member_name = rs.getString("member_name");
                    lesson = new Gym_Lesson(class_num, class_detail, prog_time, new Trainer(trainer_num, trainer_name), new Gym_Member(member_num, member_name));
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lesson;
    }

    @Override
    public int insertLesson(Gym_Lesson classList) {
        int result = 0;
        String sql = "INSERT INTO CLASS_LIST (CLASS_NUM, CLASS_DETAIL, PROG_TIME, TRAINER_NUM, MEMBER_NUM) \n" +
                "VALUES (?, ?, SYSTIMESTAMP, ?, ?)";
        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, classList.getClass_num());
                pstmt.setString(2, classList.getClass_detail());
                pstmt.setInt(3, classList.getTrainer().getTrainer_num());
                pstmt.setInt(4, classList.getMember().getMember_num());
                result = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public int updateLesson(Gym_Lesson classList) { // 수업 내용의 상세 / 회원 / 트레이너 정보를 변경 가능.
        int result = 0;
        String sql = "update class_list set class_detail = ?,\n" +
                "    trainer_num = ?,\n" +
                "    member_num = ?  \n" +
                "    where class_num = ?";
        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, classList.getClass_detail());
            pstmt.setInt(2, classList.getTrainer().getTrainer_num());
            pstmt.setInt(3, classList.getMember().getMember_num());
            pstmt.setInt(4, classList.getClass_num());
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int deleteLesson(int class_num){
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

    @Override
    public int deleteLessonByMemberNum(int member_num) {
        int result = 0;
        String sql = "DELETE FROM CLASS_LIST WHERE MEMBER_NUM = ?";

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, member_num);
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
