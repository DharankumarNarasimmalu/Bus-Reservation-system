package employee;

public class Supervisor extends Employee{
	private float salary;
	private int yearOfExperience;
	private String remarks;
	private String status;
    public Supervisor(String name, int age, long phno, String mail, String address, int salary, int exp,
			String remarks,String status) {
		super.name=name;
		super.age=age;
		super.phoneNumber=phno;
		super.mailId=mail;
		super.address=address;
		this.salary=salary;
		this.yearOfExperience=exp;
		this.remarks=remarks;
		this.status=status;
	}

	void paySalary() {
		System.out.println("Salary paid");
	}
	String getStatus() {
		return status;
	}
	public void setRemarks(String remarks) {
		this.remarks=remarks;
	}
	String  getRemarks() {
		return remarks;
	}
	
	float getSalary() {
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