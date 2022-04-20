package busReservationSystem4;
import java.util.List;

import java.util.Scanner;
public class Authentication{

	protected String name;
	protected int age;
	protected String address;
	protected long phoneNumber;
	protected String password;
	public Authentication() {
		System.out.println("Welcome to ABC travels");
  
	}
	public Authentication(String name, int age, String address, long phoneNo, String password){
		this.name=name;
		this.age=age;
		this.address=address;
		this.phoneNumber=phoneNo;
		this.password=password;
	}
	boolean login(String userName, String password) {
		if(userName.equals(name)&&password.equals(this.password)) {
			return true;
		}
		else {
		return false;
		}
	}
	
	void logout() {
		System.out.println("Thanking of choosing out service");
		System.out.println("Press 1 for remember password||Press 2 for exit");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		switch(option) {
			case(1):
				System.out.println("remember password");
			    break;
			case(2):
				System.out.println("Does not remember password");
			    break;
		}
	}
	void forgetPassword(String userName) {
		if(userName.equals(name)) {
			if(phnoVerifing()) {
			    while(true) {
			        System.out.println("Enter new password");
			        Scanner sc=new Scanner(System.in);
			        String newPassword=sc.nextLine();
			        System.out.println("Re-type password");
			        String confirmPassword=sc.nextLine();
			        if(newPassword.equals(confirmPassword)) {
				        this.password=newPassword;
				        captchaVerification();
				        iamNotRobot();
				        break;
			        }
		        }
			}
		    else {
			System.out.println("wrong phoneNumber");
			forgetPassword(userName);
		    }			
		}
	}
	void captchaVerification() {
		String autoCaptcha="Xx213";
		System.out.println(autoCaptcha);
		System.out.println("Enter the above captcha");
		Scanner sc=new Scanner(System.in);
		String captcha=sc.nextLine();
		if(autoCaptcha.equals(captcha)) {
			return;
		}
		else {
			System.out.println("Your captcha is wrong");
			captchaVerification();
		}	
	}
	void iamNotRobot() {
		System.out.println("press 1 for Iam not Robot");
		Scanner sc=new Scanner(System.in);
		int robot=sc.nextInt();
		if (robot==1) {
			
		System.out.println("Iam not Robot<>");
		}
		else {
			iamNotRobot();
		}
	}
	boolean phnoVerifing() {
		System.out.println("verify phone number...");
		Scanner sc=new Scanner(System.in);
		long  phoneNo=sc.nextLong();
		if(phoneNo==phoneNumber){
			return true;
		}
		else {
		return false;
		}
	}
	public String getName() {
		return name;
	}
}
