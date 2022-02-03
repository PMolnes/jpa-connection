package ntnu.appdev.jdbcconnection;

import java.sql.*;

public class JDBCLogic {
    private static Connection con = connect();

    public static Connection connect() {

        //getting the JDBC sql lite driver
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //path for database and connection
        try {
            con = DriverManager.getConnection("jdbc:sqlite:empty_db.db");
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public ResultSet showAllProjects() {
        PreparedStatement prepared;
        ResultSet result = null;
        try {
            String sql = "SELECT * FROM Project";
            prepared = con.prepareStatement(sql);
            result = prepared.executeQuery();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
