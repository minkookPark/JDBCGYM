package 진욱;

import Gym.Logic.Common.Input;

public class LessonMain {
    public static void main(String[] args) {
        Gym_LessonDao gDao = new JDBCGymLessonDao();

    }

    public void lessonExecute(){
        System.out.println("수업 메뉴에서 원하는 기능을 선택해주세요.");
        boolean loop = true;
        while (loop){
            System.out.println("1. 전체 수업 출력 / 2. 특정 트레이너의 수업 출력 / 3.　수업 내용 수정 / 4. 수업 내용 삭제 / 5. 초기 화면으로");
            int select = Input.intScan();
            switch (select){
                case 1:
                    System.out.println("전체 수업 내용을 출력합니다.");

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("초기 화면으로 돌아갑니다.");
                    loop = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}
