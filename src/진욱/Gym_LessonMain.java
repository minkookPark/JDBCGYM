package 진욱;

import Gym.Logic.Common.Input;
import 민국.JDBCTrainerDao;
import 민국.Trainer;
import 민국.TrainerDao;

public class Gym_LessonMain {
    Gym_LessonDao gDao = new JDBCGym_LessonDao();
    TrainerDao tDao = new JDBCTrainerDao();

    public void lessonExecute(){
        System.out.println("수업 메뉴에서 원하는 기능을 선택해주세요.");
        boolean loop = true;
        while (loop){
            System.out.println("1. 전체 수업 출력 / 2. 특정 트레이너의 수업 출력 / 3.　수업 내용 수정 / 4. 수업 내용 삭제 / 5. 초기 화면으로");
            int select = Input.intScan();
            switch (select){
                case 1:
                    System.out.println("전체 수업 내용을 출력합니다.");
                    for (Gym_Lesson gl : gDao.findAll()){
                        System.out.println(gl);
                    }
                    break;

                case 2:
                    findTrainerLesson();
                    break;

                case 3:
                    modifyLessonInfo();
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

    public void findTrainerLesson() {
        System.out.println("수강정보 검색을 원하는 트레이너명을 입력하세요.");
        int number = Input.intScan();
        System.out.println(gDao.findByTrainer(number).get(0).getTrainer().getName() + "트레이너에 대한 수강 정보는 아래와 같습니다.");
        for (Gym_Lesson gl2 : gDao.findByTrainer(number)){
            System.out.println(gl2);
        }
    }

    public void modifyLessonInfo() {
        for (Gym_Lesson gl3: gDao.findAll()){
            System.out.println(gl3);
        }
        System.out.println("수정을 원하는 수강정보의 번호를 입력해주세요.");
        int number = Input.intScan();
        System.out.println("수강 과목명을 입력해주세요. ex) 다이어트 집중 수업");
        String class_detail = Input.stringScan();
        System.out.println("담당 트레이너가 누구인지 선택해주세요. (트레이너 목록 출력)");
        for (Trainer t : tDao.findAll()){
            System.out.println(t);
        }

    }
}
