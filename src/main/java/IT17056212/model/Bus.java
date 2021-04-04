package IT17056212.model;

public class Bus {

	private int bId;
	private String busNo;
	private String model;
	private int add_uid;

	public int getAdd_uid() {
		return add_uid;
	}

	public void setAdd_uid(int add_uid) {
		this.add_uid = add_uid;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNoSeats() {
		return noSeats;
	}

	public void setNoSeats(String noSeats) {
		this.noSeats = noSeats;
	}

	public String noSeats;


}
