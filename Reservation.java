package busReservationSystem4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Reservation{
	List<PassengerDetails> gettingPassengerInfo(int busCapacity,int busNo) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number of seats required");
		int noOfSeatsRequired=sc.nextInt();
		sc.nextLine();
		List<PassengerDetails>passengerDetails=new ArrayList<>();
		if(checkingAvailability(busCapacity,noOfSeatsRequired)) {
			for(int i=0;i<noOfSeatsRequired;i++) {
				System.out.println("Enter passenger name");
				String name=sc.nextLine();
				System.out.println("Enter gender");
				String gender=sc.nextLine();
				System.out.println("Enter age");
				int age=sc.nextInt();
//				System.out.println("Enter preffered seat number");
//				String seat=sc.nextLine();
				sc.nextLine();
				passengerDetails.add(new PassengerDetails(name,gender,age,busNo));
				}
		}
		else {
			gettingPassengerInfo(busCapacity,busNo);
		}
		return passengerDetails;
	}
	
	boolean checkingAvailability(int busCapacity,int noOfSeats) {
		if (busCapacity>=noOfSeats) {
			return true;
		}
		else {
			System.out.println("Sorry Seat is not available");
			return false;
		}
	}

	public List<PassengerDetails> searchBus(Map<Integer, Bus> busAvailability){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter from location");
		String from=sc.nextLine();
		System.out.println("Enter to location");
		String to=sc.nextLine();
		System.out.println("Enter Date in formate of dd/mm/yyyy");
		String date=sc.nextLine();
		boolean availableBus=false;
		for(Map.Entry e:busAvailability.entrySet()) {
			int busNo=(int)e.getKey();
			if(busAvailability.get(busNo).getFrom().equals(from) && busAvailability.get(busNo).getTo().equals(to) && busAvailability.get(busNo).getDate().equals(date)) {
				availableBus=true;
				System.out.println("bus number: "+busNo);
				busAvailability.get(busNo).showBusDetails();
			}
			
		}
		System.out.println("Enter bus no for booking");
		int busNumber=sc.nextInt();
		int busCapacity=busAvailability.get(busNumber).getNoOFSeats();
		List<PassengerDetails> passengerDetailsOfChoosedBus=gettingPassengerInfo(busCapacity,busNumber);
		busAvailability.get(busNumber).setNoOFSeats(busCapacity-passengerDetailsOfChoosedBus.size());
		return passengerDetailsOfChoosedBus;

	}





}


