package busReservationSystem4;

import java.util.Scanner;

public class LoginUser extends Authentication {
    int walletPoints;
//	private String name;
//	private String  age;
//	private String address;
//	private String phno;
//	private String id;
//	private String password;
//	LoginUser(Authentication verify){
//		System.out.println("wellcome to ABC Travellers");
//		this.verify=verify;
//	}
//	public LoginUser(String[] customerInfo,Reservation booking) {
//		this.name=customerInfo[0];
//		this.age=customerInfo[1];
//		this.address=customerInfo[2];
//		this.phno=customerInfo[3];
//		this.password=customerInfo[4];
//		this.booking=booking;
//		this.id=customerInfo[5];
//
//	}
	void setWalletPoints(int walletPoints) {
		this.walletPoints+=walletPoints;
	}
	int getWalletPoints() {
		return walletPoints;
	}
	void changeProfile() {
		Scanner sc=new Scanner(System.in);
		boolean end=true;
		while(end) {
		System.out.println("press 1 for change name||press 2 for change age||press 3 for change address||press 4 for change phonenumber||press 5 for change password||press 6 for save profile");
		int option=sc.nextInt();
		sc.nextLine();
		switch(option) {
		case(1):
			super.name=sc.nextLine();
		    break;
		case(2):
			super.age=sc.nextInt();
		    break;
		case(3):
			super.address=sc.nextLine();
		    break;
		case(4):
			super.phoneNumber=sc.nextLong();
		    break;
		case(5):
			super.password=sc.nextLine();
		    break;
		case(6):
			System.out.println("Saving.........");
		    end=false;
		    break;
		default:
			System.out.println("invalid number");
		}
		}	
	}
	
	String customerComplaint() {
		System.out.println("Type your complaint hear");
		Scanner sc=new Scanner(System.in);
		String complaint=sc.nextLine();
		return complaint;
	}
	
	String customerFeedback() {
		System.out.println("Type your feedback here");
		Scanner sc=new Scanner(System.in);
		String feedback=sc.nextLine();
		return feedback;
	}
	public void helpline() {
		System.out.println("dialing 9876543201........");
	}
	
}
