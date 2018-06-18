package at.htl.wels;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static java.lang.System.exit;



public class SpielenController implements Initializable{

    @FXML Label zusatzFreig;

    LevelEins levelEins;
    LevelZwei levelZwei;
    LevelDrei levelDrei;
    LevelVier levelVier;
    ZusatzLevel zusatzLevel;

    int normal=0;
    int zusatz=0;

    int maxRechnungenNormal = 40;
    int maxZahlenbereichNormal =50;
   public int[] zufallsZahlenNormal = new int[maxRechnungenNormal];
    String[] userData = new String[3];
    int loginVersuch = 1;

    int maxRechnungenZusatz = 60;
    int maxZahlenbereichZusatz =100;
    int[] zufallsZahlenZusatz = new int[maxRechnungenZusatz];



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        levelEins = new LevelEins();
        levelZwei = new LevelZwei();
        levelDrei = new LevelDrei();
        levelVier = new LevelVier();
        zusatzLevel = new ZusatzLevel();


        while (zusatz < maxRechnungenZusatz) {
            zufallsZahlenZusatz[zusatz] = (int) (Math.random() * maxZahlenbereichZusatz) + 1;
            zusatz++;
        }
        //}else {
        while(normal<maxRechnungenNormal) {
            zufallsZahlenNormal[normal] = (int) (Math.random() * maxZahlenbereichNormal) + 1;
            normal++;
        }

        //um das erzeugen der Zufallszahlen bei erneutem Aufruf wieder zufällig zu gestalten
        if(normal==40){
            normal = 0;
        }
        if(zusatz==60){
            zusatz=0;
        }
    }

    public void addieren(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LevelEins.fxml"));
            Stage primaryStage = Main.getPrimaryStage();
            primaryStage.setTitle("Spielen");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subtrahieren(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LevelZwei.fxml"));
            Stage primaryStage = Main.getPrimaryStage();
            primaryStage.setTitle("Spielen");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dividieren(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LevelVier.fxml"));
            Stage primaryStage = Main.getPrimaryStage();
            primaryStage.setTitle("Spielen");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void multiplizieren(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LevelDrei.fxml"));
            Stage primaryStage = Main.getPrimaryStage();
            primaryStage.setTitle("Spielen");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void zusatzlevel(){
        //Überprüfung, ob das Zusatzlevel freigeschalten wurde!
        if(levelEins.methodeIstTrue() && levelZwei.methodeIstTrue() && levelDrei.methodeIstTrue() && levelVier.methodeIstTrue()){
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("Zusatzlevel.fxml"));
                    Stage primaryStage = Main.getPrimaryStage();
                    primaryStage.setTitle("Spielen");
                    primaryStage.setScene(new Scene(root));
                    primaryStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Wenn freigeschlaten und die Auswahl wurde getätigt, wird das Level gestartet
                zusatzLevel.levelZusatz(zufallsZahlenZusatz);

        }else{
            //Wenn das Level ausgewählt wird, obwohl es nicht freigeschalten wurde, wird ein Fehler ausgegeben!
            zusatzFreig.setText("Zusatzlevel wurde noch nicht freigeschalten!");
        }

    }

    public void beenden(){
        exit(0);
    }
}
