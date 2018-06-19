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

public class LevelDrei {
    @FXML
    Button checkErgMul;
    @FXML
    Label zahlEins;
    @FXML Label zahlZwei;
    @FXML Label ergAusgabe;
    @FXML
    TextField ergMul;
    @FXML Button back;
    @FXML Button ready;
    private static int countRechnungen=0;
    // Level 3: multiplizieren 0-50

    private static boolean levelGeschafft = false;
    private static int maxRechnungen=20;
    int[] zahlen = new int[3];
    int normal=0;

    public boolean methodeIstTrue(){
        return levelGeschafft;
    }

    public void onClickErgMul(){
        int erg=0;
        String zEins= zahlEins.getText();
        String zZwei = zahlZwei.getText();
        erg = Integer.parseInt(zEins)*Integer.parseInt(zZwei);
        String finalErg = String.valueOf(erg);
        if(finalErg.equals(ergMul.getText())){
            ergAusgabe.setText("RICHTIG!");
        }else{
            ergAusgabe.setText("FALSCH!");
        }

    }

    public void setZahlen(){
        ergAusgabe.setText("");
        ergMul.setText("");
        while(normal<2) {
            zahlen[normal] = (int) (Math.random() * 10) + 1;
            normal++;
        }
        normal=0;
            zahlEins.setText(String.valueOf(zahlen[0]));
            zahlZwei.setText(String.valueOf(zahlen[1]));
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
