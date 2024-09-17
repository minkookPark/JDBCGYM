package 호영;

import Gym.Logic.Common.Gym;
import Gym.Logic.Common.Input;
import Gym.Logic.Logic.DAOManager;
import Gym.Logic.Logic.ShowManager;
import 민국.Trainer;
import 진욱.ReviewMain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Gym_MemberMain {
    Gym_MemberDao mDao = DAOManager.getInstance().getmDao();

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
                    ReviewMain rm = new ReviewMain();
                    rm.reviewExecute();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    Gym gym = new Gym();
                    gym.run();
                default:
                    System.out.println("올바른 선택이 아닙니다.");
                    break;
            }
        }
    }

    private void insertMember() { // Trainer 등이 회원을 추가할 때 사용할 메소드.
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

    private void findAll() {
        List<Gym_Member> mList = mDao.findAll();
        for (Gym_Member gym_Member : mList) {
            System.out.println(gym_Member);
        }
    }

    private void updateMember() { // 기능은 3개 필요. 담당 트레이너 변경과 PT 횟수 변경, 비밀번호 변경.
        // 현재 로그인한 회원의 정보를 가져온다. 로그인 상태가 아니라면 회원을 찾을 수 없다는 메시지 출력 후 돌아간다.
        Gym_Member toFindMember = LoginManager.getInstance().getCurrentMember();
        if (toFindMember == null){
            System.out.println("로그인 상태가 아닙니다. 다시 시도해 주세요!");
            Gym gym = new Gym();
            gym.run();
        } else {
            System.out.println("수정하고 싶은 정보를 선택해주세요. 1. 담당 트레이너 변경 / 2. PT 횟수 변경 / 3. 비밀번호 변경");
            int method = Input.intScan();
            if (method == 1) {
                System.out.println("전체 트레이너를 출력합니다. 담당 변경을 원하는 트레이너 번호를 입력하세요.");
                for (Trainer t : DAOManager.getInstance().gettDao().findAll()) {
                    System.out.println(t);
                }
                int select = Input.intScan();
                toFindMember.setTrainer_num(select);
                mDao.update(toFindMember);
                System.out.println("담당 트레이너 정보가 변경되었습니다.");
            } else if (method == 2) {
                System.out.println("현재 로그인한 고객님의 PT 횟수 :" + mDao.findByMember_Num(toFindMember.getMember_num()).getPt_count() + "회");
                System.out.print("변경할 PT 횟수를 입력해주세요. ");
                int ptCount = Input.intScan();
                toFindMember.setPt_count(ptCount);
                mDao.update(toFindMember);
            } else {
                System.out.print("새 비밀번호를 입력하세요! (현재: " + toFindMember.getLogin_pw() + "): ");
                String password = Input.stringScan();
                toFindMember.setLogin_pw(password);
                if (mDao.update(toFindMember)) {
                    System.out.println("회원 비밀번호가 성공적으로 변경되었습니다.");
                } else {
                    System.out.println("회원 비밀번호 변경 오류. 다시 시도해주세요.");
                }
            }
        }
    }

    private void deleteMember() {
        System.out.print("삭제할 회원의 번호를 입력하세요: ");
        int memberNum = Input.intScan();

        if (mDao.deleteByMember_Num(memberNum)) {
            System.out.println("회원이 성공적으로 삭제되었습니다.");
        } else {
            System.out.println("회원 삭제에 실패하였습니다.");
        }
    }
}
