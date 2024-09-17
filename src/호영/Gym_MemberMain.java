package 호영;

import Gym.Logic.Common.Input;
import Gym.Logic.Logic.ShowManager;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class Gym_MemberMain {
    	public void execute() {
            while (true) {
                ShowManager.getInstance().showMemberMenu();
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
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 선택이 아닙니다.");
                    break;
            }
        }
    }

		private void insertMember() {
        Gym_Member member = new Gym_Member();
        System.out.println("회원 정보를 입력하세요:");

        System.out.print("PT 횟수: ");
        member.setPt_count(Input.intScan());

        System.out.print("등록일은 (yyyy-MM-dd HH:mm:ss) 형식으로 입력: ");
        member.setReg_date(Timestamp.valueOf(Input.stringScan()));

        System.out.print("만료일 (yyyy-MM-dd) 형식으로 입력: ");
        member.setExp_date(Date.valueOf(Input.stringScan()));

        System.out.print("로그인 ID: ");
        member.setLogin_id(Input.stringScan());

        System.out.print("로그인 비밀번호: ");
        member.setLogin_pw(Input.stringScan());

        System.out.print("성별: ");
        member.setGender(Input.stringScan());

        System.out.print("나이: ");
        member.setAge();
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

		static JdbcGym_MemberDao dao = new JdbcGym_MemberDao();
		private void findAll() {
		List<Gym_Member> mList = dao.findAll();
		for (Gym_Member gym_Member : mList) {
			System.out.println(gym_Member);

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
