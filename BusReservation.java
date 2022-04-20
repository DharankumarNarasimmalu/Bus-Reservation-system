package busReservationSystem4;
import java.util.*;
import employee.*;
//customerLogin[5]=customerId;
public class BusReservation {
	public static void main(String...args) {
		Scanner sc=new Scanner(System.in);
		
		List<Authentication>customerLogin=new ArrayList<>();
		Authentication user1=new Authentication("Dharan",20,"149,K........cuddalore",9876543201l,"1234");
		Authentication user2=new Authentication("Kumar",19,"148,K........chennai",10234567894l,"4321");
		Authentication user3=new Authentication("Karthic",21,"150,K........coimbatore",9876543201l,"2589");
		customerLogin.add(user1);
		customerLogin.add(user2);
		customerLogin.add(user3);
		List<Authentication>adminLogin=new ArrayList<>();
		adminLogin.add(new Authentication("Dharankumar",20,"149,K........cuddalore",9876543201l,"1234"));
		Map<Integer,Driver>driverDetails=new HashMap<>();
		driverDetails.put(1,new Driver("Surya",20,9876543201l,"rahul@gmail.com","149,.......cuddalore",20000,2,123,"good","driver"));
		driverDetails.put(2,new Driver("Karthic",20,9876543201l,"rahul@gmail.com","149,.......cuddalore",20000,2,123,"good","driver"));
		driverDetails.put(3,new Driver("Vijay",20,9876543201l,"rahul@gmail.com","149,.......cuddalore",20000,2,123,"good","driver"));
		Map<Integer,Cleaner>cleanerDetails=new HashMap<>();
		cleanerDetails.put(4,new Cleaner("Ajith",20,9876543201l,"rahul@gmail.com","149,.......cuddalore",20000,2,123,"good","cleaner"));
		cleanerDetails.put(5,new Cleaner("Kamal",20,9876543201l,"rahul@gmail.com","149,.......cuddalore",20000,2,123,"good","cleaner"));
		Map<Integer,Supervisor>supervisorDetails=new HashMap<>();
		supervisorDetails.put(6,new Supervisor("Rajini",20,9876543201l,"rahul@gmail.com","149,.......cuddalore",20000,123,"good","supervisor"));
		

		Map<Integer,Bus>busAvailability=new HashMap<>();
		Bus bus1=new Bus(50,"Cuddalore","Chennai","25/04/2022","AC","driverName");
		Bus bus2=new Bus(19,"Chennai","Banglore","26/04/2022","NONAC","driverName");
		Bus bus3=new Bus(21,"Coimbatore","Tiruchi","26/04/2022","AC","driverName");
		busAvailability.put(123, bus1);
		busAvailability.put(124, bus2);
		busAvailability.put(125, bus3);
		
		
   		Map<String,String> passengerFeedback = new HashMap<>();
  		Map<String,String>passengerComplaint=new HashMap<>();
		List<PassengerDetails>busAndPassengerDetails = new ArrayList<>();
		
		int walletPoints=0;
		int offerIdentification=0;
		
//		BusAdmin busAdmin=new BusAdmin(passengerComplaint,passengerFeedback,busAndPassengerDetails);
		
//		Authentication user=new Authentication();
		LoginUser user=new LoginUser();
		
		Offers discount=new Offers();
		
		LoginUser customer;
		
		Reservation booking =new Reservation();
		
    	while(true) {
  
            BusAdmin busAdmin=new BusAdmin(passengerComplaint,busAndPassengerDetails,driverDetails,cleanerDetails,supervisorDetails);
            passengerComplaint.clear();
            busAndPassengerDetails.clear();
		    System.out.println("Press 1 for passenger||Press 2 for admin");
		    int option=sc.nextInt();
		    Transaction payment=new Transaction(discount);
		    int loginuser=-1;
		
		    if(option==1) {
			    customer=new LoginUser();
				System.out.println("Press 1 for login||Press 2 for signup||press 3 for forgetpassword");
			    int passengerOption=sc.nextInt();
			    sc.nextLine();
			    if (passengerOption==1) {
					System.out.println("Enter Username");
					String userName=sc.nextLine();
					System.out.println("Enter password");
					String password=sc.nextLine();
			    	for(Authentication logindetails:customerLogin) {
			    		boolean login=logindetails.login(userName,password);
			    		if(login) {
			    			loginuser=customerLogin.indexOf(logindetails);
			    			System.out.println(logindetails.name+" "+logindetails.password);
			    			break;
			    		}
			    		else {
			    			continue;
			    		}
			    		
			    	}
			   
			        if(loginuser>=0) {			        	
				        System.out.println("Password is correct "+loginuser);
				        LoginUser details=new LoginUser();//passenger class
				        int busNo = 0;
				        int noOfSeatsRequired=0;
				        boolean login=true;
				        while(login) {
				            System.out.println("Press 1 for booking ||press 2 for complaint||press 3 for feedabck||press 4 to change profile||press 5 for ticket cancellation||press 6 for see location of bus||for help line press 7||press 8 for logout");
				            int userfunction=sc.nextInt();

				            switch(userfunction) {
				            case(1):
					        	busAndPassengerDetails=booking.searchBus(busAvailability);
					        	noOfSeatsRequired=busAndPassengerDetails.size();
					        	for(PassengerDetails passenger:busAndPassengerDetails) {
					        		busNo=passenger.getBusNo();
					        		break;
					        	}

				                break;
				            case(2):
					        	String complaint=details.customerComplaint();
				                String nameofComplaintGiven=customerLogin.get(loginuser).getName();
					            passengerComplaint.put(nameofComplaintGiven, complaint);
					            break;
				            case(3):
					        	String feedback=details.customerFeedback();
				                String nameofFeedbackGiven=customerLogin.get(loginuser).getName();
					             passengerFeedback.put(nameofFeedbackGiven, feedback);
					            break;
				            case(4):
				            	customer.changeProfile();
					            break;
					        case(5):
					        	busAndPassengerDetails=payment.ticketCancellation(busAndPassengerDetails);
					            break;
					        case(6):
					        	//location
//					        	
					            break;
					        case(7):
					        	details.helpline();
					            break;
					        case(8):
					        	login=false;				    	
					    	    customerLogin.get(loginuser).logout();
					    	    break;
					 
					        default:
					        	System.out.println("invalid option");
					        }
				        if(busNo!=0) {
				        	walletPoints=user.getWalletPoints();				        	
				        	float []amountAndUsedPoints=payment.discount(busNo,busAndPassengerDetails.size(),walletPoints,offerIdentification);
				        	PaymentGateway paymentType = null;
				        	System.out.println("Press 1 for UPI||Press 2 for NetBanking||Press 3 for CardTransaction");
				        	int paymentOption=sc.nextInt();
				        	float  netPayment=0;
				        	switch(paymentOption) {
				        	case(1):
				        		paymentType=new Upi();

				        	    break;				        	
				        	case(2):
				        		paymentType=new NetBanking();

				        	    break;
				        	case(3):
				        		paymentType=new CardTransaction();

				        	    break;
				        	default:
				        		System.out.println("Invalid option");				        	
				        	}
				        	Transaction bill=new Transaction(paymentType);
				        	float AmountAndwalletPoints[]=bill.billPayment(amountAndUsedPoints[0],noOfSeatsRequired);
				        	netPayment=AmountAndwalletPoints[1];
				        	payment.showTicket(netPayment,busAndPassengerDetails);
				        	int walletpoint=(int)AmountAndwalletPoints[0];
				        	user.setWalletPoints(walletpoint);
				        	busNo=0;
				        	
				        }
			        }
		        }
			        else{
				        System.out.println("Please check login details");
				    }
			    }
			    else if(passengerOption==2) {
			    	//sign up method
			    	System.out.println("Enter name");
			    	String name=sc.nextLine();
			    	System.out.println("Enter age");
			    	int age=sc.nextInt();
			    	sc.nextLine();
			    	System.out.println("Enter address");
			    	String address=sc.nextLine();
			    	System.out.println("Enter phone Number");
			    	long phNo=sc.nextLong();
			    	sc.nextLine();
			    	while(true) {
			    	System.out.println("Enter Password");
			    	String password=sc.nextLine();
			    	System.out.println("Re-type password");
			    	String confirmPassword=sc.nextLine();
			    	if(password.equals(confirmPassword)){
			    		while(true) {
			    		System.out.println("verify phone number");
			    		long phoneNumberVerify=sc.nextLong();
			    		if(phoneNumberVerify==phNo) {
			    			user.captchaVerification();
			    			user.iamNotRobot();
			    			customerLogin.add(new Authentication(name,age,address,phNo,password));	
			    			break;
			    		}
			    		else {
			    			System.out.println("Wrong phone number");

			    		}
			    	}
			    		break;
			    }
			    	else {
			    		System.out.println("password does not match");
			    	}
			    	}
		    }
			    else if(passengerOption==3) {
			    	System.out.println("Enter userName");
			    	String userName=sc.nextLine();
			    	for(Authentication userdetails:customerLogin) {
			    		userdetails.forgetPassword(userName);
			    	}			    				    	
			    }
		}   
		else if(option==2) {
			
			int adminuser=-1;     

			sc.nextLine();
			System.out.println("ENTER 1 FOR LOGIN||ENTER 2 FOR SIGNUP||ENTER 3 FOR FORGETPASSWORD");
			int adminOption=sc.nextInt();
			sc.nextLine();
			if(adminOption==1) {
				System.out.println("Enter AdminName");
				String adminName=sc.nextLine();
				System.out.println("Enter password");
				String password=sc.nextLine();
				for(Authentication adminDetails:adminLogin) {
					boolean login=adminDetails.login(adminName,password);
		    		if(login) {
		    			adminuser=adminLogin.indexOf(adminDetails);
		    			System.out.println("Password is correct");
		    			break;
		    		}
		    		else {
		    			continue;
		    		}
				}
				System.out.println(adminuser);
		        if(adminuser>=0) {
			        System.out.println("Password is correct "+adminuser);
	
			    boolean adminLogout=true;
			    while(adminLogout) {
			        System.out.println("Enter 1 for discount ||Enter 2 for set Bus||Press 3 for view customer Complaint||press 4 for view customer feedback||press 5 for getting passenger info||press 6 for logout");
			    int adminOpt=sc.nextInt();
			    switch(adminOpt) {
			    case(1):
			        System.out.println("press 1 for pongal offer||press 2 for greatoffer||press 3 for Republicday Offer");
			        int discountOption=sc.nextInt();
			        switch(discountOption) {
			        case(1):
			        	discount=new PongalOffer();
			            offerIdentification=1;
			            break;
			        case(2):
			        	discount=new DiwaliOffer();
			            offerIdentification=2;
			            break;
			        case(3):
			        	discount=new Offers();
			            offerIdentification=0;
			            break;
			        default:
			        	System.out.println("Invalid option");
			        }
			        break;
			    case(2)://set bus
			    	busAdmin.setBusDetails(busAvailability);
			    	break;
			    case(3)://add bus
//			    	50,"Cuddalore","Chennai","25/04/2022","AC","driverName"
			    	System.out.println("ENTER BUS NUMBER");
			        int busNumber=sc.nextInt();
			    	System.out.println("ENTER NUMBER OF SEATS");
			        int capacity=sc.nextInt();
			        System.out.println("ENTER FROM LOCATION");
			        String fromLocation=sc.nextLine();
			        System.out.println("ENTER TO LOCATION");
			        String toLocation=sc.nextLine();
			        System.out.println("ENTER DATE");
			        String date=sc.nextLine();
			        System.out.println("ENTER AC OR NON AC");
			        
			        String ac=sc.nextLine();
			        System.out.println("ENTER DRIVER NAME");
			        String driver=sc.nextLine();
			    	busAvailability.put(busNumber,new Bus(capacity,fromLocation,toLocation,date,ac,driver));
			    	break;
		        case(4):
			    	busAdmin.viewComplaint();
			        break;
			    case(5):
			    	busAdmin.viewFeedback(passengerFeedback);
			        break;
			    case(6)://passenger info
			        busAdmin.viewPassengerDetails();
			        break;
			    case(7):
			    	busAdmin.setEmployeeDetails();//set employee info
			    	break;
			    case(8)://view employee info
			    	busAdmin.viewEmployeeInfo();
			    	break;
			    case(9)://pay salary
			    	break;
			    case(10)://add employee
			    	break;
			    case(11):
			    	adminLogin.get(adminuser).logout();
			        adminLogout=false;
			        break;
			    }
		    }
			    }
		        else{
			        System.out.println("Please check login details");
			        }
		        }
		    else if(adminOption==2) {
		    	//sign up method
		    	
		    	System.out.println("Enter name");
		    	String name=sc.nextLine();
		    	System.out.println("Enter age");
		    	int age=sc.nextInt();
		    	sc.nextLine();
		    	System.out.println("Enter address");
		    	String address=sc.nextLine();
		    	System.out.println("Enter phone Number");
		    	long phNo=sc.nextLong();
		    	sc.nextLine();
		    	while(true) {
		    	System.out.println("Enter Password");
		    	String password=sc.nextLine();
		    	System.out.println("Re-type password");
		    	String confirmPassword=sc.nextLine();
		    	if(password.equals(confirmPassword)){
		    		while(true) {
		    		System.out.println("verify phone number");
		    		long phoneNumberVerify=sc.nextLong();
		    		if(phoneNumberVerify==phNo) {
		    			user.captchaVerification();
		    			user.iamNotRobot();
		    			adminLogin.add(new Authentication(name,age,address,phNo,password));	
		    			break;
		    		}
		    		else {
		    			System.out.println("Wrong phone number");

		    		}
		    	}
		    		break;
		    }
		    	else {
		    		System.out.println("password does not match");
		    	}
		    	}
	        }
		    else if(adminOption==3) {
		    	System.out.println("Enter userName");
		    	String userName=sc.nextLine();
		    	for(Authentication admindetails:adminLogin) {
		    		admindetails.forgetPassword(userName);
		    	}
		    }
		    }
	    }
	}
}