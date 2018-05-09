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

            user.addUser();

        }else if(auswahlUser==2){

            user.searchUser();
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

        System.out.println("Auswahl der Level:");
        Scanner sc = new Scanner(System.in);
        int auswahl = sc.nextInt();
        if(auswahl==1){
            levelEins.levelEinsAddieren(zufallsZahlenNormal);
        }else if(auswahl==2){
            levelZwei.levelZweiSubdrahieren(zufallsZahlenNormal);
        }else if(auswahl==3) {
            levelDrei.levelDreiMultiplizieren(zufallsZahlenNormal);
        }else if(auswahl==4){
            levelVier.levelVierDividieren();
        }

        /*if(levelEins.methodeIstTrue() && levelZwei.methodeIstTrue() && levelDrei.methodeIstTrue() && levelVier.methodeIstTrue()){
            if(auswahl==5){
                zusatzLevel.
            }
        }*/



    }
}
