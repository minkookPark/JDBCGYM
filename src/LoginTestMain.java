import Gym.Logic.Common.Input;
import Gym.Logic.Logic.LoginManager;
import Gym.Logic.Logic.ShowManager;
import 민국.LoginData;

public class LoginTestMain {
    public static void main(String[] args) {

        String select = Input.stringScan();


        ShowManager.getInstance().showMainScreen();

        switch(select)
        {
            case "1":
            {
                LoginManager.getInstance().tryTrainerLogin();
                break;
            }
            case "2":
            {
                break;
            }
            case "3":
            {
                break;
            }
        }

        LoginManager.getInstance().tryTrainerLogin();
    }

}
