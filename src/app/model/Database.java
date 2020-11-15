package app.model;

import java.util.*;
import java.sql.*;

public class Database {

    private static final String
            DRIVER = "com.mysql.jdbc.Driver",
            URL = "jdbc:mysql://localhost:3306/troop_recruiter",
            USER = "root",
            PASSWORD = "password";

    private static final Map<Integer, String> dataMap = new HashMap<>();

    public void showDataBaseData(String someID, String someName, String someClass) throws SQLException {

        ResultSet result = createResultSet(someClass);

        while (result.next()) {
            System.out.println(result.getInt(someID) + ". " + result.getString(someName) + ". ");
            dataMap.put(result.getInt(someID), result.getString(someName));
        }

        result.close();
    }

    public Map<Integer, String> getDataMap() {
        return dataMap;
    }

    private Connection createLinkToDataBase() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private ResultSet createResultSet(String someClass) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement selectedData = Objects.requireNonNull(connection).prepareStatement(createSelectQuery(someClass + "s"));
        return selectedData.executeQuery();
    }

    private Connection getConnection() {
        try {
            return createLinkToDataBase();
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
            return null;
        }
    }

    private String createSelectQuery(String someClass) {
        return "SELECT * FROM " + someClass;
    }
}