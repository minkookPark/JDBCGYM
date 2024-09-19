package Gym.Logic.Common;

import Gym.Logic.Logic.DAOManager;
import Gym.Logic.Logic.JoinManager;
import Gym.Logic.Logic.LoginManager;
import Gym.Logic.Logic.ShowManager;
import 민국.Trainer;
import 진욱.Gym_Lesson;
import 하성.Charge;
import 호영.Gym_Member;
import 호영.Gym_MemberMain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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

        int loginResult;
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
                        memberMainPage();
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
                System.out.println("===== GYM 요금표 =====");
                for (Charge c : DAOManager.getInstance().getcDao().findAll()){
                    System.out.println(c);
                }
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


        switch(selectNum)
        {
            case 1:
            {
                memberJoinPage();
                if(JoinManager.getInstance().memberJoin())
                {
                    System.out.println("가입 성공");
                }
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
        JoinManager.getInstance().tryTraninerJoin();
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






    //Page that arrives upon successful login of Trainer
    private void trainerMainPage()
    {
        System.out.println("트레이너 로그인 성공");


        ShowManager.getInstance().showTrainerMenu();

        int selectNum = Input.intScan();
        switch(selectNum)
        {
            //lesson
            case 1:
            {
                trainerLessonMenu();
                break;
            }

            //award
            case 2:
            {
                break;
            }

            //change password
            case 7:
            {
                break;
            }

            //logout
            case 8:
            {
                break;
            }

            //without
            case 9:
            {
                break;
            }

            default :
            {
                System.out.println("잘못된 입력입니다.");
                break;
            }
        }
    }

    private void trainerLessonMenu()
    {
        ShowManager.getInstance().showTrainerLessonMenu();

        int selectNum = Input.intScan();
        switch (selectNum)
        {
            //create new lesson
            case 1:
            {
                CreateLesson();

                break;
            }

            //display my lesson
            case 2:
            {
                break;
            }

            //close my lesson
            case 3:
            {
                break;
            }

            //back to menu
            case 9:
            {
                break;
            }

            default:
            {
                System.out.println("잘못된 입력");
                break;
            }
        }
    }

    private void CreateLesson()
    {
        System.out.println("새로운 클래스를 등록 합니다.");
        System.out.println("클래스의 내용을 입력 해주세요 : ");

        String inputDetail = Input.stringScan();

        System.out.println("날짜를 입력해주세요");


        Timestamp ts = Input.inputTimestamp();

        DAOManager.getInstance().getlDao().createLesson(
                new Gym_Lesson(inputDetail,
                        ts, LoginManager.getInstance().getCurrentTrainer()));

        //(String class_detail, Timestamp progress_time, Trainer trainer)


    }


    //Page that arrives upon successful login of Member
    private void memberMainPage()
    {
        Gym_MemberMain gMain = new Gym_MemberMain();
        gMain.execute(); // 멤버 Main 프로그램 실행으로 이동.
    }




}
