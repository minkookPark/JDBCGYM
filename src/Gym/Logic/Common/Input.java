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
            System.out.println("-9999~9999 사이 값을 입력해주세요");
            return 0;
        }
        return result;
    }

    public static int intScan(int min, int max)
    {
        String s = scan.nextLine();
        int result = Integer.parseInt(s);

        if(result > max || result < min)
        {
            System.out.println(min + "~" + max + " 사이의 정수값을 입력해주세요");
            return 0;
        }
        return result;
    }

    public static double doubleScan()
    {
        String s = scan.nextLine();
        double result = Double.parseDouble(s);

        if(result > 9999 || result < -9999)
        {
            System.out.println("-9999~9999 사이 값을 입력해주세요");
            return 0;
        }
        return result;
    }
}
