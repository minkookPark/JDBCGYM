package 희진;

import java.util.List;

public interface TrainerInterface {
	
	boolean insert(Inbody inbody); // 새회원 인바디 입력

	boolean update(Inbody inbody); // 변경된 인바디 저장 필요
	
	boolean deleteBybodynum(double Inbody_num); // 회원 탈퇴한 사람의 정보 삭제
	
	public List<Inbody> findAll();	// 모든 회원의 정보를 볼 필요는 없음
	
	public Inbody findBybodynum(double Inbody_num); // 회원이 본인의 정보 검색 . 그러나 멤버 클래스에서 필요	
}