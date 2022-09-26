/*
This class instantiates either the admin or employee view of the program options menu.
Non controller class for both the adminLogin and the employeeLogin.
 */

package VShoppe;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login {

    public Login(Stage stage, int role) {

        switch (role) {
            case 1:
                stage.setScene(CreateEmployeeScene());
                stage.setMaximized(true);
                stage.show();
                break;
            case 2:
                stage.setScene(CreateAdminScene());
                stage.setMaximized(true);
                stage.show();
                break;
            default:
                break;
        }

    }

    public Scene CreateEmployeeScene() {
        Scene scene1;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("EmployeeLogin.fxml"));
            scene1 = new Scene(root);
            return scene1;

        }catch(Exception e) {
            System.out.println(e.getStackTrace());
            System.exit(0);
        }

        return null;

    }

    public Scene CreateAdminScene() {
        Scene scene2;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
            scene2 = new Scene(root);
            return scene2;

        }catch(Exception e) {
            System.out.println(e.getStackTrace());
            System.exit(0);
        }

        return null;

    }

}
