package 진욱;

public class Class_listTest {
    public static void main(String[] args) {
        Class_listDao cDao = new JDBCClass_listDao();
        for (Class_list c: cDao.findAll()){
            System.out.println(c);
        }
    }


}
