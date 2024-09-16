package Gym.Logic.Logic;

import Gym.Logic.Common.Input;
import 민국.LoginData;

//회원 가입을 전담함.
public class JoinManager {
    private static JoinManager instance = null;
    JoinManager(){}
    public static JoinManager getInstance()
    {
        if (instance == null)
        {
            instance = new JoinManager();
        }
        return instance;
    }

    public boolean tryTraninerJoin()
    {
        //아이디 비밀번호 입력.
        ShowManager.getInstance().idInputform();
        String inputId = Input.stringScan();
        ShowManager.getInstance().pwInputform();
        String inputPw = Input.stringScan();

        ShowManager.getInstance().genderInputform();
        String inputGender = Input.stringScan();

        ShowManager.getInstance().ageIntpuform();
        int inputAge = Input.intScan(1,99);

        ShowManager.getInstance().nameInputform();
        String inputName = Input.stringScan();

        // LoginData(String name, String login_id, String login_pw, String gender, int age, MEMBERTYPE memberType)
        LoginData newLoginData = new LoginData(inputName, inputId, inputPw, inputGender,inputAge, LoginData.MEMBERTYPE.TRAINER);

        DAOManager.getInstance().gettDao().insertTrianerJoin(newLoginData);

        return false;
    }

    public boolean memberJoin()
    {
        return false;
    }

    public boolean adminJoin()
    {
        return false;
    }

}
