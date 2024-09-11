package 진욱;

import 호영.Gym_Member;

public class ClassTest {
    public static void main(String[] args) {
        Gym_LessonDao cDao = new JDBCGymLessonDao();
        for (Gym_Lesson c: cDao.findAll()){
            System.out.println(c);
        }

        Gym_Lesson insertClass = new Gym_Lesson();
        insertClass.setClass_detail("하반신 집중단련 프로그램");
        insertClass.setMember(new Gym_Member(5, "최민식"));
        insertClass.setTrainer(new Trainer(3, "박민국"));
        System.out.println(cDao.insertClass(insertClass) + "건 입력이 완료되었습니다. 입력정보:" + insertClass);

        Gym_Lesson updateClass = insertClass;
        updateClass.setClass_detail("하반신 초집중단련 프로그램");
        updateClass.setMember(new Gym_Member(4, "박소연"));
        updateClass.setTrainer(new Trainer(4, "박호영"));
        System.out.println(cDao.updateClass(updateClass) + "건 데이터가 변경되었습니다. 변경된 정보:" + updateClass);

        System.out.println(cDao.deleteClass(10) + "건 삭제가 완료되었습니다.");


    }


}
