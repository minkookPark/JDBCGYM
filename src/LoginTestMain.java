import Gym.Logic.Common.Input;
import Gym.Logic.Logic.LoginManager;
import Gym.Logic.Logic.ShowManager;
import 민국.LoginData;

public class LoginTestMain {
    public static void main(String[] args) {

        ShowManager.getInstance().showMainScreen();

        String select = Input.stringScan();

        switch(select)
        {
            case "1":
            {
                LoginManager.getInstance().tryTrainerLogin();
                break;
            }
            case "2":
            {
                //호영이가 만들어야 함.
                LoginManager.getInstance().tryMemberLogin();
                break;
            }
            case "3":
            {
                LoginManager.getInstance().tryJoin();
                break;
            }
        }

        LoginManager.getInstance().tryTrainerLogin();
    }

}
