package 진욱;

import Gym.Logic.Common.Input;
import Gym.Logic.Logic.DAOManager;
import Gym.Logic.Logic.ShowManager;
import 호영.Gym_Member;
import 호영.Gym_MemberDao;

import java.util.List;

public class ReviewMain {

    ReviewDao reviewDao = DAOManager.getInstance().getrDao();
    Gym_LessonDao gDao = DAOManager.getInstance().getlDao();
    Gym_MemberDao mDao = DAOManager.getInstance().getmDao();

    public void reviewExecute(){
        System.out.println("리뷰 메뉴에서 원하는 기능을 선택해주세요.");
        boolean loop = true;
        while (loop){
            ShowManager.getInstance().showReviewMenu();
            int select = Input.intScan();
            switch (select){
                case 1:
                    showAllReview();
                    break;

                case 2:
                    writeReview();
                    break;

                case 3:
                    updateReview(mDao.findByMember_Num(3), 1); // 이후 로그인한 사람의 번호를 가져오는 방법으로 수정한다.
                    break;

                case 4:
                    updateReview(mDao.findByMember_Num(3), 2); // 이후 로그인한 사람의 번호를 가져오는 방법으로 수정한다.
                    break;

                case 9:
                    System.out.println("리뷰 관련 메뉴 출력을 종료합니다.");
                    loop = false;
                    break;

                default:
                    System.out.println("잘못 입력하셨습니다. 다시 한번 입력해주세요.");
                    break;
            }
        }

    }


    public void showAllReview(){
        System.out.println("전체 리뷰를 출력합니다.");
        System.out.println("총 리뷰 건수 : " + reviewDao.allReviewCount());
        System.out.println("=============== 리뷰 목록 ===============");
        for (Review r: reviewDao.allReviewList()){
            System.out.println(r);
        }

        System.out.println("========================================\n");
    }

    public void writeReview(){
        System.out.println("리뷰 작성을 선택하셨습니다.");
        for (Gym_Lesson g: gDao.findAll()){
            System.out.println(g);
        }

        System.out.println("리뷰를 작성할 수업의 번호를 선택해주세요.");
        int number = Input.intScan();
        Gym_Lesson toReviewLesson = gDao.getALesson(number);

        System.out.println("수업 평점을 선택해주세요! (1~5점 사이 정수입력)");
        int score = Input.intScan();
        System.out.println("리뷰 제목을 입력해주세요.");
        String title = Input.stringScan();
        System.out.println("리뷰 내용을 입력해주세요.");
        String content = Input.stringScan();
        Review toWriteReview = new Review(score, title, content, number);
        reviewDao.insertReview(toWriteReview);
        System.out.println("리뷰 작성이 완료되었습니다!");
    }

    public void updateReview(Gym_Member member, int method){

        System.out.println("리뷰 수정을 선택하셨습니다. 회원님이 작성한 리뷰 리스트를 불러옵니다.");
        List<Review> userReview = reviewDao.searchReview(1, member.getName());

        if (method == 1) {
            System.out.println("변경할 리뷰의 번호를 입력해주세요.");
            int number = Input.intScan();
            System.out.println("변경할 평점을 입력해주세요. 현재 평점: " + reviewDao.getReview(number).getScore());
            int score = Input.intScan();
            System.out.println("수정할 제목을 작성해주세요. 아무것도 입력하지 않으면 기존 제목이 반영됩니다.");
            String title = Input.stringScan();
            if (title.isEmpty())
                title = reviewDao.getReview(number).getTitle();
            System.out.println("수정할 내용을 작성해주세요. 아무것도 입력하지 않으면 기존 내용이 반영됩니다.");
            String content = Input.stringScan();
            if (content.isEmpty())
                content = reviewDao.getReview(number).getContent();

            reviewDao.updateReview(new Review(score, title, content, number));
            System.out.println("수정이 완료되었습니다!!");

        } else if (method == 2) {
            deleteView();
        } else {
            System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.");
        }
    }

    public void deleteView(){
        System.out.println("삭제할 리뷰의 번호를 입력해주세요..");
        int number = Input.intScan();
        reviewDao.deleteReview(number);
        System.out.println("리뷰 삭제가 완료되었습니다!");

    }
}
