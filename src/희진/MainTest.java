package 희진;

import java.sql.Timestamp;
import java.util.List;

public class MainTest {
	
	public static void main(String[] args) {
		
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		TrainerInterface a = new JDBCTrainerDao();
		  
		Inbody inbody2 = new Inbody();
			 
		inbody2.setM_date(timeStamp);
		inbody2.setWeight(4.0);
		inbody2.setHeight(4.0); 
		inbody2.setFat(4.0);
		inbody2.setMuscle(3.0); 
		inbody2.setBody_age(3); 
		inbody2.setBody_score(3);
		inbody2.setMember_num(2);
		inbody2.setInbody_Num(2);
		
			  
		 a.update(inbody2);
	}
}
