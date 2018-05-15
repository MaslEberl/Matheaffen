package at.htl.wels;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable{
    private String username;
    private String passwort;
    private boolean levelEins;
    private boolean levelZwei;
    private boolean levelDrei;
    private boolean levelVier;

    private ArrayList<User> userData = new ArrayList<>();


    public User(String username, String passwort, boolean levelEins, boolean levelZwei, boolean levelDrei, boolean levelVier) {
        this.username = username;
        this.passwort = passwort;
        this.levelEins = levelEins;
        this.levelZwei = levelZwei;
        this.levelDrei = levelDrei;
        this.levelVier = levelVier;
    }


    //anlegen eines neuen Benutzers
    public void addUser() throws IOException {
        String username;
        String passwort;
        String[] userDataTemp= new String[2];

        System.out.println("Neuen Benutzer anlegen!\n");
        //Username und Passwort mit Hilfe der Methode userLoginData
        userDataTemp=userLoginData();
        username=userDataTemp[0];
        passwort=userDataTemp[1];
        userData.add(new User(username,passwort,false,false,false,false));

        save(userData);
    }

    public void searchUser() throws IOException {
        userData=load();
        String usernameSearch;
        String passwortSearch;
        String[] userDataTemp= new String[2];
        boolean userLogin=true;
        String[] usernamePasswordArray = new String[100];
        int username=0;
        int password = 1;
        int loginVersuch=0;
        int loginVersuchFehler=0;

        //Solange keine 3 Versuche getätigt wurden und der Userlogin nicht erfolgreich war, wird ein neuer Versuch gestartet
        while(loginVersuch<3&&userLogin) {
            //Username und Passwort mit Hilfe der Methode userLoginData
            loginVersuchFehler=0;
            userDataTemp = userLoginData();
            usernameSearch = userDataTemp[0];
            passwortSearch = userDataTemp[1];

            //Die bereits vorhandenen User werden aus der CSV gelesen und nur der Username und das Passwort wird zurückgegeben,
            //um den Login zu ermöglichen!
            usernamePasswordArray = loadUsernamePasswordFromCSV();


            //es wird das usernamePasswordArray durchlaufen, da dort nur Username und Passwort drinen stehen
            while (userLogin &&loginVersuchFehler==0) {
                //wenn der Username oder das Passwort nicht in dem usernamePasswordArray vorkommt, wird ein loginVersuchFehler protokolliert
                if (!(((usernamePasswordArray[username]).equals(usernameSearch)) && ((usernamePasswordArray[password]).equals(passwortSearch)))){
                    //wenn alles falsch ist, exestiert der User nicht, bzw ist das Passwort ODER der Username falsch
                    System.out.println("Username oder Passwort ist falsch!\n");
                    loginVersuchFehler=1;
                }
                //wenn Username und Passwort übereinstimmen, wird die Schleife mit "userLogin=false" abgebrochen
                else if (((usernamePasswordArray[username]).compareTo(usernameSearch) == 0) && ((usernamePasswordArray[password]).compareTo(passwortSearch) == 0)) {
                    System.out.println("LOGIN!\n");
                    userLogin = false;
                    loginVersuch =3;
                } else if (usernamePasswordArray[username] != null && loginVersuch<3 && loginVersuchFehler!=1) {
                    //wenn  das Array zuende ist, keine 3 Loginversuche getätigt wurden und kein Loginfehler protokolliert wurde,
                    //wird der nächste User mit "username=username+2 & password=password+2" ermittelt
                    username = username + 2;
                    password = password + 2;
                }
            }
            loginVersuch++;
        }

        if(loginVersuch==3){
            addUser();
        }
    }


    public static String[] userLoginData(){
        String usernameSearch;
        String passwortSearch;
        Scanner sc = new Scanner(System.in);
        String[] s = new String[2];

        //Username und Passwort müssen eigegeben werden
        System.out.println("Username: ");
        usernameSearch = sc.next();
        System.out.println("\nPasswort: ");
        passwortSearch = sc.next();

        //Array zum übergeben wird befüllt
        s[0]=usernameSearch;
        s[1]=passwortSearch;

        return s;
    }

    private static String[] loadUsernamePasswordFromCSV(){
        String[] s = new String[100];
        String[] usernamePasswordArray = new String[100];
        int username=0;
        int password=1;
        String line;

        //CSV wird Zeile für Zeile eingelesen und bei ";" getrennt
        try (BufferedReader reader = new BufferedReader(new FileReader("UserData.csv"))) {
            while ((line = reader.readLine()) != null) {
                s = line.split(";");
                //Das Array, mit den Usernames bzw Passwörtern wird befüllt
                usernamePasswordArray[username]=s[0];
                usernamePasswordArray[password]=s[1];

                //Die Laufvariablen "username" und "passwort" werden jeweils um 2 erhöht,
                //da, das Array nich überschrieben werden sollen und somit alles Usernames bzw Passwörter
                //aus der CSV in ein einziges Array gespeichert werden
                username=username+2;
                password=password+2;
            }
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }

        return usernamePasswordArray;
    }

    private static void save(ArrayList<User> users) {
        //Arraylist mit den Usern wird in eine CSV gespeichert
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("UserData.csv"));
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
        String fileContent = "";
        for (User u : users) {
            fileContent = fileContent + u.toString() + "\n";
        }
        try {
            writer.write(fileContent);
            writer.close();
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }

    private static ArrayList<User> load() {
        String[] s = new String[100];
        String line;
        ArrayList<User> tempList=new ArrayList<>();

        //die Arraylist wird aus der UserData.csv eingelesen um so bei jedem Start die jeden User wieder abzuspeichern und nicht
        //nur den letzten User wie am Anfang
        try (BufferedReader reader = new BufferedReader(new FileReader("UserData.csv"))){

            while((line=reader.readLine())!=null) {

                s = line.split(";");
                tempList.add(new User(s[0], s[1], Boolean.valueOf(s[2]), Boolean.valueOf(s[3]), Boolean.valueOf(s[4]), Boolean.valueOf(s[5])));
            }

        } catch (IOException ex) {
            System.err.println(ex.toString());
        }

        return tempList;
    }


    //Getter / Setter der Variablen
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public boolean isLevelEins() {
        return levelEins;
    }

    public void setLevelEins(boolean levelEins) {
        this.levelEins = levelEins;
    }

    public boolean isLevelZwei() {
        return levelZwei;
    }

    public void setLevelZwei(boolean levelZwei) {
        this.levelZwei = levelZwei;
    }

    public boolean isLevelDrei() {
        return levelDrei;
    }

    public void setLevelDrei(boolean levelDrei) {
        this.levelDrei = levelDrei;
    }

    public boolean isLevelVier() {
        return levelVier;
    }

    public void setLevelVier(boolean levelVier) {
        this.levelVier = levelVier;
    }

    @Override
    public String toString() {
        return username+";"+ passwort +";"+levelEins+";"+ levelZwei +";" + levelDrei + ";" + levelVier;
    }
}
