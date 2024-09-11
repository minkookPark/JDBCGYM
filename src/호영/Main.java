package 호영;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public class Main {

    public static void main(String[] args) {
		
	 
        JdbcGym_MemberDao mDao = new JdbcGym_MemberDao();
        
        Gym_Member member = new Gym_Member();
       
 /*     member.setPt_count(10);
        member.setReg_date(Timestamp.valueOf("2024-01-01 10:30:25"));
        member.setExp_date(Date.valueOf("2024-12-31"));
        member.setLogin_id("dongsuk123");
        member.setLogin_pw("mypassword123");
        member.setGender("남");
        member.setAge(55);
        member.setName("마동석");
        member.setCharge_num(1);
        member.setTrainer_num(1);

        mDao.insert(member);
*/
//-------------------------------------------------------------------------------------------- 
       Gym_Member memberdao = mDao.findByMember_Num(1);
        if (memberdao != null) {
            System.out.println("Before Update: " + memberdao);

           
            memberdao.setPt_count(15); 
            memberdao.setLogin_pw("newpassword123");
            if (mDao.update(memberdao)) {
                System.out.println("업데이트가 성공적으로 완료되었습니다.");
            } else {
                System.out.println("업데이트에 실패하였습니다.");
            }
//--------------------------------------------------------------------------------------------   
            List<Gym_Member> MLst = mDao.findAll();
            for (Gym_Member updatedMember : MLst) {
                System.out.println(updatedMember);
            }
        } else {
            System.out.println("회원을 찾을 수 없습니다.");
            
        }
//--------------------------------------------------------------------------------------------        
        mDao.deleteByMember_Num(0);
//--------------------------------------------------------------------------------------------        
              
    }
}
