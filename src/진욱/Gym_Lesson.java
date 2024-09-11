package 진욱;

import java.sql.Timestamp;

public class Gym_Lesson {
    private int class_num;
    private String class_detail;
    private Timestamp progress_time;
    private Trainer trainer;
    private Member member;

    public Gym_Lesson() {
    }


    public Gym_Lesson(int class_num, String class_detail, Timestamp progress_time, Trainer trainer, Member member) {
        this.class_num = class_num;
        this.class_detail = class_detail;
        this.progress_time = progress_time;
        this.trainer = trainer;
        this.member = member;
    }

    public int getClass_num() {
        return class_num;
    }

    public void setClass_num(int class_num) {
        this.class_num = class_num;
    }

    public String getClass_detail() {
        return class_detail;
    }

    public void setClass_detail(String class_detail) {
        this.class_detail = class_detail;
    }

    public Timestamp getProgress_time() {
        return progress_time;
    }

    public void setProgress_time(Timestamp progress_time) {
        this.progress_time = progress_time;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "수업정보[" +
                "수업번호=" + class_num +
                ", 과목명='" + class_detail + '\'' +
                ", 진행시간=" + progress_time +
                ", 트레이너=" + trainer +
                ", 회원정보=" + member +
                ']';
    }
}



