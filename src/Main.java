//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;
import java.sql.*;
import java.util.InputMismatchException;
import troopData.DataBase;
import troopData.Castle;
import troopData.Troop;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static DataBase dataBase = new DataBase();
    private static Castle castle = new Castle();
    private static Troop troop = new Troop();
    //private static List <String> castleList = new ArrayList <String>();
    private static int userChoice;

    public static void main(String[] args) {
        printMessage("Welcome to troop recruiter app!", true);
        printMainData();
    }

    public static void printMainData() {

        boolean flag = true;

        while(flag) {
            printMessage("1. Add troops.", true);
            printMessage("2. Show your army.", true);
            printMessage("3. Exit.", true);

            printMessage("Your choice: ", false);
            enterSomeIntegerValue();

            switch (userChoice) {
                case 1:
                    getTroopData();
                    break;
                case 2:
                    break;
                case 3:
                    printMessage("Good Luck!", true);
                    flag = false;
                    break;
                default:
                    printMessage("Incorrect input! Please, restart the program!", true);
                    break;
            }
        }
    }

    public static void getTroopData() {
        printData(castle.castleIDToString(), castle.castleNameToString(), castle.toString());
        printMessage("Choose a castle: ", true);
        enterSomeIntegerValue();
        printData(troop.troopIDToString(), troop.troopNameToString(), troop.toString());
        printMessage("Select type of warrior: ", true);
        enterSomeIntegerValue();
        printMessage("Enter the number of troops hired: ", false);
        enterSomeIntegerValue();
    }

    public static void printData(String ID, String name, String someClass) {
        try {
            dataBase.showDataBaseData(ID, name, someClass);
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    private static void enterSomeIntegerValue() {
        try {
            userChoice = input.nextInt();
        } catch (InputMismatchException exception) {
            printMessage("Mismatch! Restart the program!", false);
        }
    }

    private static void printMessage(String text, boolean withTransition) {
        if(withTransition)
            System.out.println(text);
        else
            System.out.print(text);
    }
}