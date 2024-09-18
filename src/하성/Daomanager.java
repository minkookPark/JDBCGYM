package 하성;

public interface Daomanager {

	Trainer findById(String login_id);
	boolean deleteById(int trainer_num);
	boolean updatepasswordGym_trainer(String login_id);
}
