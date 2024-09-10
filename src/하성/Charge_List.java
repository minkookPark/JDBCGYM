package 하성;

import java.sql.Date;

public class Charge_List {
	private int charge_num;
	private Date period;
	private int pt_count;
	
	Charge_List(){}
	
	public Charge_List(int charge_num,Date period,int pt_count) {
		this.charge_num = charge_num;
		this.period = period;
		this.pt_count = pt_count;
	}

	public int getCharge_num() {
		return charge_num;
	}

	public void setCharge_num(int charge_num) {
		this.charge_num = charge_num;
	}

	public Date getPeriod() {
		return period;
	}

	public void setPeriod(Date period) {
		this.period = period;
	}

	public int getPt_count() {
		return pt_count;
	}

	public void setPt_count(int pt_count) {
		this.pt_count = pt_count;
	}

	@Override
	public String toString() {
		return "charge_list [charge_num=" + charge_num + ", period=" + period + ", pt_count=" + pt_count
				+ ", getCharge_num()=" + getCharge_num() + ", getPeriod()=" + getPeriod() + ", getPt_count()="
				+ getPt_count() + "]";
	}
	
}
