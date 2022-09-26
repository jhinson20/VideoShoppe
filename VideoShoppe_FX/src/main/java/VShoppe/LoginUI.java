/*
This class is used to instantiate the login user interface.
 */

package VShoppe;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginUI {

    public LoginUI(Stage stage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
            stage.setScene(new Scene(root));
            stage.show();

        }catch(Exception e) {
            System.out.println(e.getStackTrace());
            System.exit(0);
        }
    }

}
