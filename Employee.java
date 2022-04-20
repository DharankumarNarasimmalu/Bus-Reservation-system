package employee;
public class Employee {
    protected String name;
    protected int age;
    protected long phoneNumber;
    protected String mailId;
    protected String address;
    String getname() {
		return name;	
	}
	public int getAge() {
		return age;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public String getMAilId() {
		return mailId;
	}
	public String getAddress() {
		return address;
	}
	public void setname(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setphNo(long phno) {
		this.phoneNumber=phno;
	}
	public void setmailId(String mail) {
		this.mailId=mail;
	}
	public void setAddress(String address) {
		this.address=address;
	}
    
}



