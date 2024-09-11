package 희진;

import java.util.List;

public interface InbodyDao {
	// 인바디 인터페이스
	boolean insert(Inbody inbody); 
	
	
	
	boolean deleteBybodynum(int Inbody_num);
	
	public List<Inbody> findAll();
	
	public Inbody findBybodynum(int Inbody_num);	
}