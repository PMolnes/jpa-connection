package ntnu.appdev.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class JDBCLogic {
    static Connection con = null;

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

    public static void main(String[] args) {
        connect();
    }
}
