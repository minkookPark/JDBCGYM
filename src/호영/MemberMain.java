package 호영;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import Gym.Logic.Common.Input;
import 민국.JDBCTrainerDao;
//import 민국.TestMain;
import 민국.Trainer;
import 진욱.Gym_Lesson;
import 진욱.Gym_LessonDao;
import 진욱.JDBCGymLessonDao;
import 진욱.ReviewMain;
import 희진.JDBCInbodyDao;


public class MemberMain {

		private static JdbcGym_MemberDao mDao = new JdbcGym_MemberDao();		
		private static Scanner scanner = new Scanner(System.in);
		// static ReviewDao rDao = new JDBCReviewDao();
		static ReviewMain rMain = new ReviewMain();
		static Gym_LessonDao gDao = new JDBCGymLessonDao();
		static JDBCTrainerDao tDao = new JDBCTrainerDao();
		static JDBCInbodyDao iDao = new JDBCInbodyDao();
		//static InbodyMain iMain = new InbodyMain(); 희진님 메인 메소드
		//static TestMain tMain = new TestMain();				

    	public static void main(String[] args) {
        while (true) {
            System.out.println("메뉴를 선택하세요:");
            System.out.println("1. 회원 추가");
            System.out.println("2. 회원 정보 수정");
            System.out.println("3. 회원 삭제");
            System.out.println("4. 전체 회원목록 열람");
            System.out.println("5. 회원 로그인");
            System.out.println("6. 종료");

            int choice = Input.intScan();            

            switch (choice) {
                case 1:
                    insertMember();
                    break;
                case 2:
                    updateMember();
                    break;
                case 3:
                    deleteMember();
                    break;
                case 4:
                	findAll();
                	break;
                case 5:
                	loginMember();
                	break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 선택이 아닙니다.");
            }
        }
    }

    

		private static void insertMember() {
        Gym_Member member = new Gym_Member();

        System.out.println("회원 정보를 입력하세요:");

        System.out.print("PT 횟수: ");
        member.setPt_count(scanner.nextInt());          

        System.out.print("등록일 (yyyy-MM-dd HH:mm:ss): ");
        member.setReg_date(Timestamp.valueOf(Input.stringScan()));

        System.out.print("만료일 (yyyy-MM-dd): ");
        member.setExp_date(Date.valueOf(Input.stringScan()));

        System.out.print("로그인 ID: ");
        member.setLogin_id(Input.stringScan());

        System.out.print("로그인 비밀번호: ");
        member.setLogin_pw(Input.stringScan());

        System.out.print("성별: ");
        member.setGender(Input.stringScan());

        System.out.print("나이: ");
        member.setAge(Input.intScan());

        System.out.print("이름: ");
        member.setName(Input.stringScan());

        System.out.print("트레이너 번호: ");
        member.setTrainer_num(Input.intScan()); 

        System.out.print("회원권 번호: ");
        member.setCharge_num(Input.intScan());

        if (mDao.insert(member)) {
            System.out.println("회원이 성공적으로 추가되었습니다.");
        } else {
            System.out.println("회원 추가에 실패하였습니다.");
        }
	}	
		
		
		private static void findAll() {
		List<Gym_Member> mList = mDao.findAll();
		for (Gym_Member gym_Member : mList) {
			System.out.println(gym_Member);
	}
		
}
    
		private static void updateMember() {
        System.out.print("수정할 회원의 번호를 입력하세요: ");
        int memberNum = Input.intScan();

        Gym_Member member = mDao.findByMember_Num(memberNum);
        if (member == null) {
            System.out.println("회원을 찾을 수 없습니다.");
            return;
}

        System.out.println("현재 회원 정보: " + member);

        System.out.print("새 PT 횟수 (현재: " + member.getPt_count() + "): ");
        member.setPt_count(scanner.nextInt());
              
        System.out.print("새 비밀번호 (현재: " + member.getLogin_pw() + "): ");
        member.setLogin_pw(scanner.nextLine());      
        
        if (mDao.update(member)) {
            System.out.println("회원 정보가 성공적으로 업데이트되었습니다.");
        } else {
            System.out.println("회원 정보 업데이트에 실패하였습니다.");
    }
}

		private static void deleteMember() {
        System.out.print("삭제할 회원의 번호를 입력하세요: ");
        int memberNum = Input.intScan();
        scanner.nextLine(); 

        if (mDao.deleteByMember_Num(memberNum)) {
            System.out.println("회원이 성공적으로 삭제되었습니다.");
        } else {
            System.out.println("회원 삭제에 실패하였습니다.");
    }
}
        
        private static void loginMember() {
        
        while(true) {
        	System.out.println("메뉴를 선택해 주세요.");
        	System.out.println("1.클래스 검색");
        	System.out.println("2.트레이너 요청");
        	System.out.println("3.리뷰");
        	System.out.println("4.인바디");
        	System.out.println("5.비밀번호 변경");
        	System.out.println("6.로그아웃");
        	System.out.println("7.회원탈퇴");
        	System.out.println("8.종료");
        	
        int choice2 = Input.intScan();  
        
        switch(choice2) {
        case 1:
        	for (Gym_Lesson g: gDao.findAll()) {
        		System.out.println(g);
        	}       	
        	break;
        case 2:
        	for (Trainer t : tDao.findAll()) {
        		System.out.println(t);
        	}       	
        	break;
        case 3:
        	rMain.execute();
        	break;
        case 4:
        	
        	break;
        case 5:
        	//changePw();
        	break;
        case 6:
        	//logout();
        	break;
        case 7:
        	//memberWithdrawal();
        	break;        	
        case 8:
        	System.out.println("프로그램을 종료합니다.");
        	return;	
        default:
        	System.out.println("잘못된 접근입니다.");
        	break;
        }
     }        	
}        
        	     
     
}		
