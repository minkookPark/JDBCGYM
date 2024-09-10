package 진욱;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCReviewDao implements ReviewDao {
    @Override
    public List<Review> allReviewList() { // 전체 리뷰 리스트를 출력한다.
        List<Review> allList = new ArrayList<Review>();

        String sql = "select a.*, b.class_detail, c.name \n" +
                "from review a, class_list b, gym_member c \n" +
                "where a.class_num = b.class_num \n" +
                "and b.member_num = c.member_num";

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
    public List<Review> searchReview(int method, String query) { // 검색 방법에 따라 다른 검색 결과를 출력한다.
        List<Review> searchList = new ArrayList<Review>();
        String sql = "";
        Connection conn = DataSource.getDataSource();
        PreparedStatement pstmt = null;
        switch (method) { // 1. 글쓴이로 검색 2. 제목으로 검색 3. 내용으로 검색
            case 1:
                sql = "select a.*, b.class_detail, c.name \n" +
                        "from review a, class_list b, gym_member c \n" +
                        "where a.class_num = b.class_num \n" +
                        "and b.member_num = c.member_num \n" +
                        "and c.name like ?";
                break;
            case 2:
                sql = "select a.*, b.class_detail, c.name \n" +
                        "from review a, class_list b, gym_member c \n" +
                        "where a.class_num = b.class_num \n" +
                        "and b.member_num = c.member_num \n" +
                        "and a.title like ?";
                break;

            case 3:
                sql = "select a.*, b.class_detail, c.name \n" +
                        "from review a, class_list b, gym_member c \n" +
                        "where a.class_num = b.class_num \n" +
                        "and b.member_num = c.member_num \n" +
                        "and a.content like ?";
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
        String sql = "INSERT INTO REVIEW (SCORE, TITLE, CONTENT, CLASS_NUM) \n" +
                "VALUES (?, ?, ?, ?)";

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

}
