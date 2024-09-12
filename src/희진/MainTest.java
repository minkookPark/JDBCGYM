package 희진;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MainTest {

	private static JDBCInbodyDao iDao = new JDBCInbodyDao();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		while (true) {
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1.인바디 정보 입력");
			System.out.println("2.인바디 정보 검색");
			System.out.println("3.종료");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1:
				insertInbody();
				break;
			case 2:
				// findByInbodyNum();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				return;
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
		
		private static void findByInbodyNum() {
			System.out.println("검색할 인바디 번호를 입력하세요");
			
			
			
		}
		}
		
		
	}

