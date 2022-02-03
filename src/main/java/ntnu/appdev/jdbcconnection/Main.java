package ntnu.appdev.jdbcconnection;

import java.sql.*;
import java.time.LocalDate;

public class Main {
    private static Connection con;
    
    public static void main(String[] args) {
        con = JDBCLogic.connect();
        updateProjectDeadline(1000, "2025-12-31");
        getPlansWithLeastCost();
    }

    private static void updateProjectDeadline(int projectID, String endDate) {
        PreparedStatement prepared = null;
        try {
            String sql = "UPDATE Project SET endDate = ? WHERE projectID = ?";
            prepared = con.prepareStatement(sql);
            prepared.setObject(1, LocalDate.parse(endDate));
            prepared.setInt(2, projectID);
            prepared.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ResultSet getPlansWithLeastCost() {
        PreparedStatement prepared;
        ResultSet result = null;
        try {
            prepared = con.prepareStatement("SELECT Project.name AS 'Project', Plan.name AS 'Plan', MIN(planCost.totalCost) AS 'Cost' FROM Plan, " +
                    "(SELECT PlanEmployee.pID, SUM(Employee.cost) AS totalCost FROM PlanEmployee" +
                    " INNER JOIN Employee ON PlanEmployee.eID = Employee.eID" +
                    " GROUP BY PlanEmployee.pID) AS planCost" +
                    " INNER JOIN Project ON Plan.projectID = Project.projectID " +
                    " WHERE Plan.pID = planCost.pID" +
                    " GROUP BY Project.projectID" +
                    " ORDER BY Plan.name");
            result = prepared.executeQuery();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("failed");
        return result;
    }

    private static void addEmployee(String eID, String name, String cost) {
        Connection con = JDBCLogic.connect();
        PreparedStatement prepared;
        try {
            String sql = "INSERT INTO Employee(eID, name, cost) VALUES(?,?,?)";
            prepared = con.prepareStatement(sql);
            prepared.setString(1, eID);
            prepared.setString(2, name);
            prepared.setString(3, cost);
            prepared.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
