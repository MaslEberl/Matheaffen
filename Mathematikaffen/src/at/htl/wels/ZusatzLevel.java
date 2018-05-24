package at.htl.wels;

public class ZusatzLevel {
    //Level Zusatzlevel: addieren/subdrahieren/multipizieren/dividieren 1-100
    public static int maxRechnungen = 30;
    public int maxLevel=4;
    public static int [] rechenfolge= new int[4];

    Rechnungen rechnen=new Rechnungen();

    public void levelZusatz(int[] zahlen){
        for(int i=0;i<maxLevel;i++) {
            rechenfolge[i] = (int) (Math.random() * maxLevel) + 1;
        }

        for(int rechnungen=0;rechnungen<maxLevel;rechnungen++){
            if(rechenfolge[rechnungen]==0){
                rechnen.adieren(zahlen,maxRechnungen);
            }else if(rechenfolge[rechnungen]==1){
                rechnen.subtrahieren(zahlen,maxRechnungen);
            }else if(rechenfolge[rechnungen]==2){
                rechnen.multiplizieren(maxRechnungen);
            }else if(rechenfolge[rechnungen]==3){
                rechnen.dividieren(maxRechnungen);
            }else{
                System.out.println("Fehler 666!");
            }
        }
    }
}
