package 진욱;

import java.util.List;

public interface Gym_LessonDao {
    public List<Gym_Lesson> findAll();
    public List<Gym_Lesson> findByTrainer(int number); // 특정 트레이너의 수업을 출력함.
    public int insertLesson(Gym_Lesson classList);
    public int updateLesson (Gym_Lesson classList);
    public int deleteLesson (int class_num);
    public Gym_Lesson getALesson (int class_num);
}
