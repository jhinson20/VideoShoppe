package VShoppe;

import java.util.ArrayList;

public class DVD extends DataBaseTable {
	private int inventoryID;
	private Movie dvdMovie;
	private float price;
	private float cost;
	private int status;
	
	public DVD(int InventoryID, Movie DVDMovie, float price, float cost, int status )throws Exception {
		setInventoryID(inventoryID);
		setDvdMovie(DVDMovie);
		setPrice(price);
		setCost(cost);
		setStatus(status);
	}
	public DVD(String[] dvd) throws Exception {

	}
	

	public int getInventoryID() {
		return inventoryID;
	}


	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}


	public Movie getDvdMovie() {
		return dvdMovie;
	}

	public void setDvdMovie(Movie dvdMovie) {
		this.dvdMovie = dvdMovie;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float dvd) {
		this.price = dvd;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost2) {
		this.cost = cost2;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	//Included Subclasses

	
	public class Genre extends DataBaseTable{
		private int genreID;
		private String genreName;
		private String genreDescription;
		public int getGenreID() {
			return genreID;
		}
		public void setGenreID(int genreID) {
			this.genreID = genreID;
		}
		public String getGenreName() {
			return genreName;
		}
		public void setGenreName(String genreName) {
			this.genreName = genreName;
		}
		public String getGenreDescription() {
			return genreDescription;
		}
		public void setGenreDescription(String genreDescription) {
			this.genreDescription = genreDescription;
		}
		
	}
	
	public class MoviePerson extends DataBaseTable{
		private int MoviePersonID;
		private String Name;
		private String DateOfBirth;
		public int getMoviePersonID() {
			return MoviePersonID;
		}
		public void setMoviePersonID(int moviePersonID) {
			MoviePersonID = moviePersonID;
		}
		public String getName() {
			return Name;
		}
		public void setName(String Name) {
			Name = Name;
		}public String getDateOfBirth() {
			return DateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			DateOfBirth = dateOfBirth;
		}
	}

	public class Movie extends DataBaseTable {
		private int MovieID;
		private String Title;
		private String DateOfRelease;
		private ArrayList<MoviePerson> Actors;
		private ArrayList<MoviePerson> Directors;
		private ArrayList<MoviePerson> Producers;
		private ArrayList<Genre> Genres;
		
		public Movie(int MovieID, String Title, String DateOfRelease) {
			//Call parameterized constructor with empy ArrayLists
			this(MovieID, Title, DateOfRelease, new ArrayList<MoviePerson>(),
					new ArrayList<MoviePerson>(),new ArrayList<MoviePerson>(),new ArrayList<Genre>());		
			
			
		}
		public Movie(int MovieID, String Title, String DateOfRelease, 
				ArrayList<MoviePerson> Actors, ArrayList<MoviePerson> Directors, 
				ArrayList<MoviePerson> Producers, ArrayList<Genre> Genres) {
			setMovieID(MovieID);
			setTitle(Title);
			setDateOfRelease(DateOfRelease);
			this.Actors=Actors;
			this.Directors=Directors;
			this.Producers=Producers;
			this.Genres=Genres;
			
			
		}
		public MoviePerson getActor(String Name) {
		
		
		return null;
		
		}
		public MoviePerson getActor(int ID) {
			
			return null;
		}
		public int setActor(MoviePerson newActor) {
			
			return -1;
		}
		public String getDateOfRelease() {
			return DateOfRelease;
		}
		public void setDateOfRelease(String dateOfRelease) {
			DateOfRelease = dateOfRelease;
		}
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public int getMovieID() {
			return MovieID;
		}
		public void setMovieID(int movieID) {
			MovieID = movieID;
		}
	}
	
}

