package at.htl.wels;

import java.util.Scanner;

public class Rechnungen {

    public Rechnungen() {
    }


    Scanner sc = new Scanner(System.in);


    public boolean adieren(int[] zahlen, int maxRechnungen){
        int rechnungen=0;
        int richtig=0;
        int falsch=0;
        boolean returnValue= false;
        while(rechnungen<maxRechnungen){
            int berechnung = 0;
            System.out.println(zahlen[rechnungen]+"+"+zahlen[rechnungen+1]+"=");
            berechnung=sc.nextInt();
            if((zahlen[rechnungen]+zahlen[rechnungen+1])==berechnung){
                System.out.println("\nRICHTIG!");
                richtig++;
            }else {
                System.out.println("\nLeider FALSCH versuch es weiter!");
                falsch++;
            }
            rechnungen++;
        }

        if(((richtig*100)-(falsch*100))<15)
            returnValue=true;

        return returnValue;
    }

    public boolean subtrahieren(int[] zahlen, int maxRechnungen){
        int rechnungen=0;
        int richtig=0;
        int falsch=0;
        boolean returnValue=false;
        while(rechnungen<maxRechnungen){
            int berechnung = 0;
            System.out.println(zahlen[rechnungen]+"-"+zahlen[rechnungen+1]+"=");
            berechnung=sc.nextInt();
            if((zahlen[rechnungen]-zahlen[rechnungen+1])==berechnung){
                System.out.println("\nRICHTIG!");
                richtig++;
            }else {
                System.out.println("\nLeider FALSCH versuch es weiter!");
                falsch++;
            }
            rechnungen++;
        }

        if(((richtig*100)-(falsch*100))<15)
            returnValue=true;

        return returnValue;
    }

    public boolean multiplizieren(int[] zahlen, int maxRechnungen){
        int rechnungen=0;
        int richtig=0;
        int falsch=0;
        boolean returnValue=false;
        while(rechnungen<maxRechnungen){
            int berechnung = 0;
            System.out.println(zahlen[rechnungen]+" * "+zahlen[rechnungen+1]+"=");
            berechnung=sc.nextInt();
            if((zahlen[rechnungen]*zahlen[rechnungen+1])==berechnung){
                System.out.println("\nRICHTIG!");
                richtig++;
            }else {
                System.out.println("\nLeider FALSCH versuch es weiter!");
                falsch++;
            }
            rechnungen++;
        }

        if(((richtig*100)-(falsch*100))<15)
            returnValue=true;

        return returnValue;
    }

    public boolean dividieren(int[] zahlen, int maxRechnungen){
        int rechnungen=0;
        int richtig=0;
        int falsch=0;
        boolean returnValue=false;
        while(rechnungen<maxRechnungen){
            int berechnung = 0;
            if(zahlen[rechnungen+1]==0)
                zahlen[rechnungen]=zahlen[rechnungen]+1;
            System.out.println(zahlen[rechnungen]+" : "+zahlen[rechnungen+1]+"=");
            berechnung=sc.nextInt();
            if((zahlen[rechnungen]/zahlen[rechnungen+1])==berechnung){
                System.out.println("\nRICHTIG!");
                richtig++;
            }else {
                System.out.println("\nLeider FALSCH versuch es weiter!");
                falsch++;
            }
            rechnungen++;
        }

        if(((richtig*100)-(falsch*100))<15)
            returnValue=true;

        return returnValue;
    }
}
