package at.htl.wels;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{

        //variablen zum Verarbeiten der Rückgabewerte / zur Auswertung der Eingabe
        int normal=0;
        int zusatz=0;

        int maxRechnungenNormal = 40;
        int maxZahlenbereichNormal =50;
        int[] zufallsZahlenNormal = new int[maxRechnungenNormal];
        String[] userData = new String[3];
        int loginVersuch = 1;

        int maxRechnungenZusatz = 60;
        int maxZahlenbereichZusatz =100;
        int[] zufallsZahlenZusatz = new int[maxRechnungenZusatz];

        LevelEins levelEins = new LevelEins();
        LevelZwei levelZwei = new LevelZwei();
        LevelDrei levelDrei = new LevelDrei();
        LevelVier levelVier = new LevelVier();
        ZusatzLevel zusatzLevel = new ZusatzLevel();

        int auswahlUser=0;
        int auswahlRechnungen = 0;


        User user = new User("Max","Mustermann",false,false,false,false);

        System.out.println("Neues Spiel beginnen: 1\nSpiel fortsetzen: 2");
        Scanner sc2 = new Scanner(System.in);
        auswahlUser=sc2.nextInt();

        //User Auswahl, ob der User einen vorhandenen User benutzen will, oder einen neuen Benutzer anlegen will
        if(auswahlUser==1) {

            userData=user.addUser();

        }else if(auswahlUser==2){
            userData = user.searchUser();
            while(userData[2].compareTo("false")==0) {
                if(loginVersuch==3){
                    //Wenn bereits 3 Loginversuche getätigt wurden und diese fehlgeschlagen sind
                    //wird der User aufgefordert einen neuen Benutzer anzulegen!
                    System.out.println("Loginversuch "+loginVersuch+"/3\n");
                    userData=user.addUser();
                    userData[2]="true";
                }else {
                    //Es wird solange der Login versuch getätigt, bis der 3. Versuch getätigt wurde
                    //Es wird laufend der Loginversuch ausgegeben (1. 2. & 3.)
                    System.out.println("Loginversuch "+loginVersuch+"/3\n");
                    userData = user.searchUser();
                }
                loginVersuch++;
            }
        }

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

        //Wenn sich der Benutzer eingeloggt oder einen neuen User angelegt hat, kommt er zum eigentlichen Spiel

        if(userData[2].compareTo("true")==0) {
            while (auswahlRechnungen != 6) {
                System.out.println("Auswahl der Level:");
                System.out.println("1 für addieren\n2 für subtrahieren\n3 für multiplizieren\n4 für dividieren\n5 um das Zusatzlevel zu starten \n6 um das Programm zu beenden\nIhre Auswahl:");
                Scanner sc = new Scanner(System.in);
                auswahlRechnungen = sc.nextInt();
                if (auswahlRechnungen == 1) {
                    levelEins.levelEinsAddieren(zufallsZahlenNormal);
                    user.updateUser(userData[0], userData[1]);
                } else if (auswahlRechnungen == 2) {
                    levelZwei.levelZweiSubdrahieren(zufallsZahlenNormal);
                    user.updateUser(userData[0], userData[1]);
                } else if (auswahlRechnungen == 3) {
                    levelDrei.levelDreiMultiplizieren();
                    user.updateUser(userData[0], userData[1]);
                } else if (auswahlRechnungen == 4) {
                    levelVier.levelVierDividieren();
                    user.updateUser(userData[0], userData[1]);
                }
            }
            //Überprüfung, ob das Zusatzlevel freigeschalten wurde!
            if(levelEins.methodeIstTrue() && levelZwei.methodeIstTrue() && levelDrei.methodeIstTrue() && levelVier.methodeIstTrue()){
            if(auswahlRechnungen==5){
                //Wenn freigeschlaten und die Auswahl wurde getätigt, wird das Level gestartet
                zusatzLevel.levelZusatz(zufallsZahlenZusatz);
            }
        }else if(auswahlRechnungen==5){
                //Wenn das Level ausgewählt wird, obwohl es nicht freigeschalten wurde, wird ein Fehler ausgegeben!
                System.out.println("Das Zusatzlevel wurde noch nicht Freigeschalten!");
            }



        }

    }
}
