package 호영;

import java.sql.Date;
import 민국.LoginData;
import java.sql.Timestamp;

public class Gym_Member {

	
	private int member_num;
	private int pt_count;
	private Timestamp reg_date;
	private Date exp_date;
	private String name;
	private int trainer_num;
	private int charge_num;	
	private LoginData loginData;
	
	
	public Gym_Member() {}	

	public Gym_Member(int member_num, String name) {
		super();
		this.member_num = member_num;
		this.name = name;
		
		loginData = new LoginData();
	}



	public Gym_Member(int member_num, int pt_count, String login_id, String login_pw, String gender, int age, String name,
			int trainer_num, int charge_num) {
		super();
		this.member_num = member_num;
		this.pt_count = pt_count;	
		loginData = new LoginData(login_id, login_pw, gender, age);				
		this.name = name;
		this.trainer_num = trainer_num;
		this.charge_num = charge_num;
	}

	public Gym_Member(int member_num, int pt_count, Timestamp reg_date, Date exp_date, String login_id, String login_pw,
			String gender, int age, String name, int trainer_num, int charge_num) {
		super();
		this.member_num = member_num;
		this.pt_count = pt_count;
		this.reg_date = reg_date;
		this.exp_date = exp_date;
		loginData = new LoginData(login_id, login_pw, gender, age);	
		this.name = name;
		this.trainer_num = trainer_num;
		this.charge_num = charge_num;
	}

	public int getMember_num() {
		return member_num;
	}

	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}

	public int getPt_count() {
		return pt_count;
	}

	public void setPt_count(int pt_count) {
		this.pt_count = pt_count;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

	public Date getExp_date() {
		return exp_date;
	}

	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}

	public LoginData getLoginData() {
		return loginData;
	}
	
	public String getLogin_id() {
		return loginData.getLogin_id();
	}

	public void setLogin_id(String login_id) {
		this.loginData.setLogin_id(login_id);
	}

	public String getLogin_pw() {
		return loginData.getLogin_pw();
	}

	public void setLogin_pw(String login_pw) {
		this.loginData.setLogin_pw(login_pw);
	}

	public String getGender() {
		return loginData.getGender();
	}

	public void setGender(String gender) {
		this.loginData.setGender(gender);
	}

	public int getAge() {
		return loginData.getAge();
	}

	public void setAge(int age) {
		this.loginData.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTrainer_num() {
		return trainer_num;
	}

	public void setTrainer_num(int trainer_num) {
		this.trainer_num = trainer_num;
	}

	public int getCharge_num() {
		return charge_num;
	}

	public void setCharge_num(int charge_num) {
		this.charge_num = charge_num;
	}

	@Override
	public String toString() {
		return "Member [member_num=" + member_num + ", pt_count=" + pt_count + ", reg_date=" + reg_date + ", exp_date="
				+ exp_date + ", login_id=" + loginData.getLogin_id() + ", login_pw=" + loginData.getLogin_pw() + ", gender=" +loginData.getGender() + ", age=" + loginData.getAge()
				+ ", name=" + name + ", trainer_num=" + trainer_num + ", charge_num=" + charge_num + "]";
	}
	
	
	
	
}
