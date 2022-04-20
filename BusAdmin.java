
package busReservationSystem4;

import java.util.*;

import employee.*;

public class BusAdmin extends Authentication{
	String Name;
	String address;
	String phno;
	static Map<String, String> customerComplaint=new HashMap<>();
	static List<PassengerDetails>passenger=new ArrayList<>();
	static Map<Integer, Driver> driverDetails=new HashMap<>();
	static Map<Integer, Cleaner> cleanerDetails=new HashMap<>();
	static Map<Integer, Supervisor> supervisorDetails=new HashMap<>();

	public BusAdmin(Map<String, String> passengerComplaint, List<PassengerDetails> busAndPassengerDetails,
			Map<Integer, Driver> driverDetails, Map<Integer, Cleaner> cleanerDetails, Map<Integer, Supervisor> supervisorDetails) {
		this.customerComplaint.putAll(passengerComplaint);
		this.passenger.addAll(busAndPassengerDetails);
		this.driverDetails=driverDetails;
		this.cleanerDetails=cleanerDetails;
		this.supervisorDetails=supervisorDetails;
		
	}
	public void setBusDetails(Map<Integer, Bus> busAvailability) {
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER BUS NUMBER");		
		int busNumber=sc.nextInt();
		int changingOption=sc.nextInt();
		boolean continuity=true;
		switch(changingOption) {
		case(1):
			System.out.println("ENTER NUMBER OF SEATS");
			busAvailability.get(busNumber).setNoOFSeats(sc.nextInt());
			break;
		case(2):
			System.out.println("ENTER FROM LOCATION");
		    busAvailability.get(busNumber).setFrom(sc.nextLine());
		    break;
		case(3):
			System.out.println("ENTER TO LOCATION");
		    busAvailability.get(busNumber).setTo(sc.nextLine());
		    break;
		case(4):
			System.out.println("ENTER DATE");
		    busAvailability.get(busNumber).setDate(sc.nextLine());
		    break;
		case(5):
			System.out.println("ENTER AC OR NON-AC");
		    busAvailability.get(busNumber).setac(sc.nextLine());
		    break;
		case(7):
			System.out.println("ENTER DRIVER NAME");
		    busAvailability.get(busNumber).setDriver(sc.nextLine());
		    break;
		case(8):
			continuity=false;
		    break;
		default:
			System.out.println("INVALID NUMBER");
		}
	}
	public void viewComplaint() {
		for(Map.Entry e:customerComplaint.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
	}
	public void viewFeedback(Map<String, String> passengerFeedback) {
		for(Map.Entry e:passengerFeedback.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
	}
	public void viewPassengerDetails() {
		System.out.println("ENTER BUS NUMBER");
		Scanner sc=new Scanner(System.in);
		int busNumber=sc.nextInt();
//		String date=sc.nextLine();
		for(PassengerDetails passengerDetails:passenger) {
			if(busNumber==passengerDetails.getBusNo()) {
				passengerDetails.showDetails();
			}
		}	
	}
	public void setEmployeeDetails() {
		System.out.println("ENTER 1 FOR DRIVER // ENTER 2 FOR CLEANER // ENTER 3 FOR SUPERVISOR");
		Scanner sc=new Scanner(System.in);
		int adminOption=sc.nextInt();
		if(adminOption==1) {
			System.out.println("ENTER ID NUMBER");
			int id=sc.nextInt();
//			System.out.println("PRESS 1 FOR CHANGE NAME//PRESS 2 FOR CHANGE AGE//PRESS 3 FOR CHANGE MAILID//PRESS 4 FOR CHANGE ADDRESS//PRESS 5 FOR CHANGE SALARY//PRESS 6 FOR CHANGE EXPERIENCE//PRESS 7 FOR CHANGE REMARKS");
			
			boolean continuity=true;
			while(continuity) {
				System.out.println("PRESS 1 FOR CHANGE NAME//PRESS 2 FOR CHANGE AGE//PRESS 3 FOR CHANGE MAILID//PRESS 4 FOR CHANGE ADDRESS//PRESS 5 FOR CHANGE SALARY//PRESS 6 FOR CHANGE EXPERIENCE//PRESS 7 FOR CHANGE REMARKS");
				int changingOption=sc.nextInt();
				sc.nextLine();
				switch(changingOption) {
				case(1):
					System.out.println("ENTER NAME");
					driverDetails.get(id).setname(sc.nextLine());
					break;
				case(2):
					System.out.println("ENTER age");
					driverDetails.get(id).setAge(sc.nextInt());
					break;
				case(3):
					System.out.println("ENTER MAIL-ID");
					driverDetails.get(id).setmailId(sc.nextLine());
					break;
				case(4):
					System.out.println("ENTER ADDRESS");
					driverDetails.get(id).setAddress(sc.nextLine());
					break;
				case(5):
					System.out.println("ENTER SALARY");
					driverDetails.get(id).setSalary(sc.nextFloat());
					break;
				case(6):
					System.out.println("ENTER EXPERIENCE");
					driverDetails.get(id).setExperience(sc.nextInt());
					break;
	
				case(7):
					System.out.println("ENTER RE-MARKS");
					driverDetails.get(id).setRemarks(sc.nextLine());
					break;
				case(8):
					continuity=false;
				    break;
				default:
					System.out.println("INVALID OPTION");
				}
			}
		}
		else if(adminOption==2) {
			System.out.println("ENTER ID NUMBER");
			int id=sc.nextInt();
//			System.out.println("PRESS 1 FOR CHANGE NAME//PRESS 2 FOR CHANGE AGE//PRESS 3 FOR CHANGE MAILID//PRESS 4 FOR CHANGE ADDRESS//PRESS 5 FOR CHANGE SALARY//PRESS 6 FOR CHANGE EXPERIENCE//PRESS 7 FOR CHANGE REMARKS");
			
			boolean continuity=true;
			while(continuity) {
				System.out.println("PRESS 1 FOR CHANGE NAME//PRESS 2 FOR CHANGE AGE//PRESS 3 FOR CHANGE MAILID//PRESS 4 FOR CHANGE ADDRESS//PRESS 5 FOR CHANGE SALARY//PRESS 6 FOR CHANGE EXPERIENCE//PRESS 7 FOR CHANGE REMARKS");
				int changingOption=sc.nextInt();
				sc.nextLine();
				switch(changingOption) {
				case(1):
					System.out.println("ENTER NAME");
					cleanerDetails.get(id).setname(sc.nextLine());
					break;
				case(2):
					System.out.println("ENTER age");
					cleanerDetails.get(id).setAge(sc.nextInt());
					break;
				case(3):
					System.out.println("ENTER MAIL-ID");
					cleanerDetails.get(id).setmailId(sc.nextLine());
					break;
				case(4):
					System.out.println("ENTER ADDRESS");
					cleanerDetails.get(id).setAddress(sc.nextLine());
					break;
				case(5):
					System.out.println("ENTER SALARY");
					cleanerDetails.get(id).setSalary(sc.nextFloat());
					break;
				case(6):
					System.out.println("ENTER EXPERIENCE");
					cleanerDetails.get(id).setExperience(sc.nextInt());
					break;
	
				case(7):
					System.out.println("ENTER RE-MARKS");
					cleanerDetails.get(id).setRemarks(sc.nextLine());
					break;	
				case(8):
					continuity=false;
				    break;
				default:
					System.out.println("INVALID NUMBER");
				}
			}
		}
		else if(adminOption==3) {
			System.out.println("ENTER ID NUMBER");
			int id=sc.nextInt();
			
			
			boolean continuity=true;
			while(continuity) {
				System.out.println("PRESS 1 FOR CHANGE NAME//PRESS 2 FOR CHANGE AGE//PRESS 3 FOR CHANGE MAILID//PRESS 4 FOR CHANGE ADDRESS//PRESS 5 FOR CHANGE SALARY//PRESS 6 FOR CHANGE EXPERIENCE//PRESS 7 FOR CHANGE REMARKS");
				int changingOption=sc.nextInt();
				sc.nextLine();
				switch(changingOption) {
				case(1):
					System.out.println("ENTER NAME");
					supervisorDetails.get(id).setname(sc.nextLine());
					break;
				case(2):
					System.out.println("ENTER age");
					supervisorDetails.get(id).setAge(sc.nextInt());
					break;
				case(3):
					System.out.println("ENTER MAIL-ID");
					supervisorDetails.get(id).setmailId(sc.nextLine());
					break;
				case(4):
					System.out.println("ENTER ADDRESS");
					supervisorDetails.get(id).setAddress(sc.nextLine());
					break;
				case(5):
					System.out.println("ENTER SALARY");
					supervisorDetails.get(id).setSalary(sc.nextFloat());
					break;
				case(6):
					System.out.println("ENTER EXPERIENCE");
					supervisorDetails.get(id).setExperience(sc.nextInt());
					break;
	
				case(7):
					System.out.println("ENTER RE-MARKS");
					supervisorDetails.get(id).setRemarks(sc.nextLine());
					break;
				case(8):
					continuity=false;
				    break;
				default:
					System.out.println("Enter invaild login details");
				}
			}
			
		}
	}
	public void viewEmployeeInfo() {
		System.out.println("ENTER 1 FOR ALL//ENTER 2 FOR DRIVER//ENTER 3 FOR CLEANER//ENTER 4 FOR SUPERVISOR");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		sc.nextLine();
		switch(option) {
		    case(1):
		    	for(Map.Entry driverInfo:driverDetails.entrySet()) {
		    		int idNo=(int) driverInfo.getKey();
		    		driverDetails.get(idNo).displayDetails();
					System.out.println(driverInfo.getKey()+" "+driverInfo.getValue());
				}
			    for(Map.Entry driverInfo:cleanerDetails.entrySet()) {
		    		int idNo=(int) driverInfo.getKey();
		    		cleanerDetails.get(idNo).displayDetails();
					System.out.println(driverInfo.getKey()+" "+driverInfo.getValue());
				}
			    for(Map.Entry driverInfo:supervisorDetails.entrySet()) {
		    		int idNo=(int) driverInfo.getKey();
		    		supervisorDetails.get(idNo).displayDetails();
					System.out.println(driverInfo.getKey()+" "+driverInfo.getValue());
				}
			    break;
		    case(2):
		    	for(Map.Entry driverInfo:driverDetails.entrySet()) {
		    		int idNo=(int) driverInfo.getKey();
		    		driverDetails.get(idNo).displayDetails();
					System.out.println(driverInfo.getKey()+" "+driverInfo.getValue());
				}
		        break;
		    case(3):
		    	for(Map.Entry driverInfo:cleanerDetails.entrySet()) {
		    		int idNo=(int) driverInfo.getKey();
		    		cleanerDetails.get(idNo).displayDetails();
					System.out.println(driverInfo.getKey()+" "+driverInfo.getValue());
				}
		        break;
		    case(4):
		    	for(Map.Entry driverInfo:supervisorDetails.entrySet()) {
		    		int idNo=(int) driverInfo.getKey();
		    		supervisorDetails.get(idNo).displayDetails();
					System.out.println(driverInfo.getKey()+" "+driverInfo.getValue());
				}
			    break;	
		}	
	}
}
