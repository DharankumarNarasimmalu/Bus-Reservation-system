package busReservationSystem4;
public class PassengerDetails {
	private String PassengerName;
	private int PassengerAge;
	private String PassengerGender;
	private int BookedBusNo;

	public PassengerDetails(String name, String gender, int age, int busNo) {
		this.PassengerName=name;
		this.PassengerAge=age;
		this.PassengerGender=gender;
		this.BookedBusNo=busNo;
	}
	public void showDetails() {
		System.out.println(PassengerName+" "+PassengerAge+" "+PassengerGender+" "+BookedBusNo);
	}
	public void setName(String name) {
		this.PassengerName=name;
	}
	public void setAge(int age) {
		this.PassengerAge=age;
	}
	public void setGender(String gender) {
		this.PassengerGender=gender;
	}
	public void setBusNo(int busNo) {
		this.BookedBusNo=busNo;
	}
	public int getBusNo() {
		int busNo=BookedBusNo;
		return busNo;
	}
	public String getName() {
		return PassengerName;
	}

}
