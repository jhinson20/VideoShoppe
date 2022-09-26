package VShoppe;
import java.sql.*;
import java.util.ArrayList;



public class VshoppeDatabase {
	String vSchema="vshoppe";
	String vUser="vshoppe";
	String vPassword ="vshoppe";
	//Default Constructor
	public VshoppeDatabase() {
		
	}
	// Constructor that accepts alternate Schema name, User/Password
	public VshoppeDatabase(String newSchema,String newUser,String newPassword) {
		vSchema=newSchema;
		vUser=newUser;
		vPassword=newPassword;
	}
	public int saveCustomer(Customer savedCustomer) {
	
	
		
		

		if(savedCustomer.getCustomerID()==0) return addCustomer(savedCustomer);
		if(savedCustomer.getCustomerID()>0) return updateCustomer(savedCustomer);
		return -1;
	}
	public int addCustomer(Customer savedCustomer) {

		try{
			//Instantiate Database connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+vSchema,vUser,vPassword);
		Statement stmt =con.createStatement();
		String sqlStatement="INSERT INTO Customer "
				+ 			 "(DLNumber, FName, LName, DateOfBirth, Address, PNumber, EmailAddress) "
				+ "Values     ( ";

		sqlStatement=sqlStatement + " \"" + savedCustomer.getDLNumber()+ "\" ,";//Drivers License
		sqlStatement=sqlStatement + " \"" + savedCustomer.getFirstName() + "\" ,";  // First Name
		sqlStatement=sqlStatement + " \"" + savedCustomer.getLastName()+ "\" , ";// Last Name
		sqlStatement=sqlStatement + "  DATE (\"" +savedCustomer.getDateOfBirth() + "\"), ";
		sqlStatement=sqlStatement + "  \"" + savedCustomer.getAddress()+ "\" ,";// Address
		sqlStatement=sqlStatement + "  \"" + savedCustomer.getPhoneNumber() + "\" , ";// PhoneNumber
		sqlStatement=sqlStatement + "  \"" + savedCustomer.getEmail() + "\"  ";// Email
	
		sqlStatement = sqlStatement + " ) ;";

		stmt.execute(sqlStatement);
		sqlStatement="SELECT CustomerID FROM customer WHERE DLNumber= \"" + savedCustomer.getDLNumber() + "\" AND PNumber =\"" + savedCustomer.getPhoneNumber() + "\";";
		ResultSet rs = stmt.executeQuery(sqlStatement);
		rs.next();
		int returnCustomerID = rs.getInt(1);
		savedCustomer.setCustomerID(returnCustomerID);
		return returnCustomerID;
		
		}catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}
	public int updateCustomer(Customer savedCustomer) {
		try{
			//Instantiate Database connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+vSchema,vUser,vPassword);
		Statement stmt =con.createStatement();
		// Build Update statement
		String sqlStatement="UPDATE Customer SET ";
		sqlStatement=sqlStatement + "DLNumber = \"" + savedCustomer.getDLNumber() + "\" ,";
		sqlStatement=sqlStatement + "FName = \"" + savedCustomer.getFirstName() + "\" ,";
		sqlStatement=sqlStatement +  "LName = \"" + savedCustomer.getLastName() + "\", ";
		sqlStatement=sqlStatement +  "DateOfBirth = DATE (\"" +savedCustomer.getDateOfBirth() + "\"), ";
		sqlStatement=sqlStatement + "Address = \"" + savedCustomer.getAddress()+ "\" ,";
		sqlStatement=sqlStatement + "PNumber = \"" + savedCustomer.getPhoneNumber() + "\" , ";
		sqlStatement=sqlStatement + "EmailAddress = \"" + savedCustomer.getEmail() + "\"  ";
	
		sqlStatement = sqlStatement + " WHERE CustomerID= "+ savedCustomer.getCustomerID() +" ;";
		

		stmt.execute(sqlStatement);
		
		return 0;
		}catch (Exception e) {
			System.out.println(e);
		}		
		return -1;
	}
		
	public ArrayList<Customer> getCustomer(String search){

		if (search.length()==0) return null; // Null String No results
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try{
			//Instantiate Database connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+vSchema,vUser,vPassword);
		Statement stmt =con.createStatement();
		String searchParse="";
		//Build SQL
		String custLookup="SELECT * "
						+ " FROM customer"
						+ " WHERE ";
		int stringCounter=0;
		for (int i=0 ; i<search.length();i++) {
			//Safety check  Letters numbers only
			if (search.charAt(i)==' ' && searchParse.length()>0) { //Check space terminated
				if (stringCounter>0) custLookup =custLookup + " OR ";
				else stringCounter++;
					
				custLookup= custLookup + "DLNumber LIKE \"%" + searchParse+"%\"" + 
						" OR FName LIKE \"%" + searchParse+ "%\"" + 
						" OR Lname LIKE \"%" + searchParse+ "%\"";
				searchParse="";
			}
			if ( (search.charAt(i)>=48 && search.charAt(i)<=59)||
					(search.charAt(i)>=65 && search.charAt(i)<=90)||
					(search.charAt(i)>=97 && search.charAt(i)<=122)) {
				
				searchParse=searchParse +search.charAt(i);
			}	
		}
		if ( searchParse.length()>0) { //Check space terminated
			if (stringCounter>0) custLookup =custLookup + " OR ";
			else stringCounter++;
				
			custLookup= custLookup + "DLNumber LIKE \"%" + searchParse+"%\"" + 
					" OR FName LIKE \"%" + searchParse+ "%\"" + 
					" OR Lname LIKE \"%" + searchParse+ "%\"";
		}		
			//Terminate SQL statement
		custLookup=custLookup + ";";
		if (stringCounter==0) return null;
		ResultSet rs = stmt.executeQuery(custLookup);
		//Get Record count
		int rowCounter=0;
		while (rs.next()) {
			rowCounter++;
				
		}
		rs = stmt.executeQuery(custLookup);
		//no records returned
		if (rowCounter==0) return null;
		//Populate Array
		Customer newCustomer;
		String[] custReturnArray =new String[8];
		for (int i=0;i<rowCounter;i++) {
			rs.next();
			for (int j=0;j<8;j++) {

				custReturnArray[j]=rs.getString(j+1);
			}
			newCustomer= new Customer(custReturnArray);
			customers.add(newCustomer);
		}
		return customers;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
}
	public int verifyPassword(String username, String password) {
		if (username.length()==0 || password.length()==0) return 0; // Null String No results
		try{
			//Instantiate Database connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+vSchema,vUser,vPassword);
		Statement stmt =con.createStatement();
	
		//Build SQL
		String userLookup="SELECT * "
						+ " FROM Employee"
						+ " WHERE "
						+ " Username = '" + username + "'" 
						;
	
		//Terminate SQL statement
		userLookup=userLookup + ";";
		ResultSet rs = stmt.executeQuery(userLookup);
		//Get Record count
		int rowCounter=0;
		while (rs.next()) {
			rowCounter++;
				
		}
		//reload data view from count
		rs = stmt.executeQuery(userLookup);
		//no records returned
		if (rowCounter==0) {

			return -1;
		}

		else 
		{
			rs.next();  							  // Move to first record(only record)
			String returnedPassword=rs.getString(8);   // get password
			returnedPassword=returnedPassword.trim();  // trim trailing spaces from stored password
			if (password.equals(returnedPassword))
			{
					
				int userLevel= 	 Integer.valueOf(rs.getString(9));
				return userLevel;
			}
			else
			{
				return -1;
			}
		}
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return -1;
	}

	public ArrayList<DVDStock> getDVDShop(String search){

		if (search.length()==0) return null; // Null String No results
		ArrayList<DVDStock> inventory = new ArrayList<DVDStock>();
		try{
			//Instantiate Database connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+vSchema,vUser,vPassword);
		Statement stmt =con.createStatement();
		String searchParse="";
		//Build SQL
		String ActorLookup=" select distinct DVDMovie.MovieID "
				+ " from dvdMovie "
				+ " inner join actors"
				+ " on DVDMovie.MovieID=actors.MovieID"
				+ " inner join movieperson "
				+ " on actors.personID=movieperson.personID "
				+ " where ";
		String DirectorLookup=" select distinct DVDMovie.MovieID "
				+ " from dvdMovie "
				+ " inner join directors"
				+ " on DVDMovie.MovieID=directors.MovieID"
				+ " inner join movieperson "
				+ " on directors.personID=movieperson.personID"
				+ " where ";
		String ProducerLookup=" select distinct DVDMovie.MovieID "
				+ " from dvdMovie "
				+ " inner join producers"
				+ " on DVDMovie.MovieID=producers.MovieID"
				+ " inner join movieperson "
				+ " on producers.personID=movieperson.personID"
				+ " where ";
		String GenreLookup = " select  DVDMovie.MovieID"
				+ " from dvdMovie"
				+ " inner join genres"
				+ " on dvdmovie.movieID=genres.movieID"
				+ " inner join moviegenre"
				+ " on moviegenre.genreID=genres.genreID"
				+ " where ";
		String DVDLookup=" SELECT DVDMovie.MovieID "
						+ " FROM DVDMovie"
						+ " WHERE ";
		int stringCounter=0;
		for (int i=0 ; i<search.length();i++) {
			//Safety check  Letters numbers only
			if (search.charAt(i)==' ' && searchParse.length()>0) { //Check space terminated
				if (stringCounter>0) {
					DVDLookup = DVDLookup + " OR ";
					ActorLookup= ActorLookup + " OR ";					
					DirectorLookup = DirectorLookup + " OR ";
					ProducerLookup= ProducerLookup + " OR ";
					GenreLookup = GenreLookup + " OR ";
					
					
				}
				else stringCounter++;
				ActorLookup= ActorLookup + " Name LIKE \"%" + searchParse+"%\"" ;			
				DirectorLookup = DirectorLookup + " Name LIKE \"%" + searchParse+"%\"" ;
				ProducerLookup= ProducerLookup + " Name LIKE \"%" + searchParse+"%\"" ;
				GenreLookup = GenreLookup + " Genre LIKE \"%" + searchParse+"%\"" ;
				DVDLookup= DVDLookup + " Title LIKE \"%" + searchParse+"%\"" ;
				
				searchParse="";
			}
			if ( (search.charAt(i)>=48 && search.charAt(i)<=59)||
					(search.charAt(i)>=65 && search.charAt(i)<=90)||
					(search.charAt(i)>=97 && search.charAt(i)<=122)) {
				
				searchParse=searchParse +search.charAt(i);
			}	
		}
		if ( searchParse.length()>0) { //Check space terminated
			if (stringCounter>0){
				DVDLookup = DVDLookup + " OR ";
				ActorLookup= ActorLookup + " OR ";					
				DirectorLookup = DirectorLookup + " OR ";
				ProducerLookup= ProducerLookup + " OR ";
				GenreLookup = GenreLookup + " OR ";
				
				
			}
			else stringCounter++;
				
			ActorLookup= ActorLookup + " Name LIKE \"%" + searchParse+"%\"" ;			
			DirectorLookup = DirectorLookup + " Name LIKE \"%" + searchParse+"%\"" ;
			ProducerLookup= ProducerLookup + " Name LIKE \"%" + searchParse+"%\"" ;
			GenreLookup = GenreLookup + " Genre LIKE \"%" + searchParse+"%\"" ;
			DVDLookup= DVDLookup + " Title LIKE \"%" + searchParse+"%\"" ;
			
		}	
		
			//Terminate SQL statement
		DVDLookup=DVDLookup + " OR ";
		//Append Actor Lookup
		DVDLookup= DVDLookup + "  DVDMovie.movieID in ( " + ActorLookup + " ) OR ";
		DVDLookup= DVDLookup + "  DVDMovie.movieID in ( " + DirectorLookup + " ) OR ";
		DVDLookup= DVDLookup + "  DVDMovie.movieID in ( " + ProducerLookup + " ) OR ";
		DVDLookup= DVDLookup + "  DVDMovie.movieID in ( " + GenreLookup + " )  ORDER BY MovieID";
		DVDLookup = "select DVDMovie.MovieID, DVDMovie.Title, DVDMovie.ReleaseDate, Max(DVDinventory.price) as Price, "
				+ " count(Status) as Quantity, Status "
				+ " From DVDMovie "
				+ " inner Join dvdinventory "
				+ " on DVDMovie.MovieID=dvdinventory.MovieID "
				+ " Where DVDMovie.movieID in ( " + DVDLookup + " )"
				+ " AND inventoryID not in (Select InventoryID from rented where dateReturned is null) "
				+ " group by DVDMOvie.movieid, DVDMovie.title, dvdinventory.status " 
				+" ;";
		
		if (stringCounter==0) return null;
		ResultSet rs = stmt.executeQuery(DVDLookup);
		//Get Record count
		int rowCounter=0;
		while (rs.next()) {
			rowCounter++;
				
		}
		rs = stmt.executeQuery(DVDLookup);
		//no records returned
		if (rowCounter==0) return null;
		//Populate Array
		int DVDStatus;
		DVDStock newDVD;
		String[] dvdReturnArray =new String[6];
		for (int i=0;i<rowCounter;i++) {
			rs.next();
			for (int j=0;j<6;j++) {
				if (j<5) dvdReturnArray[j]=rs.getString(j+1);
				else { 
					DVDStatus = Integer.valueOf(rs.getString(j+1));
					if (DVDStatus==1) dvdReturnArray[j] ="Rent"	;
					else dvdReturnArray[j] ="Sell";
					
				}
			}
			newDVD= new DVDStock(dvdReturnArray);
			inventory.add(newDVD);
		}
		return inventory;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public int rentDVD(DVDStock movie, Customer storeCustomer) {// Returns InventoryID for movie to be rented
		int movieID =movie.getMovieID();
		int customerID = storeCustomer.getCustomerID();
		int InventoryID;
		try{
			//Instantiate Database connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+vSchema,vUser,vPassword);
		Statement stmt =con.createStatement();
		String sqlStatement = "Select InventoryID from "
				+ " dvdinventory "
				+ " inner Join dvdMovie "
				+ " on dvdmovie.MovieID=dvdinventory.MovieID "
				+ " Where DVDmovie.movieID = \"" + movieID + "\""
				+ " AND inventoryID not in (Select InventoryID from rented where dateReturned is null) and DVDinventory.status=1"
				+ " LIMIT 1; ";
		//Build SQL
		
		ResultSet rs = stmt.executeQuery(sqlStatement);
		//Get Record count
		int rowCounter=0;
		while (rs.next()) {
			rowCounter++;
				
		}
		if (rowCounter==0) return -1;		//no records returned
		//Use first available rental dvd stock unit
		rs = stmt.executeQuery(sqlStatement);
		rs.next();
		InventoryID=rs.getInt(1);
		


		sqlStatement="INSERT INTO rented "
				+ 			 "(CustomerID, InventoryID, DateRented, DateDue) "
				+ "Values     ( ";

		sqlStatement=sqlStatement + " \"" + customerID + "\" ,";
		sqlStatement=sqlStatement + " \"" + InventoryID + "\" ,";  
		sqlStatement=sqlStatement + " DATE(NOW()) ,";  
		sqlStatement=sqlStatement + " DATE(ADDDATE(NOW(),5)) );";  
		stmt.execute(sqlStatement);
		return InventoryID;
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return -1;
	}
	public int returnDVD(int InventoryID) {// Returns 1 unless movie has not been rented or does not exist
		
		try{
			//Instantiate Database connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+vSchema,vUser,vPassword);
		Statement stmt =con.createStatement();
		String sqlStatement = "Select rented.InventoryID from "
				+ " dvdinventory "
				+ " inner Join rented"
				+ " on rented.inventoryID=dvdinventory.inventoryID "
				+ " Where Rented.InventoryID = \"" + InventoryID + "\""
				+ " and DVDinventory.status=1 "
				+ " AND dateReturned is null; ";
		//Build SQL
		ResultSet rs = stmt.executeQuery(sqlStatement);
		//Get Record count
		int rowCounter=0;
		while (rs.next()) {
			rowCounter++;
				
		}
		//no records returned
		if (rowCounter==0) return -1;
		sqlStatement=" UPDATE rented "
				+ " SET DateReturned= DATE(NOW()) "
				+ " Where InventoryID= \"" + InventoryID + "\"; "; 
		stmt.execute(sqlStatement);
		return InventoryID;
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return -1;
	}
	public int isCustomerCreditValid(Customer validCustomer) {
			int customerID=validCustomer.getCustomerID();
			try{
				//Instantiate Database connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+vSchema,vUser,vPassword);
			Statement stmt =con.createStatement();
			String sqlStatement = "select  DateDiff(ExpirationDate,adddate(Now(),INTERVAL 3 MONTH))"
					+ " from creditcard "
					+ " Where CustomerID = \"" + customerID + "\""
					+ " ; ";
			//Build SQL
			
			ResultSet rs = stmt.executeQuery(sqlStatement);
			//Get Record count
			int rowCounter=0;
			while (rs.next()) {
				rowCounter++;
					
			}
			if (rowCounter==0) return -1;  // No credit card or exp date found
			rs = stmt.executeQuery(sqlStatement);
			rs.next();
			int validDate=rs.getInt(1);
			return validDate;
				}catch (Exception e) {
				System.out.println(e);
			}
			return -1;
		
		
	
	}
	public int isCustomerLimitValid(Customer validCustomer) {
		int customerID=validCustomer.getCustomerID();
		try{
			//Instantiate Database connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+vSchema,vUser,vPassword);
		Statement stmt =con.createStatement();
		String sqlStatement = "select (3-count(inventoryID)) "
				+ " From rented inner join customer "
				+ " ON Rented.customerID=Customer.customerID "
				+ " Where datereturned is null "
				+ " AND rented.customerID = \"" + customerID + "\" "
				+ " group by rented.customerID; ";
		//Build SQL
		ResultSet rs = stmt.executeQuery(sqlStatement);
		//Get Record count
		int rowCounter=0;
		while (rs.next()) {
			rowCounter++;
				
		}
		if (rowCounter==0) return 3;  // No outstanding rentals
		rs = stmt.executeQuery(sqlStatement);
		rs.next();
		int validDate=rs.getInt(1);
		return validDate;
			}catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	
	

}
}
