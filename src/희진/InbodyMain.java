package 희진;

import Gym.Logic.Common.Input;
import java.util.Scanner;

public class InbodyMain {
	
   public void inbodyExecute() {
	   System.out.println("메뉴를 선택해주세요");
	  boolean loop = true;
	  while (loop) {
         System.out.println("1.인바디 정보 입력");
         System.out.println("2.인바디 정보 검색");
         System.out.println("3.인바디 정보 전체검색");
         System.out.println("4.인바디 정보 삭제");
         System.out.println("5.종료");

         String select = Input.stringScan();

         switch (select) {
         case "1":
            InbodyMethod.insertInbody();
            break;
         
         case "2":
        	 InbodyMethod.findByInbodyNum();
            break;
         
         case "3":
        	 InbodyMethod.findAllInbody();
            break;
         
         case "4":
        	 InbodyMethod.deleteInbody();
             break;
         
         case "5":
            System.out.println("프로그램을 종료합니다.");
            loop = false;
            break;

         default:
            System.out.println("올바른 선택이 아닙니다. 다시 선택해 주세요.");
      }
	  }
   }
}