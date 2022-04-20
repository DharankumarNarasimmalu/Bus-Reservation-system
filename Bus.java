package busReservationSystem4;

public class Bus {
     private int busNo;
     private int noOfSeats;
	 private String from;
	 private String to;
     private String date;
	 private String ac;
	 private String driver;
	
	public Bus(int noOfSeats,String from,String to,String date,String ac,String driver) {
		this.noOfSeats=noOfSeats;
		this.from=from;
		this.to=to;
		this.date=date;
		this.ac=ac;
		this.driver=driver;
	}
	public int getNoOFSeats() {	
		return noOfSeats;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public String getDate() {
		return date;
	}
	public String getac() {
		return ac;
	}
	public String getDriver() {
		return driver;
	}
	public void setNoOFSeats(int capacity) {	
		this.noOfSeats=capacity;
	}
	public void setFrom(String fromLocation) {
		this.from=fromLocation;
	}
	public void setTo(String toLocation) {
		this.to=toLocation;
	}
	public void setDate(String date) {
		this.date=date;
	}
	public void setac(String ac) {
		this.ac=ac;
	}
	public void setDriver(String driverName) {
		this.driver=driverName;
	}
	public void showBusDetails() {
		System.out.println(noOfSeats+" "+from+" "+to+" "+date+" "+ac+" "+driver);		
	}

}
