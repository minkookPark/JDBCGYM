package 진욱;

import java.sql.Date;
import java.sql.Timestamp;

public class Member {
    private int member_num;
    private int pt_count;
    private Timestamp reg_date;
    private Date exp_date;
    private String login_id;
    private String login_pw;
    private String gender;
    private int age;
    private int my_trainer;
    private int charge_num;

    public Member() {
    }

    public Member(int member_num, int pt_count, Timestamp reg_date, Date exp_date, String login_id, String login_pw, String gender, int age, int my_trainer, int charge_num) {
        this.member_num = member_num;
        this.pt_count = pt_count;
        this.reg_date = reg_date;
        this.exp_date = exp_date;
        this.login_id = login_id;
        this.login_pw = login_pw;
        this.gender = gender;
        this.age = age;
        this.my_trainer = my_trainer;
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

    public int getMy_trainer() {
        return my_trainer;
    }

    public void setMy_trainer(int my_trainer) {
        this.my_trainer = my_trainer;
    }

    public int getCharge_num() {
        return charge_num;
    }

    public void setCharge_num(int charge_num) {
        this.charge_num = charge_num;
    }

    @Override
    public String toString() {
        return "Member{" +
                "member_num=" + member_num +
                ", pt_count=" + pt_count +
                ", reg_date=" + reg_date +
                ", exp_date=" + exp_date +
                ", login_id='" + login_id + '\'' +
                ", login_pw='" + login_pw + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", my_trainer=" + my_trainer +
                ", charge_num=" + charge_num +
                '}';
    }
}
