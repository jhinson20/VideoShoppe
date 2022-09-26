/*
This class contains the user interface components and events for the AdminLogin.
Contains event handlers for the different menu buttons.
Communicates with the Controller class when it needs to access the database.
 */

package VShoppe;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminLoginController extends Controller implements Initializable  {

    //Variables linked to fxml objects

    @FXML
    private AnchorPane customerManagementMenuPane;

    @FXML
    private Button CustomerSelectButton;

    @FXML
    private Button CustomerSelectButton1;

    @FXML
    private AnchorPane DVDOptionsAttributeManagement;

    @FXML
    private Button DVDOptionsButton;

    @FXML
    private Button DVDOptionsButton2;

    @FXML
    private Button DVDOptionsButton3;

    @FXML
    private Button DVDOptionsDVDIDEnterButton;

    @FXML
    private TextField DVDOptionsDVDIDTextField;

    @FXML
    private Button DVDOptionsDVDNewEntry;

    @FXML
    private Button DVDOptionsDVDNewEntry1;

    @FXML
    private Button DVDOptionsDVDNewEntry11;

    @FXML
    private Button DVDOptionsDVDNewEntry111;

    @FXML
    private Button DVDOptionsDVDRentButton;

    @FXML
    private Button DVDOptionsDVDSaleButton;

    @FXML
    private Button DVDOptionsDVDSaleButton1;

    @FXML
    private Button DVDOptionsDVDSaleButton11;

    @FXML
    private Button DVDOptionsDVDSaleButton111;

    @FXML
    private TextField DVDOptionsDVDSearchTextField;

    @FXML
    private TextField movieSearchTextField;

    @FXML
    private TextField customerEditNameTextField;

    @FXML
    private TextField customerEditDLTextField;

    @FXML
    private TextField customerEditAddressTextField;

    @FXML
    private TextField customerEditPhoneTextField;

    @FXML
    private TextField customerEditEmailTextField;

    @FXML
    private TextField DVDOptionsDVDSearchTextField1;

    @FXML
    private TextField DVDOptionsDVDSearchTextField11;

    @FXML
    private Button DVDOptionsDVDSelectionButton1;

    @FXML
    private Button DVDOptionsDVDSelectionButton11;

    @FXML
    private Button DVDOptionsDVDSelectionButton12;

    @FXML
    private Button DVDOptionsDVDStockChange;

    @FXML
    private Button DVDOptionsDVDStockChange1;

    @FXML
    private Button DVDOptionsDVDStockChange11;

    @FXML
    private Button DVDOptionsDVDStockChange111;

    @FXML
    private Button DVDOptionsDVDWaitlistButton;

    @FXML
    private Button DVDOptionsInventoryManagementButton;

    @FXML
    private Button DVDOptionsInventoryManagementButton1;

    @FXML
    private AnchorPane DVDOptionsInventoryManagementPane;

    @FXML
    private AnchorPane DVDOptionsNewDVDEntry;

    @FXML
    private Button DVDOptionsReturnMenuButton;

    @FXML
    private AnchorPane DVDOptionsReturnPane;

    @FXML
    private AnchorPane DVDOptionsTransactionPane;

    @FXML
    private AnchorPane DVDStockChange;

    @FXML
    private AnchorPane EmployeeManagementEmployeeEditor;

    @FXML
    private AnchorPane EmployeeManagementMenu;

    @FXML
    private AnchorPane EmployeeManagementSearchPane;

    @FXML
    private AnchorPane attributeSearch;

    @FXML
    private Button creditCardValidationButton;

    @FXML
    private Button creditCardValidationButton1;

    @FXML
    private Button creditCardValidationButton11;

    @FXML
    private Button creditCardValidationButton2;

    @FXML
    private Button creditCardValidationButton21;

    @FXML
    private Button customerManagementButton;

    @FXML
    private Button customerManagementButton2;

    @FXML
    private Button customerManagementButton3;

    @FXML
    private AnchorPane customerManagementInformationPane;

    @FXML
    private AnchorPane customerManagementSearchPane;

    @FXML
    private AnchorPane customerSearchPane;

    @FXML
    private TableColumn<Customer, String> customerSearchDateOfBirthColumn;

    @FXML
    private TableColumn<Customer, String> firstNameC;

    @FXML
    private TableColumn<Customer, Integer> customerSearchIDColumn;

    @FXML
    private TableColumn<Customer, String> lastNameC;

    @FXML
    private TableView<Customer> customerSearchTable;

    @FXML
    private TableColumn<Customer, String> selectedCustomerDLNumber;

    @FXML
    private TableColumn<Customer, String> selectedCustomerFirstName;

    @FXML
    private TableColumn<Customer, String> selectedCustomerLastName;

    @FXML
    private TableColumn<DVDStock, Integer> movieSearchIDColumn;

    @FXML
    private TableColumn<DVDStock, String> movieSearchTitleColumn;

    @FXML
    private TableColumn<DVDStock, String> movieSearchDateColumn;

    @FXML
    private TableColumn<DVDStock, String> movieSearchPriceColumn;

    @FXML
    private TableColumn<DVDStock, String> movieSearchQuantityColumn;

    @FXML
    private TableColumn<DVDStock, String> movieSearchStatusColumn;

    @FXML
    private TableView<Customer> selectedCustomerTable;

    @FXML
    private TableView<DVDStock> movieSearchTable;

    @FXML
    private TableColumn<Customer, Integer> customerEditIDColumn;

    @FXML
    private TableColumn<Customer, String> customerEditFirstNameColumn;

    @FXML
    private TableColumn<Customer, String> customerEditLastNameColumn;

    @FXML
    private TableColumn<Customer, String> customerEditBirthDateColumn;

    @FXML
    private TableView<Customer> customerEditorTable;

    @FXML
    private TextField customerSearchTextField;

    @FXML
    private TextField customerSearchTextField1;

    @FXML
    private TextField customerEditBirthDateTextField;

    @FXML
    private Button employeeManagementButton;

    @FXML
    private Button employeeManagementButton2;

    @FXML
    private Button employeeManagementButton3;

    @FXML
    private AnchorPane genreEditor;

    @FXML
    private StackPane hboxTab1;

    @FXML
    private AnchorPane hboxTab1CustomerManagement;

    @FXML
    private Button hboxTab1CustomerManagementButton;

    @FXML
    private AnchorPane hboxTab1DVDOptions;

    @FXML
    private Button hboxTab1DVDOptionsButton;

    @FXML
    private AnchorPane hboxTab1EmployeeManagement;

    @FXML
    private Button hboxTab1EmployeeMangamentButton;

    @FXML
    private AnchorPane hboxTab1Home;

    @FXML
    private StackPane hboxTab2;

    @FXML
    private AnchorPane hboxTab2Attribute;

    @FXML
    private Button hboxTab2DVDOptionsAttributeManagementPress;

    @FXML
    private Button hboxTab2DVDOptionsInventoryManagement;

    @FXML
    private Button hboxTab2DVDOptionsReturnPress;

    @FXML
    private Button hboxTab2DVDOptionsTransactionPress;

    @FXML
    private AnchorPane hboxTab2Home;

    @FXML
    private AnchorPane hboxTab2Inventory;

    @FXML
    private AnchorPane hboxTab2Return;

    @FXML
    private AnchorPane hboxTab2Transaction;

    @FXML
    private StackPane hboxTab3;

    @FXML
    private AnchorPane hboxTab3Home;

    @FXML
    private StackPane hboxTab4;

    @FXML
    private AnchorPane hboxTab4Home;

    @FXML
    private Button homeButton;

    @FXML
    private AnchorPane homePane;

    @FXML
    private Button logoutButton;

    @FXML
    private StackPane middleStackPane;

    @FXML
    private AnchorPane moviePersonEditor;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private VBox vboxCustomerManagement;

    @FXML
    private VBox vboxDVDOptions;

    @FXML
    private Button vboxDVDOptionsTransactionMenu;

    @FXML
    private VBox vboxEmployeeManagement;

    @FXML
    private VBox vboxHome;

    @FXML
    private AnchorPane vboxPaneDVDOptions;

    @FXML
    private AnchorPane vboxPaneHome;


    //Stage that is not yet connected to the fxml display

    Stage stage;

    /*
    Integer used to determine where the customer pane will lead to once a customer is selected
    0 means an existing customer is renting a movie
    1 means an existing customer is being edited
     */

    int customerSearchPath = 0;

    /*
    Integer used to determine where the customer editing menu pane will lead once a choice is selected
    0 means a new customer is being created
    1 means an existing customer is being edited
     */

    int customerEditPath = 0;

    //Variable that will keep track of the selected customer object

    Customer selectedCustomer;

    //Variable that will keep track of the newCustomer object

    Customer newCustomer;

    //Variable that will keep track of the selectedMovie object

    DVDStock selectedMovie;

    //Needed for the table views

    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerSearchIDColumn.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("CustomerID"));
        firstNameC.setCellValueFactory(new PropertyValueFactory<Customer, String>("FirstName"));
        lastNameC.setCellValueFactory(new PropertyValueFactory<Customer, String>("LastName"));
        customerSearchDateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("dateOfBirth"));
        selectedCustomerDLNumber.setCellValueFactory(new PropertyValueFactory<Customer, String>("DLNumber"));
        selectedCustomerFirstName.setCellValueFactory(new PropertyValueFactory<Customer, String>("FirstName"));
        selectedCustomerLastName.setCellValueFactory(new PropertyValueFactory<Customer, String>("LastName"));
        movieSearchIDColumn.setCellValueFactory(new PropertyValueFactory<DVDStock, Integer>("MovieID"));
        movieSearchTitleColumn.setCellValueFactory(new PropertyValueFactory<DVDStock, String>("Title"));
        movieSearchDateColumn.setCellValueFactory(new PropertyValueFactory<DVDStock, String>("ProductionDate"));
        movieSearchPriceColumn.setCellValueFactory(new PropertyValueFactory<DVDStock, String>("Price"));
        movieSearchQuantityColumn.setCellValueFactory(new PropertyValueFactory<DVDStock, String>("Quantity"));
        movieSearchStatusColumn.setCellValueFactory(new PropertyValueFactory<DVDStock, String>("Status"));
        customerEditIDColumn.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("CustomerID"));
        customerEditFirstNameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("FirstName"));
        customerEditLastNameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("LastName"));
        customerEditBirthDateColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("dateOfBirth"));
        initialHome();
    }

    //Action taken on the press of a customerManagement button

    public void customerManagementPress(ActionEvent actionEvent) {
        customerManagementMenuPane.toFront();
        hboxTab1CustomerManagement.toFront();
        hboxTab2Home.toFront();
        hboxTab3Home.toFront();
    }

    //Action taken on the press of a exsitingCustomer button

    public void editExistingCustomerPress(ActionEvent actionEvent) {
        customerSearchPaneClear();
        customerSearchPane.toFront();
        hboxTab1CustomerManagement.toFront();
        hboxTab2Home.toFront();
        hboxTab3Home.toFront();
        customerSearchPath = 1;
        customerEditPath = 1;
    }

    //Action taken on the press of a newCustomer button

    public void createNewCustomerPress(ActionEvent actionEvent) {
        customerEditPaneClear();
        customerManagementInformationPane.toFront();
        hboxTab1CustomerManagement.toFront();
        hboxTab2Home.toFront();
        hboxTab3Home.toFront();
        customerEditPath = 0;
    }

    //Action taken on the press of a employeeMangament button

    public void employeeManagementPress(ActionEvent actionEvent) {
        EmployeeManagementMenu.toFront();
        hboxTab1EmployeeManagement.toFront();
        hboxTab2Home.toFront();
        hboxTab3Home.toFront();
    }

    //Action taken on the press of a logout button

    public void logoutPress(ActionEvent actionEvent) {
        stage = (Stage) scenePane.getScene().getWindow();
        scenePane.getChildren().clear();
        logout(stage);
    }

    //Action taken on the press of a DVDOptions button

    public void DVDOptionsPress(ActionEvent actionEvent) {
        homePane.toFront();
        vboxPaneDVDOptions.toFront();
        hboxTab1DVDOptions.toFront();
        hboxTab2Home.toFront();
        hboxTab3Home.toFront();
    }

    //Action taken on the press of a DVDOptionsReturn button

    public void DVDOptionsReturnMenuButtonPress(ActionEvent actionEvent) {
        DVDOptionsDVDIDTextField.clear();
        DVDOptionsReturnPane.toFront();
        hboxTab2Return.toFront();
        hboxTab3Home.toFront();
    }

    //Loads the initial view of the login screen

    public void initialHome() {
        homePane.toFront();
        hboxTab1Home.toFront();
        vboxPaneHome.toFront();
        hboxTab2Home.toFront();
        hboxTab3Home.toFront();
    }

    //Action taken on the press of a home button

    public void homeButtonPress(ActionEvent actionEvent) {
        homePane.toFront();
        hboxTab1Home.toFront();
        vboxPaneHome.toFront();
        hboxTab2Home.toFront();
        hboxTab3Home.toFront();
    }

    //Action taken on the press of a transaction button

    public void DVDOptionsTransactionPress(ActionEvent actionEvent) {
        customerSearchPaneClear();
        customerSearchPane.toFront();
        hboxTab2Transaction.toFront();
        hboxTab3Home.toFront();
        customerSearchPath = 0;
    }

    //Action taken on the press of a inventoryManagement button

    public void DVDOptionsInventoryManagementPress(ActionEvent actionEvent) {
        DVDOptionsInventoryManagementPane.toFront();
        hboxTab2Inventory.toFront();
        hboxTab3Home.toFront();
    }

    //Action taken on the press of a attributeManagement button

    public void DVDOptionsAttributeManagementPress(ActionEvent actionEvent) {
        DVDOptionsAttributeManagement.toFront();
        hboxTab2Attribute.toFront();
        hboxTab3Home.toFront();
    }

    //Key event that searches the customers and updates a corresponding table with every change to a textfield

    public void customerSearch(KeyEvent keyEvent) {
        String customerSearchString = customerSearchTextField.getText();
        customerSearchTable.getItems().clear();

        if(customerSearchString.length() > 0) {
            ArrayList<Customer> customerList = getMatchingCustomers(customerSearchString);
            ObservableList<Customer> customers = customerSearchTable.getItems();

            for(int i = 0; i < customerList.size(); i++) {
                customers.add(customerList.get(i));
            }

            customerSearchTable.setItems(customers);
        }
    }

    //Selects the customer from a table and proceeds with a customer update or transaction

    public void customerSearchSelectPress(ActionEvent actionEvent) {
        selectedCustomer = customerSearchTable.getSelectionModel().getSelectedItem();

        if((customerSearchPath == 0) && (selectedCustomer != null)) {
            DVDOptionsTransactionPane.toFront();
            hboxTab2Transaction.toFront();
            hboxTab3Home.toFront();
            customerSearchTable.getItems().clear();

            movieSearchPaneClear();
            ObservableList<Customer> customers = customerSearchTable.getItems();
            customers.add(selectedCustomer);
            selectedCustomerTable.setItems(customers);
        }
        else if((customerSearchPath == 1) && (selectedCustomer != null)) {
            customerManagementInformationPane.toFront();

            customerEditPaneClear();
            customerEditSetTextFields(selectedCustomer);
            ObservableList<Customer> customers = customerEditorTable.getItems();
            customers.add(selectedCustomer);
            customerEditorTable.setItems(customers);
        }
    }

    //Action taken on the press of a creation/editCustomer button. Throws alerts if issues occur with the cusomter edit

    public void customerCreationEditPress() {

        if(customerEditPath == 0) {
            int error = createNewCustomer();
            if(error > -1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Customer " + newCustomer.getFirstName() + " "
                        + newCustomer.getLastName() + " has been created");
                alert.show();
                initialHome();
            }
            else if(error == -2){
                Alert alert = new Alert(Alert.AlertType.ERROR, "DL number name cannot be greater than 11 digits or empty.");
                alert.show();
            }
            else if(error == -3){
                Alert alert = new Alert(Alert.AlertType.ERROR, "First name cannot be greater than 25 characters or empty.");
                alert.show();
            }
            else if(error == -4){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Last name cannot be greater than 25 characters or empty.");
                alert.show();
            }
            else if(error == -5){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Date does not have the YYYY-MM-dd format or empty.");
                alert.show();
            }
            else if(error == -6){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Address cannot be greater than 40 characters or empty.");
                alert.show();
            }
            else if(error == -7){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Phone number cannot be greater than 15 characters or empty.");
                alert.show();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Customer ID conflict");
                alert.show();
            }
        }
        else if(customerEditPath == 1){
            int error = updateExistingCustomer(selectedCustomer);
            if(error > -1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Customer " + newCustomer.getFirstName() + " "
                        + newCustomer.getLastName() + " has been updated");
                alert.show();
                initialHome();
            }
            else if(error == -2){
                Alert alert = new Alert(Alert.AlertType.ERROR, "DL number name cannot be greater than 11 digits or empty.");
                alert.show();
            }
            else if(error == -3){
                Alert alert = new Alert(Alert.AlertType.ERROR, "First name cannot be greater than 25 characters or empty.");
                alert.show();
            }
            else if(error == -4){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Last name cannot be greater than 25 characters or empty.");
                alert.show();
            }
            else if(error == -5){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Date does not have the YYYY-MM-dd format or empty.");
                alert.show();
            }
            else if(error == -6){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Address cannot be greater than 40 characters or empty.");
                alert.show();
            }
            else if(error == -7){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Phone number cannot be greater than 15 characters or empty.");
                alert.show();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Customer ID conflict");
                alert.show();
            }
        }

    }

    public void rentDVDPress() {
        selectedMovie = movieSearchTable.getSelectionModel().getSelectedItem();

        if(selectedMovie != null) {
            int error = rentMovie(selectedCustomer, selectedMovie);
            if(error == -1) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Movie is out of stock.");
                alert.show();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, selectedMovie.getTitle() + " has been rented \nout to "
                + selectedCustomer.getFirstName() + " " + selectedCustomer.getLastName() + "\nID: " + error);
                alert.show();
                initialHome();
            }
        }
    }

    //Clears the items in the customerSearchPane

    public void customerSearchPaneClear() {
        customerSearchTable.getItems().clear();
        customerSearchTextField.clear();
    }

    //Key event that searches the movies and updates a corresponding table with every change to a textfield

    public void movieSearch(KeyEvent keyEvent) {
        String movieSearchString = movieSearchTextField.getText();
        movieSearchTable.getItems().clear();

        if(movieSearchString.length() > 0) {
            ArrayList<DVDStock> movieList = getMatchingMovies(movieSearchString);
            ObservableList<DVDStock> movies = movieSearchTable.getItems();

            for(int i = 0; i < movieList.size(); i++) {
                movies.add(movieList.get(i));
            }

            movieSearchTable.setItems(movies);
        }
    }

    public void DVDReturn() {
        String field = DVDOptionsDVDIDTextField.getText();

        if(field.length() > 0) {
            try {
                int error = returnMovie(Integer.parseInt(field));
                if(error > -1) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Movie has been returned");
                    initialHome();
                    alert.show();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "ID not rented out");
                    alert.show();
                }
            } catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR, "ID must contain only integers");
                alert.show();
            }
        }
    }

    //Clears the items in the movieSearchPane

    public void movieSearchPaneClear() {
        movieSearchTable.getItems().clear();
        movieSearchTextField.clear();
    }

    //Loads values of the selected customer into the textfields of the pane

    public void customerEditSetTextFields(Customer customer) {
        customerEditNameTextField.setText(customer.getFirstName() + " " + customer.getLastName());
        customerEditDLTextField.setText(customer.getDLNumber());
        customerEditBirthDateTextField.setText(customer.getDateOfBirth());
        customerEditAddressTextField.setText(customer.getAddress());
        customerEditPhoneTextField.setText(customer.getPhoneNumber());
        customerEditEmailTextField.setText(customer.getEmail());
    }

    //Creates a new customer to add to the database

    public int createNewCustomer() {
        newCustomer = new Customer();
        String nameString = customerEditNameTextField.getText();
        int parseIndex = -1;
        for(int i = 0; i < nameString.length(); i++) {
            if(nameString.charAt(i) == ' ') {
                parseIndex = i;
                break;
            }
        }

        newCustomer.setCustomerID(0);
        newCustomer.setDLNumber(customerEditDLTextField.getText());
        newCustomer.setFirstName(nameString.substring(0,parseIndex));
        newCustomer.setLastName(nameString.substring(parseIndex + 1, nameString.length()));
        newCustomer.setDateOfBirth(customerEditBirthDateTextField.getText());
        newCustomer.setAddress(customerEditAddressTextField.getText());
        newCustomer.setPhoneNumber(customerEditPhoneTextField.getText());
        newCustomer.setEmail(customerEditEmailTextField.getText());
        return addCustomer(newCustomer);
    }

    //Updates values in the database of an existing customer

    public int updateExistingCustomer(Customer oldCustomer) {
        newCustomer = new Customer();
        String nameString = customerEditNameTextField.getText();
        int parseIndex = -1;
        for(int i = 0; i < nameString.length(); i++) {
            if(nameString.charAt(i) == ' ') {
                parseIndex = i;
                break;
            }
        }

        newCustomer.setCustomerID(oldCustomer.getCustomerID());
        newCustomer.setDLNumber(customerEditDLTextField.getText());
        newCustomer.setFirstName(nameString.substring(0,parseIndex));
        newCustomer.setLastName(nameString.substring(parseIndex + 1, nameString.length()));
        newCustomer.setDateOfBirth(customerEditBirthDateTextField.getText());
        newCustomer.setAddress(customerEditAddressTextField.getText());
        newCustomer.setPhoneNumber(customerEditPhoneTextField.getText());
        newCustomer.setEmail(customerEditEmailTextField.getText());
        return updateCustomer(newCustomer);
    }

    //Clears the items within the customerEditPane

    public void customerEditPaneClear() {
        customerEditNameTextField.clear();
        customerEditDLTextField.clear();
        customerEditBirthDateTextField.clear();
        customerEditAddressTextField.clear();
        customerEditPhoneTextField.clear();
        customerEditEmailTextField.clear();
        customerEditorTable.getItems().clear();
    }

}