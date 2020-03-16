package troopData;

import java.sql.*;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;

public class DataBase {

    private static Map<Integer, String> dataMap = new HashMap<>();

    public void showDataBaseData(String someID, String someName, String someClass) throws SQLException {
        ResultSet result = createResultSet(someClass);

        while(result.next()) {
            System.out.println(result.getInt(someID) + ". " + result.getString(someName) + ". ");
            dataMap.put(result.getInt(someID), result.getString(someName));
        }

        result.close();
    }

    public Map<Integer, String> getDataMap() {
        return dataMap;
    }

    private static final String
            DRIVER = "com.mysql.jdbc.Driver",
            URL = "jdbc:mysql://localhost:3306/trooprecruiterdata",
            USER = "root",
            PASSWORD = "toor";

    private Connection createLinkToDataBase() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        return createLinkToDataBase();
    }

    private String createSelectQuery(String someClass) {
        return "SELECT * FROM " + someClass;
    }

    private ResultSet createResultSet(String someClass) throws SQLException {
        Connection connection;
        connection = getConnection();
        PreparedStatement selectedData = Objects.requireNonNull(connection).prepareStatement(createSelectQuery(someClass + "s"));
        return selectedData.executeQuery();
    }
}
