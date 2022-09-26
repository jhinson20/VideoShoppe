package VShoppe;

import java.util.ArrayList;

public class DBtestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		VshoppeDatabase vDataBaseLookup= new VshoppeDatabase();
		String vLookup="Act Johnson";
		ArrayList<DVDStock> dvdReturn;
		dvdReturn =vDataBaseLookup.getDVDShop(vLookup);
		DVDStock dvdView;
		for (int i=0; i<dvdReturn.size();i++) {
			dvdView=dvdReturn.get(i);
			System.out.println(dvdView.toString());
		}
		vLookup="3";
		ArrayList<Customer> custReturn;

		custReturn =vDataBaseLookup.getCustomer(vLookup);
		Customer custView;
		for (int i=0;i<custReturn.size();i++) {
			custView=custReturn.get(i);
			System.out.println(custView.toString());
			System.out.println(" Credit " +vDataBaseLookup.isCustomerCreditValid(custView));
			System.out.println(" LIMIT " +vDataBaseLookup.isCustomerLimitValid(custView));
			}
		int inventory = vDataBaseLookup.rentDVD(dvdReturn.get(2),custReturn.get(2));
		System.out.println(inventory);
		inventory = vDataBaseLookup.rentDVD(dvdReturn.get(5),custReturn.get(1));
		System.out.println(inventory);
		inventory = vDataBaseLookup.returnDVD(66);
		System.out.println(inventory);
		
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
}

