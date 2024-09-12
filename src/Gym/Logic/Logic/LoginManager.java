package Gym.Logic.Logic;

import Gym.Logic.Common.Input;
import 민국.LoginData;

public class LoginManager {
    private static LoginManager instance = null;

    private LoginManager(){}

    public static LoginManager getInstance()
    {
        if(instance == null)
            instance = new LoginManager();
        return instance;
    }


    private LoginData currentLoginUser;
    private boolean isLogin = false;

    public void init()
    {
        currentLoginUser = null;
        isLogin = false;
    }

    public void tryMemberLogin()
    {
        System.out.println("아이디를 입력 해주세요");
        String id = Input.stringScan();
        System.out.println("비밀번호를 입력 해주세요");
        String pw = Input.stringScan();
    }

    public void tryTrainerLogin()
    {

    }

    public void tryManagerLogin()
    {

    }

    public void tryLogin(LoginData.MEMBERTYPE type, String login_Id, String login_pw)
    {

    }


}
