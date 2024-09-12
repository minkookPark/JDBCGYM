package 민국;

public class LoginData {
    private String name;
    private String login_id;
    private String login_pw;
    private String gender;
    private int age;

    public LoginData() {
    }

    public LoginData(String login_id, String login_pw) {
        this.login_id = login_id;
        this.login_pw = login_pw;
    }

    public LoginData(String name, String login_id, String login_pw) {
        this.name = name;
        this.login_id = login_id;
        this.login_pw = login_pw;
    }

    public LoginData(String name, String login_pw, String gender, int age) {
        this.name = name;
        this.login_pw = login_pw;
        this.gender = gender;
        this.age = age;
    }

    public LoginData(String name, String login_id, String login_pw, String gender, int age) {
        this.name = name;
        this.login_id = login_id;
        this.login_pw = login_pw;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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



}
