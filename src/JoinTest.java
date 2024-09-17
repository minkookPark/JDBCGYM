import Gym.Logic.Common.Input;

public class JoinTest {
    public static void main(String[] args) {
        System.out.println("Select Join Type");
        System.out.println("1. Trainer Join");
        System.out.println("2. Member Join");
        System.out.println("3. Manager Join");

        int select = Input.intScan(1,3);
        switch (select)
        {
            case 1:
            {
                //Trainer Join
                break;
            }
            case 2:
            {
                //Member Join
                break;
            }
            case 3:
            {
                break;
            }
        }


    }

}
