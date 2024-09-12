package 호영;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class Main {

		private static JdbcGym_MemberDao mDao = new JdbcGym_MemberDao();
		private static Scanner scanner = new Scanner(System.in);

    	public static void main(String[] args) {
        while (true) {
            System.out.println("메뉴를 선택하세요:");
            System.out.println("1. 회원 추가");
            System.out.println("2. 회원 정보 수정");
            System.out.println("3. 회원 삭제");
            System.out.println("4. 전체 회원목록 열람");
            System.out.println("5. 종료");

            int choice = scanner.nextInt();
            scanner.nextLine();

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
        scanner.nextLine();  

        System.out.print("등록일 (yyyy-MM-dd HH:mm:ss): ");
        member.setReg_date(Timestamp.valueOf(scanner.nextLine()));

        System.out.print("만료일 (yyyy-MM-dd): ");
        member.setExp_date(Date.valueOf(scanner.nextLine()));

        System.out.print("로그인 ID: ");
        member.setLogin_id(scanner.nextLine());

        System.out.print("로그인 비밀번호: ");
        member.setLogin_pw(scanner.nextLine());

        System.out.print("성별: ");
        member.setGender(scanner.nextLine());

        System.out.print("나이: ");
        member.setAge(scanner.nextInt());
        scanner.nextLine();  

        System.out.print("이름: ");
        member.setName(scanner.nextLine());

        System.out.print("트레이너 번호: ");
        member.setTrainer_num(scanner.nextInt());
        scanner.nextLine();  

        System.out.print("회원권 번호: ");
        member.setCharge_num(scanner.nextInt());
        scanner.nextLine();  

        if (mDao.insert(member)) {
            System.out.println("회원이 성공적으로 추가되었습니다.");
        } else {
            System.out.println("회원 추가에 실패하였습니다.");
        }
    }	
		//안녕
		static JdbcGym_MemberDao dao = new JdbcGym_MemberDao();
		private static void findAll() {
		List<Gym_Member> mList = dao.findAll();
		for (Gym_Member gym_Member : mList) {
			System.out.println(gym_Member);
			scanner.nextLine();
		}
		
	}
    
		private static void updateMember() {
        System.out.print("수정할 회원의 번호를 입력하세요: ");
        int memberNum = scanner.nextInt();
        scanner.nextLine();  

        Gym_Member member = mDao.findByMember_Num(memberNum);
        if (member == null) {
            System.out.println("회원을 찾을 수 없습니다.");
            return;
        }

        System.out.println("현재 회원 정보: " + member);

        System.out.print("새 PT 횟수 (현재: " + member.getPt_count() + "): ");
        member.setPt_count(scanner.nextInt());
        scanner.nextLine(); 

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
        int memberNum = scanner.nextInt();
        scanner.nextLine(); 

        if (mDao.deleteByMember_Num(memberNum)) {
            System.out.println("회원이 성공적으로 삭제되었습니다.");
        } else {
            System.out.println("회원 삭제에 실패하였습니다.");
        }
    }
}
