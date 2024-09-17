package Gym.Logic.Common;

import Gym.Logic.Logic.ShowManager;

public class Gym
{
    public void run()
    {
        boolean loop = true;

        while(loop)
        {
            mainPage();
        }
    }


    private void mainPage()
    {
        ShowManager.getInstance().showMainScreen();

        int selectNum = Input.intScan(1,3);

        switch (selectNum)
        {
            case 1:
            {
                selectLoginPage();
                break;
            }
            case 2:
            {
                break;
            }
            case 3:
            {
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

    private void selectLoginPage()
    {
        ShowManager.getInstance().showLoginMenu();
        int selectNum = Input.intScan(1,3);

        switch(selectNum)
        {
            case 1:
            {
                memberLoginPage();
                break;
            }
            case 2:
            {
                trainerLoginPage();
                break;
            }
            case 3:
            {
                adminLoginPage();
                break;
            }
        }
    }

    private void trainerLoginPage()
    {
        ShowManager.getInstance().showTrainerLogin();
    }

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




}
