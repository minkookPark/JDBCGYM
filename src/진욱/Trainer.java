package 진욱;

public class Trainer {
    private int trainer_num;
    private String login_id;
    private String login_pw;
    private String gender;
    private String award;
    private int age;
    private String name;

    public Trainer() {
    }

    public Trainer(int trainer_num, String name){
        this.trainer_num = trainer_num;
        this.name = name;
    }

    public Trainer(int trainer_num, String login_id, String login_pw, String gender, String award, int age) {
        this.trainer_num = trainer_num;
        this.login_id = login_id;
        this.login_pw = login_pw;
        this.gender = gender;
        this.award = award;
        this.age = age;
    }

    public int getTrainer_num() {
        return trainer_num;
    }

    public void setTrainer_num(int trainer_num) {
        this.trainer_num = trainer_num;
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

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
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

    @Override
    public String toString() {
        return "트레이너 정보[" +
                "트레이너번호=" + trainer_num +
                ", id='" + login_id + '\'' +
                ", pw='" + login_pw + '\'' +
                ", 성별='" + gender + '\'' +
                ", 수상경력='" + award + '\'' +
                ", 나이=" + age +
                ", 이름=" + name +
                ']';
    }
}
