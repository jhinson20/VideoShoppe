/*
The Controller class handles the communication between classes through its methods. It is the parent of most
classes in the program.
 */

package VShoppe;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Controller extends Application {

    //First call to the loginUI class that starts the entire program

    @Override
    public void start(Stage primaryStage) {
        createLogin(new Stage());
    }

    //Method that closes a stage

    public void closeStage(Stage stage) {
        stage.close();
    }

    //Method that instantiates the loginUI class

    public void createLogin(Stage stage) {
        LoginUI loginUI = new LoginUI(stage);
    }

    //Method that closes the parameter stage and creates a login screen

    public void logout(Stage stage) {
        stage.setMaximized(false);
        createLogin(stage);
    }

    //Method that instantiates the loginVerification class to verify a login attempt from the loginUI class

    public int loginVerification(String username, String password) {
        VshoppeDatabase vshoppeDatabase = new VshoppeDatabase();
        return vshoppeDatabase.verifyPassword(username, password);
    }

    /*
    Method that instantiates the Login class based on the authorization level it gets
    from the loginUIController class. Method also closes the parameter stage
     */

    public void authorizationMenu(Stage stage, int level) {
        Login menu = new Login(stage, level);
    }

    //Method that calls to the database controller to get a list of customers from the search string

    public ArrayList<Customer> getMatchingCustomers(String searchString){
        VshoppeDatabase vshoppeDatabase = new VshoppeDatabase();
        ArrayList<Customer> customerList = vshoppeDatabase.getCustomer(searchString);
        return customerList;
    }

    //Method that calls to the database controller to get a list of movies from the search string

    public ArrayList<DVDStock> getMatchingMovies(String searchString) {
        VshoppeDatabase vshoppeDatabase = new VshoppeDatabase();
        ArrayList<DVDStock> movieList = vshoppeDatabase.getDVDShop(searchString);
        return movieList;
    }

    //Method that calls to the database controller to add a customer object to the database

    public int addCustomer(Customer customer) {
        VshoppeDatabase vshoppeDatabase = new VshoppeDatabase();
        int error = customerNullCheck(customer);
        if(error != 0)
            return error;
        return vshoppeDatabase.addCustomer(customer);
    }

    //Method that calls to the database controller update a customer object that already exists in the database

    public int updateCustomer(Customer customer) {
        VshoppeDatabase vshoppeDatabase = new VshoppeDatabase();
        int error = customerNullCheck(customer);
        if(error != 0)
            return error;
        return vshoppeDatabase.updateCustomer(customer);
    }

    //Checks if any attributes of the customer object are null

    public int customerNullCheck(Customer customer) {
        if(customer.getCustomerID() < 0)
            return -1;
        else if(customer.getDLNumber() == null || customer.getDLNumber().length() == 0)
            return -2;
        else if(customer.getFirstName() == null || customer.getFirstName().length() == 0)
            return -3;
        else if(customer.getLastName() == null || customer.getLastName().length() == 0)
            return -4;
        else if(customer.getDateOfBirth() == null || customer.getDateOfBirth().length() == 0)
            return -5;
        else if(customer.getAddress() == null || customer.getAddress().length() == 0)
            return -6;
        else if(customer.getPhoneNumber() == null || customer.getPhoneNumber().length() == 0)
            return -7;
        else
            return 0;
    }

    //Class that calls to the database to rent a movie

    public int rentMovie(Customer customer, DVDStock movie) {
        VshoppeDatabase vshoppeDatabase = new VshoppeDatabase();
        return vshoppeDatabase.rentDVD(movie, customer);
    }

    //Class that calls to the database to rent a movie

    public int returnMovie(int returnID) {
        VshoppeDatabase vshoppeDatabase = new VshoppeDatabase();
        return vshoppeDatabase.returnDVD(returnID);
    }

}