package VShoppe;

import java.util.zip.DataFormatException;

public class Customer extends DataBaseTable{
	private int CustomerID;
	private String DLNumber;
	private String FirstName;
	private String LastName;
	private String dateOfBirth;
	private String address;
	private String PhoneNumber;
	private String email;

	public Customer(){

	}
	public Customer(String[] customer) throws Exception {
		if (customer.length!=8) throw new DataFormatException("Invalid Customer Array");
		setCustomerID(Integer.valueOf(customer[0]));
		setDLNumber(customer[1]);
		setFirstName(customer[2]);
		setLastName(customer[3]);
		setDateOfBirth(customer[4]);
		setAddress(customer[5]);
		setPhoneNumber(customer[6]);
		setEmail(customer[7]);
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public int setPhoneNumber(String PhoneNumber) {
		int FieldLength=15;
		int isValid=ValidateString(PhoneNumber,FieldLength);
		if (isValid<0) return isValid;
		this.PhoneNumber = PhoneNumber;
		return isValid;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public int setCustomerID(int customerID) {
		if (Integer.valueOf(customerID)<0) return -1;
		CustomerID = customerID;
		return 0;
	}
	public String getDLNumber() {
		return DLNumber;
	}
	public int setDLNumber(String dLNumber) {
		int FieldLength=11;
		int isValid=ValidateString(dLNumber,FieldLength);
		if (isValid<0) return isValid;
		
		DLNumber = dLNumber;
		return isValid;

	}
	public String getFirstName() {
		return FirstName;
	}
	public int setFirstName(String FirstName) {
		int FieldLength=25;
		int isValid=ValidateString(FirstName,FieldLength);
		if (isValid<0) return isValid;
		
		this.FirstName = FirstName;
		return isValid;
	}
	public String getLastName() {
		return LastName;
	}
	public int setLastName(String LastName) {
		int FieldLength=25;
		int isValid=ValidateString(LastName,FieldLength);
		if (isValid<0) return isValid;
		this.LastName = LastName;
		return isValid;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public int setDateOfBirth(String dateOfBirth) {
		int isValid=0;
		this.dateOfBirth = dateOfBirth;
		return isValid;

	}
	public String getAddress() {
		return address;
	}
	public int setAddress(String address) {
		int FieldLength=40;
		int isValid=ValidateString(address,FieldLength);
		if (isValid<0) return isValid;

		this.address = address;
		return isValid;

	}
	public String getEmail() {
		return email;
	}
	public int setEmail(String email) {
		int FieldLength=60;
		int isValid=ValidateString(email,FieldLength);
		if (isValid<0) return isValid;

		this.email = email;
		return isValid;

	}
	public String toString() {
		String customerString="";
		customerString=customerString + this.getCustomerID() + " " 
				+ this.getDLNumber() + " " 
				+ this.getFirstName() + " " 
				+ this.getLastName() + " " 
				+ this.getDateOfBirth() + " " 
				+ this.getAddress() + " " 
				+ this.getPhoneNumber() + " " 
				+ this.getEmail() + " " ;
		return customerString;
	}
}
