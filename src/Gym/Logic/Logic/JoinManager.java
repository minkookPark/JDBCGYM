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
        boolean result = false;
        //아이디 비밀번호 입력.
        ShowManager.getInstance().idInputform();
        String inputId = Input.stringScan();
        ShowManager.getInstance().pwInputform();
        String inputPw = Input.stringScan();

        //성별 입력
        ShowManager.getInstance().genderInputform();
        String inputGender = Input.stringScan();

        //나이 입력 ( 1~99 사이의 정수)
        ShowManager.getInstance().ageIntpuform();
        int inputAge = Input.intScan(1,99);

        //이름 입력
        ShowManager.getInstance().nameInputform();
        String inputName = Input.stringScan();

        //새로 가입할 트레이너의 LoginData 생성.
        LoginData newLoginData = new LoginData(inputName, inputId, inputPw, inputGender,inputAge, LoginData.MEMBERTYPE.TRAINER);

        //Trainer Dao 를 이용하여 쿼리문 삽입. 동시에 1차적 검사.
        if(DAOManager.getInstance().gettDao().insertTrianerJoin(newLoginData))
        {
            ShowManager.getInstance().successJoin();
            result = true;
        }
        else
        {
            ShowManager.getInstance().failedJoin();
            result = false;
        }

        //대표 수상경력 입력 유무 확인 해야 함.

        return result;
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
