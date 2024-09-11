package 진욱;

import java.util.List;

public interface ClassDao {
    public List<_Class> findAll();
    public int insertClass(_Class classList);
    public int updateClass (_Class classList);
    public int deleteClass (int class_num);

}
