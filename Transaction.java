package busReservationSystem4;
import java.util.List;
import java.util.Scanner;

public class Transaction{
	Offers discountType;
	PaymentGateway billPayment;
	Transaction(Offers discount){
		this.discountType=discount;
	}
	public Transaction(PaymentGateway paymentType) {
		this.billPayment=paymentType;
		
	}
	int  wallet(int numberOfPassenger) {
		int points=numberOfPassenger*5;
		return points;	
	}
	public float[] discount(int busNo,int noOfPassenger, int walletPoint, int offerIdentification) {
		float finalAmount=0;
		int usedpoints=0;
		int passengerOfPayingBill=noOfPassenger;
		float cashBackRupees = 0;
		if(busNo==123) {
			int ticketamount=500;
			System.out.println("rupees per ticket "+ticketamount);
			finalAmount=discountType.discountingAmount(ticketamount, noOfPassenger)*noOfPassenger;
			System.out.println("Final amount "+finalAmount);
			cashBackRupees=discountType.chashBack(finalAmount);
		}
		else if(busNo==124) {			
			int ticketamount=250;
			System.out.println("rupees per ticket "+ticketamount);
			finalAmount=discountType.discountingAmount(ticketamount, noOfPassenger);
			cashBackRupees=discountType.chashBack(ticketamount);
		}
		else if(busNo==125) {			
			int ticketamount=300;
			System.out.println("rupees per ticket "+ticketamount);
			finalAmount=discountType.discountingAmount(ticketamount, noOfPassenger);
			cashBackRupees=discountType.chashBack(ticketamount);
		}
		if(offerIdentification==1) {
			((PongalOffer) discountType).getGift();
		}
		else if(offerIdentification==2) {
			passengerOfPayingBill=((DiwaliOffer) discountType).getFreeticket(noOfPassenger);
		}
		
		System.out.println("press 1 to use wallet points ||press 2 to continue");
		Scanner sc=new Scanner(System.in);
		int walletOption=sc.nextInt();
		if(walletOption==1) {
			finalAmount-=walletPoint;
			usedpoints=walletPoint;
		}
		else if(walletOption==2) {
			finalAmount=finalAmount;
			usedpoints=0;
		}
		float cashback=cashBackRupees;
		System.out.println("cashback amount: "+cashback);
		float []finalAmountAndWalletPoints= {(finalAmount)-cashBackRupees,(float)usedpoints};
		return finalAmountAndWalletPoints;
	}

	List<PassengerDetails> ticketCancellation(List<PassengerDetails> busAndPassengerDetails) {
		Scanner sc=new Scanner(System.in);
		int numberOfTicket=0;
		float amount=0;
		System.out.println("Enter bus number");
		int busNo=sc.nextInt();
		System.out.println("Enter name");
		String name =sc.nextLine();
		for(PassengerDetails passenger:busAndPassengerDetails) {
			if(busNo== passenger.getBusNo() && name.equals(passenger.getName())){
				busAndPassengerDetails.remove(passenger);
				numberOfTicket+=1;
				if(busNo==123) {
					amount+=500;
				}
				else if(busNo==124) {
					amount+=250;
				}
				else if(busNo==125) {
					amount+=300;
				}
			}
		}
		refund(amount);
		return busAndPassengerDetails;
		
	}
	void refund(float amount) {
		System.out.println("Rs."+amount+" is transfered to your account");
	}
	float []billPayment(float amount,int noOfPassenger) {
		
	    float netAmount=billPayment.payableMethod(amount);
	    int walletpoints=wallet(noOfPassenger);
	    float[]amountAndWallet= {walletpoints,netAmount};
		return amountAndWallet;
		
	}
	void showTicket(float netPayment, List<PassengerDetails> busAndPassengerDetails) {
		System.out.println("Passenger Details");
		for(PassengerDetails passenger:busAndPassengerDetails) {
			passenger.showDetails();
		}
		System.out.println("your bill amount"+netPayment);
		
	}

}
interface PaymentGateway{
	float payableMethod(float amount);
	void sendingOTPtoPhone();
	void verifingOTP();
}
class Upi implements PaymentGateway{

	public float payableMethod(float amount) {
		System.out.println("Enter password");
		Scanner sc=new Scanner(System.in);
		int pin=sc.nextInt();
		float netAmount=amount;
		return netAmount;
		
	}

	@Override
	public void sendingOTPtoPhone() {
		System.out.println("Sending otp to phone.......");
		
	}

	@Override
	public void verifingOTP() {
		// TODO Auto-generated method stub
		
	}
}
class NetBanking implements PaymentGateway{
	public float payableMethod(float amount) {
		System.out.println("Enter password");
		Scanner sc=new Scanner(System.in);
		String  pass=sc.nextLine();
		float netAmount = amount;
		if (amount>=500) {
			netAmount+=amount*0.01f;
		}
		return netAmount;
	}
	public void sendingOTPtoPhone() {
		System.out.println("Sending otp to phone.......");
		
	}
	@Override
	public void verifingOTP() {
		// TODO Auto-generated method stub
		
	}
}
class CardTransaction implements PaymentGateway{
	public float payableMethod(float amount) {
		System.out.println("enter card number");
		Scanner sc=new Scanner(System.in);
		long cardNo=sc.nextLong();
		System.out.println("Enter cvv number");
		int cvv=sc.nextInt();
		float netAmount=amount;
		if(amount>1000) {
			netAmount+=amount*0.05f;
		}
		return netAmount;		
	}
	public void sendingOTPtoPhone() {
		System.out.println("Sending otp to phone.......");
		
	}
	@Override
	public void verifingOTP() {
		// TODO Auto-generated method stub
		
	}
}
class Offers {
	float  discountingAmount(float amount,int NoOfPassenger ){
		float netAmount=0;
		if(NoOfPassenger>=5) {
			netAmount=amount-(amount*0.05f);
		}
		else {
			netAmount=amount;
		}
		return netAmount;
	}
	float chashBack(float amount) {
		float cashBackAmount=0;
		if(amount>=1000) {
			cashBackAmount=10;
		}
		else if(amount>=5000) {
			cashBackAmount=50;
		}
		if(cashBackAmount>0) {
		System.out.println("Congragulation you got an cash back of rs. "+cashBackAmount);
		}
		return cashBackAmount;		
	}
	void covidOffer() {
		System.out.println("upload your covaxin certificate to get upto 10% discount");
	}
}
class PongalOffer extends Offers{
	float discountingAmount(int NoOfPassenger,float amount) {
		System.out.println("great pongal discount");
		float netAmount=0;
		if(NoOfPassenger>=5) {
			netAmount=amount-amount*0.10f;
		}
		else {
			netAmount=amount;
		}
		return netAmount;	
	}
	void getGift() {
		System.out.println("enter coupen number to get exciting prize");
		Scanner sc=new Scanner(System.in);
		int giftCouponNumber=sc.nextInt();
	}
}
class DiwaliOffer extends Offers{
	float discountingAmount(int NoOfPassenger,float amount) {
		System.out.println("great pongal discount");
		float netAmount=0;
		if(NoOfPassenger>=5) {
			netAmount=amount-amount*0.20f;
		}
		else {
			netAmount=amount;
		}
		return netAmount;	
	}
	int getFreeticket(int NoOfPassenger) {
		System.out.println("book 4 ticket and get one ticket free");
		int totalPassenger=0;
		if(NoOfPassenger>=4) {
			totalPassenger=NoOfPassenger-1;
		}
		return totalPassenger;
	}
}
