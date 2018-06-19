package at.htl.wels;

import java.util.Scanner;

public class Rechnungen {

    public Rechnungen() {
    }

    Scanner sc = new Scanner(System.in);

    public boolean adieren(int[] zahlen, int maxRechnungen){
        int rechnungen=0;
        int falsch=20;
        boolean returnValue= false;
        while(rechnungen<maxRechnungen){
            int berechnung = 0;
            System.out.println(zahlen[rechnungen]+"+"+zahlen[rechnungen+1]+"=");
            berechnung=sc.nextInt();
            if((zahlen[rechnungen]+zahlen[rechnungen+1])==berechnung){
                System.out.println("\nRICHTIG!");
            }else {
                System.out.println("\nLeider FALSCH versuch es weiter!");
                falsch--;
            }
            rechnungen++;
        }

        if(falsch>18)
            returnValue=true;

        return returnValue;
    }

    public boolean subtrahieren(int[] zahlen, int maxRechnungen){
        int rechnungen=0;
        int falsch=20;
        boolean returnValue=false;
        while(rechnungen<maxRechnungen){
            int berechnung = 0;
            System.out.println(zahlen[rechnungen]+"-"+zahlen[rechnungen+1]+"=");
            berechnung=sc.nextInt();
            if((zahlen[rechnungen]-zahlen[rechnungen+1])==berechnung){
                System.out.println("\nRICHTIG!");
            }else {
                System.out.println("\nLeider FALSCH versuch es weiter!");
                falsch--;
            }
            rechnungen++;
        }

        if(falsch>18)
            returnValue=true;

        return returnValue;
    }

    public boolean multiplizieren(int maxRechnungen) {
        int rechnungen = 0;
        int falsch = 20;
        boolean returnValue = false;
        int i = 0;
        int lauf = 0;
        int faktor = 1;
        int[] zufallsZahl = new int[maxRechnungen + 1];
        int aufrufZufall = 0;
        int[] zehnerreihe = new int[maxRechnungen + 1];
        int[] neunerreihe = new int[maxRechnungen + 1];
        int[] achterreihe = new int[maxRechnungen + 1];
        int[] siebenerreihe = new int[maxRechnungen + 1];
        int[] sechserreihe = new int[maxRechnungen + 1];
        int[] fuenferreihe = new int[maxRechnungen + 1];
        int[] viererreihe = new int[maxRechnungen + 1];
        int[] dreierreihe = new int[maxRechnungen + 1];
        int[] zweierreihe = new int[maxRechnungen + 1];


        while (i < maxRechnungen) {
            int j = 1;
            if (i != 3) {
                zehnerreihe[i] = faktor;
                neunerreihe[i] = faktor;
                achterreihe[i] = faktor;
                siebenerreihe[i] = faktor;
                sechserreihe[i] = faktor;
                fuenferreihe[i] = faktor;
                viererreihe[i] = faktor;
                dreierreihe[i] = faktor;
                zweierreihe[i] = faktor;
            }

            if (faktor == 10)
                faktor = 1;

            if (i == maxRechnungen) {
                j = 3;
            }
            i++;
            faktor++;
        }

        while (aufrufZufall < maxRechnungen) {
            zufallsZahl[aufrufZufall] = (int) (Math.random() * 9) + 1;
            aufrufZufall++;
        }


        while (lauf < maxRechnungen) {

            if (zufallsZahl[lauf] == 9) {
                int berechnung = 0;
                System.out.println(zehnerreihe[lauf] + " * 10 =");
                berechnung = sc.nextInt();
                if ((zehnerreihe[lauf] * 10 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }

            }
            if (zufallsZahl[lauf] == 8) {
                int berechnung = 0;
                System.out.println(neunerreihe[lauf] + " * 9 =");
                berechnung = sc.nextInt();
                if ((neunerreihe[lauf] * 9 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }

            }
            if (zufallsZahl[lauf] == 7) {
                int berechnung = 0;
                System.out.println(achterreihe[lauf] + " * 8 =");
                berechnung = sc.nextInt();
                if ((achterreihe[lauf] * 8 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }
            }
            if (zufallsZahl[lauf] == 6) {
                int berechnung = 0;
                System.out.println(siebenerreihe[lauf] + " * 7 =");
                berechnung = sc.nextInt();
                if ((siebenerreihe[lauf] * 7 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }
            }
            if (zufallsZahl[lauf] == 5) {
                int berechnung = 0;
                System.out.println(sechserreihe[lauf] + " * 6 =");
                berechnung = sc.nextInt();
                if ((sechserreihe[lauf] * 6 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }
            }
            if (zufallsZahl[lauf] == 4) {
                int berechnung = 0;
                System.out.println(fuenferreihe[lauf] + " * 5 =");
                berechnung = sc.nextInt();
                if ((fuenferreihe[lauf] * 5 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }
            }
            if (zufallsZahl[lauf] == 3) {
                int berechnung = 0;
                System.out.println(viererreihe[lauf] + " * 4 =");
                berechnung = sc.nextInt();
                if ((viererreihe[lauf] * 4 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }
            }
            if (zufallsZahl[lauf] == 2) {
                int berechnung = 0;
                System.out.println(dreierreihe[lauf] + " * 3 =");
                berechnung = sc.nextInt();
                if ((dreierreihe[lauf] * 3 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }
            }
            if (zufallsZahl[lauf] == 1) {
                int berechnung = 0;
                System.out.println(zweierreihe[lauf] + " * 2 =");
                berechnung = sc.nextInt();
                if ((zweierreihe[lauf] * 2 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }

            }
            lauf++;
        }

        if (falsch > 18)
            returnValue = true;

        return returnValue;
    }

    public boolean dividieren(int maxRechnungen){
        int rechnungen=0;
        int falsch=20;
        boolean returnValue=false;
        int i=0;
        int lauf=0;
        int faktor=1;
        int[] zufallsZahl=new int[maxRechnungen+1];
        int aufrufZufall=0;
        int [] zehnerreihe=new int[maxRechnungen+1];
        int [] neunerreihe=new int[maxRechnungen+1];
        int [] achterreihe=new int[maxRechnungen+1];
        int [] siebenerreihe=new int[maxRechnungen+1];
        int [] sechserreihe=new int[maxRechnungen+1];
        int [] fuenferreihe=new int[maxRechnungen+1];
        int [] viererreihe=new int[maxRechnungen+1];
        int [] dreierreihe=new int[maxRechnungen+1];
        int [] zweierreihe=new int[maxRechnungen+1];


        while(i<maxRechnungen){
            int j=1;
            if(i!=3) {
                zehnerreihe[i] = faktor * 10;
                neunerreihe[i] = faktor * 9;
                achterreihe[i] = faktor * 8;
                siebenerreihe[i]=faktor*7;
                sechserreihe[i] = faktor*6;
                fuenferreihe[i]= faktor*5;
                viererreihe[i]=faktor*4;
                dreierreihe[i]=faktor*3;
                zweierreihe[i]=faktor*2;
            }

            if(faktor==10)
                faktor=1;

            if(i==maxRechnungen){
                j=3;
            }
            i++;
            faktor++;
        }

        while(aufrufZufall<maxRechnungen) {
            zufallsZahl[aufrufZufall] = (int) (Math.random() * 9) + 1;
            aufrufZufall++;
        }



        while(lauf<maxRechnungen) {

            if (zufallsZahl[lauf] == 9) {
                int berechnung = 0;
                System.out.println(zehnerreihe[lauf] + " : 10 =");
                berechnung = sc.nextInt();
                if ((zehnerreihe[lauf] / 10 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }

            }
            if (zufallsZahl[lauf] == 8) {
                int berechnung = 0;
                System.out.println(neunerreihe[lauf] + " : 9 =");
                berechnung = sc.nextInt();
                if ((neunerreihe[lauf] / 9 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }

            }
            if (zufallsZahl[lauf] == 7) {
                int berechnung = 0;
                System.out.println(achterreihe[lauf] + " : 8 =");
                berechnung = sc.nextInt();
                if ((achterreihe[lauf] / 8 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }
            }
            if (zufallsZahl[lauf] == 6) {
                int berechnung = 0;
                System.out.println(siebenerreihe[lauf] + " : 7 =");
                berechnung = sc.nextInt();
                if ((siebenerreihe[lauf] / 7 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }
            }
            if (zufallsZahl[lauf] == 5) {
                int berechnung = 0;
                System.out.println(sechserreihe[lauf] + " : 6 =");
                berechnung = sc.nextInt();
                if ((sechserreihe[lauf] / 6 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }
            }
            if (zufallsZahl[lauf] == 4) {
                int berechnung = 0;
                System.out.println(fuenferreihe[lauf] + " : 5 =");
                berechnung = sc.nextInt();
                if ((fuenferreihe[lauf] / 5 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }
            }
            if (zufallsZahl[lauf] == 3) {
                int berechnung = 0;
                System.out.println(viererreihe[lauf] + " : 4 =");
                berechnung = sc.nextInt();
                if ((viererreihe[lauf] / 4 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }
            }
            if (zufallsZahl[lauf] == 2) {
                int berechnung = 0;
                System.out.println(dreierreihe[lauf] + " : 3 =");
                berechnung = sc.nextInt();
                if ((dreierreihe[lauf] / 3 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }
            }
            if (zufallsZahl[lauf] == 1) {
                int berechnung = 0;
                System.out.println(zweierreihe[lauf] + " : 2 =");
                berechnung = sc.nextInt();
                if ((zweierreihe[lauf] / 2 == berechnung)) {
                    System.out.println("\nRICHTIG!");
                } else {
                    System.out.println("\nLeider Falsch!!");
                    falsch--;
                }

            }
            lauf++;
        }

        if(falsch>18)
            returnValue=true;

        return returnValue;
    }


}
