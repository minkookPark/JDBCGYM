package 진욱;

import java.util.Scanner;

public class ReviewMain {

    ReviewDao reviewDao = new JDBCReviewDao();
    Gym_LessonDao gDao = new JDBCGymLessonDao();

    Scanner scanner = new Scanner(System.in);

    public void execute(){
        System.out.println("리뷰 메뉴에서 원하는 기능을 선택해주세요.");
        boolean loop = true;
        while (loop){
            System.out.println("1. 리뷰 전체 출력 / 2. 리뷰 작성 / 3.　리뷰 수정 (본인만 가능) / 4. 리뷰 삭제 / 5. 초기 화면으로");
            String select = scanner.nextLine();

            switch (select){
                case "1":
                    showAllReview();
                    break;

                case "2":
                    writeReview();
                    break;

                case "3":
                    updateReview();
                    break;

                case "4":
                    break;

                case "5":
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
    }

    public void writeReview(){
        System.out.println("리뷰 작성을 선택하셨습니다.");
        System.out.println("우선 리뷰를 작성할 수업의 번호를 선택해주세요.");
        for (Gym_Lesson g: gDao.findAll()){
            System.out.println(g);
        }

        String numberStr = scanner.nextLine();
        int number = Integer.parseInt(numberStr);
        Gym_Lesson toReviewLesson = gDao.getALesson(number);

        System.out.println("수업 평점을 선택해주세요! (1~5점 사이 정수입력)");
        int score = Integer.parseInt(scanner.nextLine());
        System.out.println("리뷰 제목을 입력해주세요.");
        String title = scanner.nextLine();
        System.out.println("리뷰 내용을 입력해주세요.");
        String content = scanner.nextLine();
        Review toWriteReview = new Review(score, title, content, toReviewLesson.getClass_num());
        reviewDao.insertReview(toWriteReview);
        System.out.println("리뷰 작성이 완료되었습니다!");
    }

    public void updateReview(){
        // 로그인 대조 로직을 실행.

    }
}
