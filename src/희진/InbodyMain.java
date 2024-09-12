package 희진;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class InbodyMain {

   private static JDBCInbodyDao iDao = new JDBCInbodyDao();
   private static Scanner scanner = new Scanner(System.in);
   
   public static void main(String[] args) {

      while (true) {
         System.out.println("메뉴를 선택해주세요");
         System.out.println("1.인바디 정보 입력");
         System.out.println("2.인바디 정보 검색");
         System.out.println("3.인바디 정보 전체검색");
         System.out.println("4.인바디 정보 삭제");
         System.out.println("5.종료");

         int choice = scanner.nextInt();
         scanner.nextLine();

         switch (choice) {
         case 1:
            insertInbody();
            break;
         case 2:
            findByInbodyNum();
            break;
         case 3:
            findAllInbody();
            break;
         case 4:
             deleteInbody();
             break;
         case 5:
            System.out.println("프로그램을 종료합니다.");
            break;
         default:
            System.out.println("올바른 선택이 아닙니다.");
      }
   }
}
      private static void insertInbody() {
      Inbody inbody = new Inbody();

      System.out.println("인바디 정보를 입력해주세요.");

      System.out.println("몸무게를 입력하세요");
      inbody.setWeight(scanner.nextDouble());
      scanner.nextLine();
      
      System.out.println("키를 입력하세요");
      inbody.setHeight(scanner.nextDouble());
      
      System.out.println("지방량을 입력하세요");
      inbody.setFat(scanner.nextDouble());
      
      System.out.println("근육량을 입력하세요");
      inbody.setMuscle(scanner.nextDouble());
      
      System.out.println("신체나이를 입력하세요");
      inbody.setBody_age(scanner.nextInt());
      
      System.out.println("신체점수를 입력하세요");
      inbody.setBody_score(scanner.nextInt());
      
      System.out.println("회원번호를 입력하세요");
      inbody.setMember_num(scanner.nextInt());
      
      if (iDao.insert(inbody)) {
         System.out.println("인바디 정보가 성공적으로 추가되었습니다.");
         }else {
            System.out.println("인바디 추가에 실패하였습니다.");
         }
      }
      
      private static void findByInbodyNum() {
         System.out.println("찾으실 인바디 번호를 입력하세요.: ");
         int inbodyNum = scanner.nextInt();
         scanner.nextLine();
         
         Inbody inbody2 = iDao.findBybodynum(inbodyNum);
   
         if (inbody2 != null) {
        	 System.out.println("Inbody_num :" + inbody2.getInbody_Num() +
        			 			"M_date :" + inbody2.getM_date() +    			 
        	 					"Weight :" + inbody2.getWeight() +        			 
        	 					"Height :" + inbody2.getHeight() +        			 
        	 					"Fat :" + inbody2.getFat() +        			 
        	 					"Muscle :" + inbody2.getMuscle() +        			 
        	 					"Body_age :" + inbody2.getBody_age() +        			 
        	 					"Body_score :" + inbody2.getBody_score() +
        	 					"Member_num :" + inbody2.getMember_num());
       	       	 System.out.println("해당 회원의 인바디 정보를 검색하였습니다.");
    	 } else { System.out.println("인바디 정보를 검색하지 못하였습니다.");
         }
      }

      private static void findAllInbody() {
    	  System.out.println("전체 회원의 인바디 정보를 검색합니다.");
    	  List<Inbody> inbodys = iDao.findAll();
    	  for (Inbody inbody : inbodys) {
			System.out.println(inbody);
		}
		}
      
      private static void deleteInbody() {
         System.out.println("삭제할 인바디 번호를 입력하세요: ");
         int inbodyNum = scanner.nextInt();
         scanner.nextLine();
         
         if (iDao.deleteBybodynum(inbodyNum)) {
            System.out.println("성공적으로 삭제되었습니다");
         } else {
            System.out.println("인바디 정보 삭제에 실패하였습니다.");
      }                  
   }
}