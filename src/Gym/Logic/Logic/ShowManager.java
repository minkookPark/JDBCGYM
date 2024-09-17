package Gym.Logic.Logic;

public class ShowManager {

    //별도의 기능을 갖지 않으며 전체적인 출력 폼 통일을 위해 생성.
    private static ShowManager instance = null;
    private ShowManager(){}
    public static ShowManager getInstance()
    {
        if(instance == null)
            instance = new ShowManager();
        return instance;
    }

    public void showMainScreen()
    {
        System.out.println("========================================================");
        System.out.println("=                                                      =");
        System.out.println("=                1. Login                              =");
        System.out.println("=                2. Open Charge List                   =");
        System.out.println("=                3. Join                               =");
        System.out.println("=                                                      =");
        System.out.println("========================================================");
    }

    public void showLoginMenu()
    {
        System.out.println("========================================================");
        System.out.println("=                                                      =");
        System.out.println("=                1. Member Login                       =");
        System.out.println("=                2. Trainer Login                      =");
        System.out.println("=                3. Manager Login                      =");
        System.out.println("=                                                      =");
        System.out.println("========================================================");
    }

    public void showMemberLogin(){
        System.out.println("========================================================");
        System.out.println("=                                                      =");
        System.out.println("=                                                      =");
        System.out.println("=                Member Login                          =");
        System.out.println("=                                                      =");
        System.out.println("=                                                      =");
        System.out.println("========================================================");
    }

    public void showTrainerLogin(){
        System.out.println("========================================================");
        System.out.println("=                                                      =");
        System.out.println("=                                                      =");
        System.out.println("=                Trainer Login                         =");
        System.out.println("=                                                      =");
        System.out.println("=                                                      =");
        System.out.println("========================================================");
    }

    public void showTrainerMenu()
    {
        System.out.println("========================================================");
        System.out.println("=                                                      =");
        System.out.println("=                1. Lesson                             =");
        System.out.println("=                2. Award                              =");
        System.out.println("=------------------------------------------------------=");
        System.out.println("=                                                      =");
        System.out.println("=                7. Change Password                    =");
        System.out.println("=                8. Log out                            =");
        System.out.println("=                9. With Out                           =");
        System.out.println("========================================================");
        numberInputform();
    }


    public void showManagerMenu()
    {
        System.out.println("========================================================");
        System.out.println("=                                                      =");
        System.out.println("=                1. Member Password Initialize         =");
        System.out.println("=                2. Chase out Member                   =");
        System.out.println("=                3. Review                             =");
        System.out.println("=                4. Inbody Data                        =");
        System.out.println("=------------------------------------------------------=");
        System.out.println("=                                                      =");
        System.out.println("=                7. Change Password                    =");
        System.out.println("=                8. Log out                            =");
        System.out.println("=                                                      =");
        System.out.println("========================================================");
        numberInputform();
    }

    public void showChargeList()
    {

    }

    public void showReviewMenu()
    {
        System.out.println("========================================================");
        System.out.println("=                                                      =");
        System.out.println("=                1. Display All Review List            =");
        System.out.println("=                2. Write A Review                     =");
        System.out.println("=                3. Modify A Review                    =");
        System.out.println("=------------------------------------------------------=");
        System.out.println("=                                                      =");
        System.out.println("=                4. Delete A Review                    =");
        System.out.println("=                9. Back To Main                       =");
        System.out.println("=                                                      =");
        System.out.println("========================================================");
        numberInputform();
    }

    public void showLessonMenu()
    {
        System.out.println("========================================================");
        System.out.println("=                                                      =");
        System.out.println("=                1. Display All Lesson List            =");
        System.out.println("=                2. Display Trainer's Lesson           =");
        System.out.println("=                3. Modify A Lesson's Info             =");
        System.out.println("=------------------------------------------------------=");
        System.out.println("=                                                      =");
        System.out.println("=                4. Delete A Lesson Info               =");
        System.out.println("=                9. Back To Main                       =");
        System.out.println("=                                                      =");
        System.out.println("========================================================");
        numberInputform();
    }

    public void showMemberMenu()
    {
        System.out.println("========================================================");
        System.out.println("=                                                      =");
        System.out.println("=                1. Join Member                        =");
        System.out.println("=                2. Modify Member Info                 =");
        System.out.println("=                3. Withdrawal Member                  =");
        System.out.println("=------------------------------------------------------=");
        System.out.println("=                                                      =");
        System.out.println("=                4. Display All Member's List          =");
        System.out.println("=                9. Back To Main                       =");
        System.out.println("=                                                      =");
        System.out.println("========================================================");
        numberInputform();
    }

    private void nameInputform()
    {
        System.out.println("이름을 입력 해주세요 : ");
    }
    private void numberInputform()
    {
        System.out.println("메뉴 번호를 입력 해주세요 : ");
    }
}
