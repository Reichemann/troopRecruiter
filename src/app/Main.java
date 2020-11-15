package app;

import java.util.*;
import java.sql.*;

import app.model.*;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    private static final List<String> castleNameDataList = new ArrayList<>();
    private static final List<String> troopTypeDataList = new ArrayList<>();

    private static final List<Integer> troopNumberDataList = new ArrayList<>();

    private static final Database dataBase = new Database();

    private static final Castle castle = new Castle();

    private static final Troop troop = new Troop();

    private static int userChoice;

    public static void main(String[] args) {
        printMessage("Welcome to troop recruiter app!", true);
        printMainData();
    }

    private static void printMainData() {

        boolean flag = true;

        while (flag) {

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

    private static void getTroopData() {
        tuneItemData(castle, castleNameDataList);
        tuneItemData(troop, troopTypeDataList);
        setNumberOfTroop();
        printMessage("Done!", true);
    }

    private static void tuneItemData(Item item, List someList) {
        printData(item.IDToString(), item.nameToString(), item.toString());
        printMessage("Choose a " + item.toString() + ": ", false);
        enterSomeIntegerValue();
        dataBase.getDataMap().keySet().stream().filter(i -> i == userChoice).forEach(j -> someList.add(dataBase.getDataMap().get(j)));
    }

    private static void setNumberOfTroop() {
        printMessage("Enter the number of troops hired: ", false);
        enterSomeIntegerValue();
        troopNumberDataList.add(userChoice);
    }

    private static void printTroopData() {

        Iterator<String> castleNameIterator = castleNameDataList.iterator();
        Iterator<String> troopTypeIterator = troopTypeDataList.iterator();
        Iterator<Integer> troopNumberIterator = troopNumberDataList.iterator();

        while (castleNameIterator.hasNext() && troopTypeIterator.hasNext() && troopNumberIterator.hasNext())
            printMessage(castleNameIterator.next() + "   " + troopTypeIterator.next() + "   " + troopNumberIterator.next(), true);
    }

    private static void printData(String ID, String name, String someClass) {
        try {
            dataBase.showDataBaseData(ID, name, someClass);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void enterSomeIntegerValue() {
        try {
            userChoice = in.nextInt();
        } catch (InputMismatchException exception) {
            printMessage("Mismatch! Restart the program!", false);
        }
    }

    private static void printMessage(String text, boolean withTransition) {

        if (withTransition)
            System.out.println(text);
        else
            System.out.print(text);
    }
}