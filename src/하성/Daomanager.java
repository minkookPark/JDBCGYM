package 하성;

public interface Daomanager {

	Trainer findByLogin_id(String login_id);
	Trainer findByTrainer_num(int trainer_num);
	boolean deleteByLogin_id(int trainer_num);
	boolean updatepasswordGym_trainer(String login_id);
}
