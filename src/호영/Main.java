package 호영;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        
        JdbcGym_MemberDao mDao = new JdbcGym_MemberDao();        
        
        Gym_Member gym_member = new Gym_Member();
        gym_member.setMember_num(1); // 예시로 1을 설정
        gym_member.setPt_count(10); // 예시로 10을 설정
        gym_member.setReg_date(Timestamp.valueOf("2024-01-01")); 
        gym_member.setExp_date(Date.valueOf("2024-12-31")); 
        gym_member.setLogin_id("user123"); 
        gym_member.setLogin_pw("password123"); 
        gym_member.setGender("Male"); 
        gym_member.setAge(30); 
        gym_member.setName("John"); 
        gym_member.setCharge_num(100); 
        gym_member.setTrainer_num(10); 

        
        // mDao.insert(gym_member); 
        
        Gym_Member member = mDao.findByMember_Num(1);
        if (member != null) {
            System.out.println(member);

            // 회원의 비밀번호를 업데이트
            member.setMember_num(1);
            boolean update = mDao.update(member); 
            if (update) {
                System.out.println("업데이트가 성공적으로 완료되었습니다.");
            } else {
                System.out.println("업데이트에 실패하였습니다.");
            }

         
            List<Gym_Member> MLst = mDao.findAll();
            for (Gym_Member updatedMember : MLst) {
                System.out.println(updatedMember);
            }
        }else {
        	System.out.println("회원을 찾을 수 없습니다.");
        }
    }
}
