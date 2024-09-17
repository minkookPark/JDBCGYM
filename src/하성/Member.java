package 하성;

import java.sql.Date;

public class Member {
	private int member_num;
	private int pt_count;
	private Date reg_date;
	private Date exp_date;
	private String login_id;
	private String login_pw;
	private String gender;
	private int age;
	private String name;
	private int trainer_num;
	private int charge_num;
	
	Member(){}
	
	public Member(int member_num,int pt_count,Date reg_date,Date exp_date,String login_id,String login_pw,String gender,int age,String name,int trainer_num,int charge_num) {
		this.age = age;
		this.charge_num = charge_num;
		this.exp_date = exp_date;
		this.gender = gender;
		this.login_id = login_id;
		this.login_pw = login_pw;
		this.member_num = member_num;
		this.name = name;
		this.pt_count = pt_count;
		this.reg_date = reg_date;
		this.trainer_num = trainer_num;
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

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getExp_date() {
		return exp_date;
	}

	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getLogin_pw() {
		return login_pw;
	}

	public void setLogin_pw(String login_pw) {
		this.login_pw = login_pw;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
				+ exp_date + ", login_id=" + login_id + ", login_pw=" + login_pw + ", gender=" + gender + ", age=" + age
				+ ", name=" + name + ", trainer_num=" + trainer_num + ", charge_num=" + charge_num + "]";
	}
	
	
	
}
