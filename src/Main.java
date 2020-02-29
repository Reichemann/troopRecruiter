import java.util.*;
import java.sql.*;
import troopData.DataBase;
import troopData.Castle;
import troopData.Troop;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static List<String> castleNameDataList = new ArrayList<>();
    private static List<String> troopTypeDataList = new ArrayList<>();
    private static List<Integer> troopNumberDataList = new ArrayList<>();
    private static DataBase dataBase = new DataBase();
    private static Castle castle = new Castle();
    private static Troop troop = new Troop();
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
                    printTroopData();
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
        printData(castle.IDToString(), castle.nameToString(), castle.classNameToString());
        printMessage("Choose a castle: ", true);
        enterSomeIntegerValue();
        dataBase.getDataMap().keySet().stream().filter(i -> i == userChoice).forEach(j -> castleNameDataList.add(dataBase.getDataMap().get(j)));
        dataBase.getDataMap().clear();
        printData(troop.IDToString(), troop.nameToString(), troop.classNameToString());
        printMessage("Select type of warrior: ", true);
        enterSomeIntegerValue();
        dataBase.getDataMap().keySet().stream().filter(i -> i == userChoice).forEach(j -> troopTypeDataList.add(dataBase.getDataMap().get(j)));
        dataBase.getDataMap().clear();
        printMessage("Enter the number of troops hired: ", false);
        enterSomeIntegerValue();
        troopNumberDataList.add(userChoice);
        printMessage("Done!", true);
    }

    public static void printTroopData() {
        Iterator<String> castleNameIterator = castleNameDataList.iterator();
        Iterator<String> troopTypeIterator = troopTypeDataList.iterator();
        Iterator<Integer> troopNumberIterator = troopNumberDataList.iterator();

        while(castleNameIterator.hasNext() && troopTypeIterator.hasNext() && troopNumberIterator.hasNext()) {
            printMessage(castleNameIterator.next() + "   " + troopTypeIterator.next() + "   " + troopNumberIterator.next(), true);
        }
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