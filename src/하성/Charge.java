package 하성;

public class Charge {
	private int charge_num;
	private int period_date;
	private int pt_count;
	  
	Charge(){}
	
	public Charge(int charge_num,int period_date,int pt_count) {
		this.charge_num = charge_num;
		this.period_date = period_date;
		this.pt_count = pt_count;
	}

	public int getCharge_num() {
		return charge_num;
	}

	public void setCharge_num(int charge_num) {
		this.charge_num = charge_num;
	}

	public int getPeriod_date() {
		return period_date;
	}

	public void setPeriod_date(int period_date) {
		this.period_date = period_date;
	}

	public int getPt_count() {
		return pt_count;
	}

	public void setPt_count(int pt_count) {
		this.pt_count = pt_count;
	}

	@Override
	public String toString() {
		return "Charge [charge_num=" + charge_num + ", period_date=" + period_date + ", pt_count=" + pt_count + "]";
	}

	
	
}
