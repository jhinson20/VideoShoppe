/*
This class contains the user interface components and events for the loginUI.
Contains event handlers for the login and cancel buttons.
The cancelPress event closes out the login user interface stage and terminates the program.
The loginPress event takes the passwordTextField and usernameTextField and sends them to the passwordVerification
class for login validation.
 */

package VShoppe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginUIController extends Controller {

    //Variable for the number of attempted logins

    int attempts = 0;

    //Imports of fxml components

    @FXML
    private Button cancelButton;

    @FXML
    private Button logInButton;

    @FXML
    private PasswordField passwordTextfield;

    @FXML
    private TextField usernameTextfield;

    //Import of the pane that will be connected to the stage

    @FXML
    private AnchorPane scenePane;

    //Stage that is not yet connected to the fxml display

    Stage stage;

    public void LoginUI(InputMethodEvent inputMethodEvent) {
    }

    //Login button press from the login screen attempts a login through the loginVerification

    public void loginPress(ActionEvent actionEvent) {
        loginAttempt();
    }

    //Cancel button press from the login scene closes the stage and exits the program

    public void cancelPress(ActionEvent actionEvent) {
        stage = (Stage) scenePane.getScene().getWindow();
        closeStage(stage);
    }

    public void enterKeyLogin(KeyEvent keyEvent) {
        if((int)keyEvent.getCharacter().charAt(0) == 13)
            loginAttempt();
    }

    public void loginAttempt(){
        stage = (Stage) scenePane.getScene().getWindow();
        //int viewLevel = loginVerification(usernameTextfield.getText(), passwordTextfield.getText());
        int viewLevel = 1;
        attempts += viewLevel;

        if (attempts == -3) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Too many unsuccessful login attempts. Admin login required.");
            alert.show();
            closeStage(stage);
        }
        else if (viewLevel > 0) {
            scenePane.getChildren().clear();
            attempts = 0;
            authorizationMenu(stage, viewLevel);
        }
        else if (attempts < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid login credentials. You have " + (attempts + 3) + " login attempts left");
            alert.show();
        }
    }

}