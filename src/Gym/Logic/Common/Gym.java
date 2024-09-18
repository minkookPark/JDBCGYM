package Gym.Logic.Common;

import Gym.Logic.Logic.LoginManager;
import Gym.Logic.Logic.ShowManager;

public class Gym
{
    boolean loop = true;


    public void run()
    {
        while(loop)
        {
            mainPage();
        }
    }


    private void mainPage()
    {
        ShowManager.getInstance().showMainScreen();

        int selectNum = Input.intScan(1,3);

        int loginResult = 0;
        //System.out.println(loginResult);
        switch (selectNum)
        {
            case 1:
            {
                loginResult = LoginManager.getInstance().selectLogin();

                switch(loginResult)
                {
                    case 1:
                    {
                        //멤버 로그인 성공시
                        break;
                    }

                    case 2:
                    {
                        //트레이너 로그인 성공시
                        trainerMainPage();
                        break;
                    }

                    case 3:
                    {
                        break;
                    }
                }

                break;
            }
            case 2:
            {

                //openCharge List
                break;
            }
            case 3:
            {
                //Join
                selectJoinPage();
                break;
            }
        }
    }

    //Join---------------------------------------------

    private void selectJoinPage()
    {
        ShowManager.getInstance().showJoinMenu();

        int selectNum = Input.intScan(1,3);

        int joinResult = 0;

        switch(selectNum)
        {
            case 1:
            {
                memberJoinPage();
                break;
            }
            case 2:
            {
                trainerJoinPage();
                break;
            }
            case 3:
            {
                adminJoinPage();
                break;
            }
        }

    }

    private void trainerJoinPage()
    {
        ShowManager.getInstance().showTrainerJoin();
    }

    private void memberJoinPage()
    {
        ShowManager.getInstance().showMemberJoin();
    }

    private void adminJoinPage()
    {
        ShowManager.getInstance().showAdminJoin();
    }

    //로그인 ------------------------------------------------

//    private void selectLoginPage()
//    {
//        ShowManager.getInstance().showLoginMenu();
//        int selectNum = Input.intScan(1,3);
//
//        switch(selectNum)
//        {
//            case 1:
//            {
//                memberLoginPage();
//                break;
//            }
//            case 2:
//            {
//                trainerLoginPage();
//                break;
//            }
//            case 3:
//            {
//                adminLoginPage();
//                break;
//            }
//        }
//    }

//    private void trainerLoginPage()
//    {
//        ShowManager.getInstance().showTrainerLogin();
//        LoginManager.getInstance().tryTrainerLogin();
//    }

    private void memberLoginPage()
    {
        ShowManager.getInstance().showMemberLogin();
    }

    private void adminLoginPage()
    {
        ShowManager.getInstance().showAdminLogin();
    }



    //Charge View
    private void displayChargePage()
    {

    }


    //Page that arrives upon successful login of Trainer
    private void trainerMainPage()
    {
        System.out.println("트레이너 로그인 성공");

        String a = Input.stringScan();
    }

    //Page that arrives upon successful login of Member
    private void memberMainPage()
    {

    }

    //Page that arrives upon successful login of Admin
    private void adminMainPage()
    {

    }



}
