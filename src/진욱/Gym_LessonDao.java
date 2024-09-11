package 진욱;

import java.util.List;

public interface Gym_LessonDao {
    public List<Gym_Lesson> findAll();
    public int insertClass(Gym_Lesson classList);
    public int updateClass (Gym_Lesson classList);
    public int deleteClass (int class_num);

}
