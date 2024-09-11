package 민국;

public class TestMain {

	public static void main(String[] args) {

		JDBCTrainerDao tDao = new JDBCTrainerDao();

//		Trainer testInserTrainer = new Trainer("qwer","a1234","남자","있어용",27);
//		tDao.insert(testInserTrainer);

		for(Trainer t : tDao.findAll())
		{
			System.out.println(t);
		}

//		Trainer updateTest = new Trainer(2,"asdf","1q2w3e","여자","짱큰대회",33);
//		tDao.update(updateTest);

		//tDao.deleteById(1);

	}

}
