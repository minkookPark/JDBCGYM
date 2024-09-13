package Gym.Logic.Logic;

import Gym.Logic.Common.Input;
import 민국.JDBCTrainerDao;
import 민국.LoginData;
import 민국.Trainer;
import 하성.Admin;
import 호영.Gym_Member;

public class LoginManager {
    private static LoginManager instance = null;

    private LoginManager(){
        init();
    }

    public static LoginManager getInstance()
    {
        if(instance == null)
            instance = new LoginManager();
        return instance;
    }


    private LoginData currentLoginUser;
    private Trainer tr;
    private Gym_Member gm;
    private Admin admin;

    private boolean isLogin = false;

    public void init()
    {
        currentLoginUser = new LoginData();
        isLogin = false;
    }


    public void selectLogin()
    {
        ShowManager.getInstance().showLoginMenu();

        int selectNum = Input.intScan(1,3);
        if (selectNum != 0)
        {
            switch(selectNum)
            {
                case 1:
                {
                    tryMemberLogin();
                    break;
                }
                case 2:
                {
                    tryTrainerLogin();
                    break;
                }
                case 3:
                {
                    tryManagerLogin();
                    break;
                }
            }
        }
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
        System.out.println("아이디를 입력 해주세요");
        String id = Input.stringScan();
        System.out.println("비밀번호를 입력 해주세요");
        String pw = Input.stringScan();


        //이 부분 trainer 객체로 바꿔야 함.
        LoginData login = new LoginData(id,pw, LoginData.MEMBERTYPE.TRAINER);
        //Trainer curLoginTrainer = new Trainier();
        JDBCTrainerDao tDao = DAOManager.getInstance().gettDao();

        
        if(tryLogin(login))
        {
            System.out.println("로그인 성공");
            //tr = curLoginTrainer;
            isLogin = true;

        }
        else
        {
            System.out.println("로그인 실패");
        }
    }

    public void tryManagerLogin()
    {

    }

    public void tryLogin(LoginData.MEMBERTYPE type, String login_Id, String login_pw)
    {

    }

    public boolean tryLogin(LoginData loginData)
    {
        boolean result = false;

        JDBCTrainerDao tDao = DAOManager.getInstance().gettDao();

        if(tDao.tryLogin(loginData.getLogin_id(), loginData.getLogin_pw()))
        {
            System.out.println("로그인 성공");
            result = true;
        }
        else
        {
            System.out.println("로그인 실패");
            result = false;
        }

        return result;
    }

    public void setCurrentLoginUser(LoginData loginData)
    {
        currentLoginUser = loginData;
    }

    public void setCurrentLoginUser(LoginData.MEMBERTYPE type, String login_Id, String Login_Pw)
    {

    }

    public LoginData getCurrentLoginUser()
    {
        if(isLogin)
            return this.currentLoginUser;
        else
        {
            System.out.println("로그인 데이터가 없습니다.");
            return null;
        }
    }

    public void logOut()
    {
        currentLoginUser = null;
        isLogin = false;

        init();
    }

}
