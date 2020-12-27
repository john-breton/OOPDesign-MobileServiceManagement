package bundlemanagement.pac;
import bundlemanagement.component.*;

public class PaCTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//first customer
		//bare bone service 10$
		PaCBundle customer0= new BareBonePhoneService();
		System.out.println("Your paln: "+customer0.getDescription()+", total amount "+customer0.cost());
		
		//second customer
		//bare bone service 10$
		//platinum calling plan 40$
		//silver messaging plan 25$
		//data plan 20$
		PaCBundle customer1=new BareBonePhoneService();
		customer1=new PlatinumCallingPLan(customer1);
		customer1=new SilverMessagingPLan(customer1);
		customer1=new BronzeDataPLan(customer1);
		System.out.println("Your Plan: "+customer1.getDescription()+", total amount $"+customer1.cost());
		
		
	}

}
