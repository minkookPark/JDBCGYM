package 진욱;

import java.util.List;

public interface Gym_LessonDao {
    public List<Gym_Lesson> findAll();
    public List<Gym_Lesson> findByTrainer(String name); // 특정 트레이너의 수업을 출력함.
    public int insertClass(Gym_Lesson classList);
    public int updateClass (Gym_Lesson classList);
    public int deleteClass (int class_num);
    public Gym_Lesson getALesson (int class_num);
}
