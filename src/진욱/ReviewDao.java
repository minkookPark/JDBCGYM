package 진욱;

import java.util.List;

public interface ReviewDao {
    public List<Review> allReviewList();

    public int insertReview(Review review);

    public int updateReview(Review review);

    public int deleteReview(int review_num);

    public List<Review> searchReview(int method, String query);
}
