package VShoppe;

import java.util.zip.DataFormatException;

public class DVDStock extends DataBaseTable{
	private int MovieID;
	private String Title;
	private String ProductionDate;
	private String  Price;
	private String Quantity;
	private String Status;
	
	public DVDStock(String[] inventory) throws DataFormatException {
		if (inventory.length!=6) throw new DataFormatException("Invalid Inventory Array");
		setMovieID(Integer.valueOf(inventory[0]));
		setTitle(inventory[1]);
		setProductionDate(inventory[2]);
		setPrice(inventory[3]);
		setQuantity(inventory[4]);
		setStatus(inventory[5]);
		
		
		
	}

	public int getMovieID() {
		return MovieID;
	}

	public void setMovieID(int movieID) {
		MovieID = movieID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}



	public String getProductionDate() {
		return ProductionDate;
	}

	public void setProductionDate(String productionDate) {
		ProductionDate = productionDate;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	public String toString() {
		String dvdString ="";
		dvdString=dvdString + this.getMovieID() + " " 
				+ this.getTitle() + " " 
				+ this.getProductionDate() + " " 
				+ this.getPrice() + " " 
				+ this.getQuantity() + " " 
				+ this.getStatus() + " " ;
		return dvdString;
	}
}