package at.htl.wels;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class Controller implements Initializable {
    @FXML Button button_anmelden;
    @FXML Button button_abbrechen;
    @FXML TextField username;
    @FXML TextField passwort;
    @FXML Label login;


    public void onClickAbbrechen(){
        exit(0);
    }

    public void onClickAnmelden(){
        if((username.getText()).equals("cisco") && (passwort.getText()).equals("admin") ) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Spielen.fxml"));
                Stage primaryStage = Main.getPrimaryStage();
                primaryStage.setTitle("Spielen");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            login.setText("FEHLER!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
