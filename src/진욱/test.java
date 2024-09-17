package 진욱;

import Gym.Logic.Logic.LoginManager;
import 호영.Gym_MemberMain;

public class test {
    public static void main(String[] args) {
        // ReviewMain m = new ReviewMain();
        // m.reviewExecute();

        //Gym_LessonMain m = new Gym_LessonMain();
        //m.lessonExecute();

//        Gym_MemberMain gmMain = new Gym_MemberMain();
//        gmMain.execute();

        LoginManager.getInstance().tryMemberLogin();
    }
}
