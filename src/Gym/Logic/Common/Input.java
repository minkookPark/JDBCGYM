package Gym.Logic.Common;

import java.util.Scanner;

public class Input {
    public static Scanner scan = new Scanner(System.in);

    public static String stringScan()
    {
        return scan.nextLine();
    }

    public static int intScan()
    {
        String s = scan.nextLine();
        int result = Integer.parseInt(s);

        if(result > 9999 || result < -9999)
        {
            System.out.println("몽키스패너 각 아님? ");

            return 0;
        }

        return result;
    }
}
