package at.htl.wels;

public class LevelEins {

    //Level 1: Addieren 0-50
    private static boolean levelGeschafft = false;
    private static int maxRechnungen=20;
    Rechnungen rechnen=new Rechnungen();

    public void levelEinsAddieren(int[] zahlen){
        levelGeschafft = rechnen.adieren(zahlen,maxRechnungen);
        if(levelGeschafft) {
            System.out.println("\nDas Level wurde erfolgreich beendet! Gut gemacht");
        } else
            System.out.println("\nLeider nicht geschafft! Viel Erfolg beim nächsten Mal!");
    }

    public boolean methodeIstTrue(){
        return levelGeschafft;
    }

}
