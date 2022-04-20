package employee;

public class Driver extends Employee{
	private float salary;
	private int yearOfExperience;

	private String remarks;
	private String status;

	public Driver(String name, int age, long phoneNumber, String mail, String address, int salary, int exp, int busNo, String remarks,String status) {
		super.name=name;
		super.age=age;
		super.phoneNumber=phoneNumber;
		super.mailId=mail;
		super.address=address;
		this.salary=salary;
		this.yearOfExperience=exp;
		this.remarks=remarks;
		this.status=status;
		
	}
	public void paySalary() {
		
	}
	public String getStatus() {
		return status;
	}
	public void setRemarks(String remarks) {
		this.remarks=remarks;
	}
	public String  getRemarks() {
		return remarks;
	}

	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary=salary;
	}
	public void setExperience(int exp) {
		this.yearOfExperience=exp;
		
	}
	public void displayDetails() {
		System.out.println(name+" "+age+" "+phoneNumber+" "+mailId+" "+address+" "+salary+" "+yearOfExperience+" "+remarks);
		
	}

}