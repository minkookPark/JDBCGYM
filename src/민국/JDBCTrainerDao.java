package 민국;

import DataSource.DataSource;
import Gym.Logic.Logic.LoginManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JDBCTrainerDao implements TrainerDao {
    @Override
    public boolean insert(Trainer trainer) {
        boolean result = false;
        //try 문이 끝나면 자동으로 close 된다.
        try(Connection conn = DataSource.getDataSource();
            PreparedStatement pStatement = conn.prepareStatement(
                    "insert into GYM_TRAINER(LOGIN_ID, LOGIN_PW, GENDER, AWARD, AGE) " +
                            "values (?, ?, ?, ?, ?)"))
        {
            //id 중복 검사
            if(findById(trainer.getLogin_Id()))
            {
                return false;
            }

            //삽입
            pStatement.setString(1,trainer.getLogin_Id());
            pStatement.setString(2, trainer.getLogin_Pw());
            pStatement.setString(3,trainer.getGender());
            pStatement.setString(4,trainer.getAward());
            pStatement.setInt(5,trainer.getAge());

            int rows = pStatement.executeUpdate();

            if(rows > 0)
            {
                result = true;
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        if(result)
            System.out.println("트레이너 생성 성공");
        else
            System.out.println("생성 실패");

        return result;
    }

    
    //테스트 완료
    @Override
    public List<Trainer> findAll() {
        List<Trainer> tLst = new ArrayList<>();
        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStatement = conn.prepareStatement("select * from GYM_TRAINER");
             ResultSet rs = pStatement.executeQuery())
        {
            while (rs.next())
            {

                Trainer t = new Trainer();
                t.setTrainer_num(rs.getInt("TRAINER_NUM"));
                t.setLogin_Id(rs.getString("LOGIN_ID"));
                t.setLogin_Pw(rs.getString("LOGIN_PW"));
                t.setGender(rs.getString("GENDER"));
                t.setAward(rs.getString("AWARD"));
                t.setAge(rs.getInt("AGE"));

                tLst.add(t);
            }

            if(tLst.isEmpty())
            {
                System.out.println("테이블이 비어있습니다.");
                return null;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return tLst;
    }

    //테스트 완료
    @Override
    public Trainer findByIndex(int trainerNum) {
        //select * from gym_trainer where TRAINER_NUM = 1
        Trainer t = null;
        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStatement = conn.prepareStatement("select * from GYM_TRAINER where TRAINER_NUM = ?"))
        {
            pStatement.setInt(1,trainerNum);
            ResultSet rs = pStatement.executeQuery();
            if (rs.next())
            {
                t = new Trainer();
                t.setTrainer_num(rs.getInt("TRAINER_NUM"));
                t.setLogin_Id(rs.getString("LOGIN_ID"));
                t.setLogin_Pw(rs.getString("LOGIN_PW"));
                t.setGender(rs.getString("GENDER"));
                t.setAward(rs.getString("AWARD"));
                t.setAge(rs.getInt("AGE"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return t;
    }

    //login_Id 중복검사
    //해당 id가 존재하면 true
    //없으면 false 를 반환.
    @Override
    public boolean findById(String login_id)
    {
        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStatement = conn.prepareStatement("select * from GYM_TRAINER where LOGIN_ID = ?"))
        {
            pStatement.setString(1,login_id);
            ResultSet rs = pStatement.executeQuery();
            if (rs.next())
            {
                System.out.println("해당 ID를 가진 트레이너가 이미 존재합니다.");
                return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }


//테스트 완료
    @Override
    public boolean update(Trainer trainer) {

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStatement =
                     conn.prepareStatement("update GYM_TRAINER set " +
                             "LOGIN_PW = ?, AWARD = ?, AGE = ? where TRAINER_NUM = ?"))
        {
            //해당 id가 존재하는지 우선적으로 확인.
            if(findByIndex(trainer.getTrainer_num()) == null)
            {
                System.out.println("변경 실패!");
                System.out.println("해당 index의 트레이너가 존재하지 않습니다.");
                return false;
            }

            pStatement.setString(1, trainer.getLogin_Pw());
            pStatement.setString(2, trainer.getAward());
            pStatement.setInt(3,trainer.getAge());
            pStatement.setInt(4,trainer.getTrainer_num());

            int affectedrows = pStatement.executeUpdate();

            if(affectedrows > 0)
            {
                System.out.println("변경 성공!");
                return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("변경 실패!");
            return false;
        }

        return false;
    }

    //테스트 완료
    @Override
    public boolean deleteById(int id) {
        boolean isSuecces = false;
        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStatement = conn.prepareStatement("delete from GYM_TRAINER where TRAINER_NUM = ?")) {
            if (findByIndex(id) == null) {
                System.out.println("해당 index 의 트레이너가 존재하지 않습니다.");
                return false;
            }

            pStatement.setInt(1, id);
            int delectCount = pStatement.executeUpdate();

            if (delectCount > 0)
                isSuecces = true;
        } catch (Exception e) {
            System.out.println("삭제에 실패하였습니다.");
            e.printStackTrace();
            return false;
        }
        if (isSuecces) {
            System.out.println("성공적으로 삭제하였습니다.");
        } else
            System.out.println("데이터가 존재하지 않습니다.");
        return isSuecces;
    }

    public boolean tryLogin(String login_id, String login_pw)
    {
        boolean isSuccess = false;

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStatement = conn.prepareStatement("select * from GYM_TRAINER where LOGIN_ID = ?"))
        {
            pStatement.setString(1,login_id);
            ResultSet rs = pStatement.executeQuery();

            //해당 id 가 있는 트레이너가 존재하는 경우 (아이디 안 틀린 경우)
            if (rs.next())
            {
                String resultPw = rs.getString("LOGIN_PW");

                if(resultPw == login_pw) {
                    isSuccess = true;
                    LoginData curLoginUser = new LoginData();
                    LoginManager.getInstance().setCurrentLoginUser(curLoginUser);

                    System.out.println("로그인 성공, 현재 유저 : " + LoginManager.getInstance().getCurrentLoginUser().getLogin_id());
                }
                else
                {
                    System.out.println("비밀번호가 틀립니다.");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return isSuccess;
    }

}
