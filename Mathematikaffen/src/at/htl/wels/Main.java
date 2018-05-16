package at.htl.wels;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{

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

        int auswahlUser;
        User user = new User("Max","Mustermann",false,false,false,false);

        System.out.println("Neues Spiel beginnen: 1\nSpiel fortsetzen: 2");
        Scanner sc2 = new Scanner(System.in);
        auswahlUser=sc2.nextInt();

        if(auswahlUser==1) {

            userData=user.addUser();

        }else if(auswahlUser==2){
            userData = user.searchUser();
            while(userData[2].compareTo("false")==0) {
                if(loginVersuch==3){
                    System.out.println("Loginversuch "+loginVersuch+"/3\n");
                    userData=user.addUser();
                    userData[2]="true";
                }else {
                    System.out.println("Loginversuch "+loginVersuch+"/3\n");
                    userData = user.searchUser();

                }
                loginVersuch++;
            }
        }

       // if(levelEins.methodeIstTrue() && levelZwei.methodeIstTrue() && levelDrei.methodeIstTrue() && levelVier.methodeIstTrue()){
        while (zusatz < maxRechnungenZusatz) {
            zufallsZahlenZusatz[zusatz] = (int) (Math.random() * maxZahlenbereichZusatz) + 1;
            zusatz++;
        }
        //}else {
        while(normal<maxRechnungenNormal) {
            zufallsZahlenNormal[normal] = (int) (Math.random() * maxZahlenbereichNormal) + 1;
            normal++;
        }

        //}

        if(normal==40){
            normal = 0;
        }
        if(zusatz==60){
            zusatz=0;
        }

        if(userData[2].compareTo("true")==0) {
            int auswahl = 0;
            while (auswahl != 5) {
                System.out.println("Auswahl der Level:");
                System.out.println("1 für addieren\n2 für subtrahieren\n3 für multiplizieren\n4 für dividieren\n5 um das Programm zu beenden\nIhre Auswahl:");
                Scanner sc = new Scanner(System.in);
                auswahl = sc.nextInt();
                if (auswahl == 1) {
                    levelEins.levelEinsAddieren(zufallsZahlenNormal);
                    user.updateUser(userData[0], userData[1]);
                } else if (auswahl == 2) {
                    levelZwei.levelZweiSubdrahieren(zufallsZahlenNormal);
                    user.updateUser(userData[0], userData[1]);
                } else if (auswahl == 3) {
                    levelDrei.levelDreiMultiplizieren();
                    user.updateUser(userData[0], userData[1]);
                } else if (auswahl == 4) {
                    levelVier.levelVierDividieren();
                    user.updateUser(userData[0], userData[1]);
                }
            }

        /*if(levelEins.methodeIstTrue() && levelZwei.methodeIstTrue() && levelDrei.methodeIstTrue() && levelVier.methodeIstTrue()){
            if(auswahl==5){
                zusatzLevel.
            }
        }*/

        }

    }
}
