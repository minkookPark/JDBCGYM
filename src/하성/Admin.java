package space.jdbc.gym;

public class Admin {
	private long manager_num;
	private String position;
	
	Admin(){}
	
	public Admin(long manager_num,String position) {
		this.manager_num = manager_num;
		this.position = position;
	}

	public long getManager_num() {
		return manager_num;
	}

	public void setManager_num(long manager_num) {
		this.manager_num = manager_num;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "admin [manager_num=" + manager_num + ", position=" + position + ", getManager_num()=" + getManager_num()
				+ ", getPosition()=" + getPosition() + "]";
	}
	
	
}
