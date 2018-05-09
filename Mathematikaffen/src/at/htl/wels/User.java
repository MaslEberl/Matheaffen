package at.htl.wels;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class User implements Serializable{
    private String username;
    private String passwort;
    boolean levelEins;
    boolean levelZwei;
    boolean levelDrei;
    boolean levelVier;
    private ArrayList<User> userData = new ArrayList<>();


    public User(String username, String passwort, boolean levelEins, boolean levelZwei, boolean levelDrei, boolean levelVier) {
        this.username = username;
        this.passwort = passwort;
        this.levelEins = levelEins;
        this.levelZwei = levelZwei;
        this.levelDrei = levelDrei;
        this.levelVier = levelVier;
    }

    public User(String username, String passwort) {
        this.username = username;
        this.passwort = passwort;
    }


    public void addUser() throws IOException {
        String username;
        String passwort;
        Scanner addUserScanner = new Scanner(System.in);
        System.out.println("Neuen Benutzer anlegen!\n\nUsername:");
        username = addUserScanner.next();
        System.out.println("\nPasswort: ");
        passwort = addUserScanner.next();

        userData.add(new User(username,passwort,false,false,false,false));

        save(userData);
    }

    public void searchUser(){
        userData=load();
        String usernameSearch;
        String passwortSearch;
        Scanner sc = new Scanner(System.in);

        System.out.println("Username: ");
        usernameSearch=sc.next();
        System.out.println("\nPasswort: ");
        passwortSearch=sc.next();

        userData.contains(new User(usernameSearch,passwortSearch));
    }

    private static void save(ArrayList<User> users) {
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

    @Override
    public String toString() {
        return username+";"+ passwort +";"+levelEins+";"+ levelZwei +";" + levelDrei + ";" + levelVier;
    }
}
