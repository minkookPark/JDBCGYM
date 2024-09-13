package 진욱;

import DataSource.DataSource;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCReviewDao implements ReviewDao {
    @Override
    public List<Review> allReviewList() { // 전체 리뷰 리스트를 출력한다.
        List<Review> allList = new ArrayList<Review>();

        String sql = "SELECT A.*, B.class_detail, C.name \n" +
                "FROM REVIEW A JOIN CLASS_LIST B ON A.class_num = B.class_num \n" +
                "JOIN GYM_MEMBER C ON B.member_num = C.member_num";

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()){
                    int review_num = rs.getInt("review_num");
                    int score = rs.getInt("score");
                    String title = rs.getString("title");
                    String content = rs.getString("content");
                    Timestamp write_date = rs.getTimestamp("write_date");
                    int class_num = rs.getInt("class_num");
                    String class_detail = rs.getString("class_detail");
                    String name = rs.getString("name");

                    allList.add(new Review(review_num, score, title, content, write_date, class_num, class_detail, name));
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allList;
    }

    @Override
    public int allReviewCount() {
        int count = 0;
        String sql = "SELECT COUNT(*) count FROM REVIEW";
        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("count");
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    @Override
    public List<Review> searchReview(int method, String query) { // 검색 방법에 따라 다른 검색 결과를 출력한다.
        List<Review> searchList = new ArrayList<Review>();
        String sql = "";
        Connection conn = DataSource.getDataSource();
        PreparedStatement pstmt = null;
        switch (method) { // 1. 글쓴이로 검색 2. 제목으로 검색 3. 내용으로 검색
            case 1:
                sql = "SELECT A.*, B.class_detail, C.name \n" +
                        "FROM REVIEW A \n" +
                        "JOIN CLASS_LIST B ON A.class_num = B.class_num \n" +
                        "JOIN GYM_MEMBER C ON B.member_num = C.member_num \n" +
                        "WHERE C.name like ?";
                break;
            case 2:
                sql = "SELECT A.*, B.class_detail, C.name \n" +
                        "FROM REVIEW A \n" +
                        "JOIN CLASS_LIST B ON A.class_num = B.class_num \n" +
                        "JOIN GYM_MEMBER C ON B.member_num = C.member_num \n" +
                        "WHERE A.title like ?";
                break;

            case 3:
                sql = "SELECT A.*, B.class_detail, C.name \n" +
                        "FROM REVIEW A \n" +
                        "JOIN CLASS_LIST B ON A.class_num = B.class_num \n" +
                        "JOIN GYM_MEMBER C ON B.member_num = C.member_num \n" +
                        "WHERE A.content like ?";
                break;
        }
                try {
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, "%"+ query +"%");
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()){
                        int review_num = rs.getInt("review_num");
                        int score = rs.getInt("score");
                        String title = rs.getString("title");
                        String content = rs.getString("content");
                        Timestamp write_date = rs.getTimestamp("write_date");
                        int class_num = rs.getInt("class_num");
                        String class_detail = rs.getString("class_detail");
                        String name = rs.getString("name");

                        searchList.add(new Review(review_num, score, title, content, write_date, class_num, class_detail, name));
                    }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        return searchList;
    }


    @Override
    public int insertReview(Review review) {
        int result = 0;
        String sql = "INSERT INTO REVIEW (SCORE, TITLE, CONTENT, CLASS_NUM, WRITE_DATE) \n" +
                "VALUES (?, ?, ?, ?, SYSTIMESTAMP)";

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, review.getScore());
            pstmt.setString(2, review.getTitle());
            pstmt.setString(3, review.getContent());
            pstmt.setInt(4, review.getClass_num());
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int updateReview(Review review) {
        int result = 0;
        String sql = "update review set \n" +
                "    score = ?, \n" +
                "    title = ?, \n" +
                "    content = ? \n" +
                "    where review_num =?";

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, review.getScore());
            pstmt.setString(2, review.getTitle());
            pstmt.setString(3, review.getContent());
            pstmt.setInt(4, review.getClass_num());
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;


    }

    @Override
    public int deleteReview(int review_num) {
        int result = 0;
        String sql = "delete from review where review_num = ?";

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, review_num);
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public int deleteReviewByClassNumber(int class_num){
        int result = 0;
        String sql = "DELETE FROM REVIEW WHERE CLASS_NUM = ?";
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
    public Review getReview(int review_num) {
        Review oneReview = null;
        String sql = "SELECT * FROM REVIEW WHERE REVIEW_NUM = ?";
        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, review_num);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                oneReview = new Review(rs.getInt("review_num"), rs.getInt("score"),
                        rs.getString("title"), rs.getString("content"), rs.getTimestamp("write_date"), rs.getInt("class_num"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return oneReview;
    }

    public void displayTrainerReviewScore(String name){
        String sql = "SELECT \n" +
                "        COUNT(A.SCORE) AS TOTAL, \n" +
                "        AVG(A.SCORE) AS AVERAGES \n" +
                "    FROM \n" +
                "        REVIEW A \n" +
                "        JOIN CLASS_LIST B ON A.CLASS_NUM = B.CLASS_NUM \n" +
                "        JOIN GYM_TRAINER C ON B.TRAINER_NUM = C.TRAINER_NUM \n" +
                "    WHERE\n" +
                "        C.NAME = ?";
        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setString(1, name);
             ResultSet rs = pstmt.executeQuery();
             if (rs.next()){
                 System.out.println("검색하신 " + name + " 트레이너의 평균 점수: " + rs.getDouble("AVERAGES") + "점, 총 평가인원 : " + rs.getInt("TOTAL") + "명");
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
