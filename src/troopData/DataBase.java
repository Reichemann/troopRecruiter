package troopData;

import java.sql.*;
import java.util.Objects;

public class DataBase {

    private static Connection connection;

    private static final String
            DRIVER = "com.mysql.jdbc.Driver",
            URL = "jdbc:mysql://localhost:3306/trooprecruiterdata",
            USER = "root",
            PASSWORD = "23122410Skill";

    private Connection createLinkToDataBase() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private Connection getConnection() {
        try {
            return createLinkToDataBase();
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }
        return null;
    }

    private String createSelectQuery(String someClass) {
        return "SELECT * FROM " + someClass;
    }

    private ResultSet createResultSet(String someClass) throws SQLException {
        connection = getConnection();
        PreparedStatement selectedData = Objects.requireNonNull(connection).prepareStatement(createSelectQuery(someClass));
        return selectedData.executeQuery();
    }

    public void showDataBaseData(String someID, String someName, String someClass) throws SQLException {
        ResultSet result = createResultSet(someClass);

        while (result.next()) {
            System.out.println(result.getInt(someID) + ". " + result.getString(someName) + ". ");
        }

        result.close();
    }
}