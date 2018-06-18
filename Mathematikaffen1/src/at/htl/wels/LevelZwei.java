package at.htl.wels;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.System.exit;

public class LevelZwei {
    @FXML
    Button checkErgSub;
    @FXML
    Label zahlEins;
    @FXML Label zahlZwei;
    @FXML Label ergAusgabe;
    @FXML TextField ergSub;
    @FXML Button back;
    @FXML Button ready;
    int normal=0;
    private static int countRechnungen=0;
    // Level 2: subtrahieren 0-50

    private static boolean levelGeschafft = false;
    private static int maxRechnungen=20;
    int[] zahlen = new int[2];


    public boolean methodeIstTrue(){
        return levelGeschafft;
    }

    public void onClickErgSub(){
        int erg=0;
        String zEins= zahlEins.getText();
        String zZwei = zahlZwei.getText();
        erg = Integer.parseInt(zEins)-Integer.parseInt(zZwei);
        String finalErg = String.valueOf(erg);
        if(finalErg.equals(ergSub.getText())){
            ergAusgabe.setText("RICHTIG!");
        }else{
            ergAusgabe.setText("FALSCH!");
        }

    }

    public void setZahlen(){
        ergAusgabe.setText("");
        ergSub.setText("");
        while(normal<2) {
            zahlen[normal] = (int) (Math.random() * 50) + 1;
            normal++;
        }
        normal=0;
        if(zahlen[0]<zahlen[1]){
            zahlEins.setText(String.valueOf(zahlen[1]));
            zahlZwei.setText(String.valueOf(zahlen[0]));
        }else{
        zahlEins.setText(String.valueOf(zahlen[0]));
        zahlZwei.setText(String.valueOf(zahlen[1]));
        }
    }

    public void beenden(){
        exit(0);
    }

    public void levelAuswahl(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Spielen.fxml"));
            Stage primaryStage = Main.getPrimaryStage();
            primaryStage.setTitle("Spielen");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
