package com.company;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Magda
 */
public class DatabaseConnection {

    public static void insertData(String data[]) throws SQLException, ClassNotFoundException {

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " | ");
        }
        System.out.println("\n");

        try {

            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/mgr";
            Class.forName(myDriver);
            // the mysql insert statement
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            // the mysql insert statement
            String query = " insert into test_result (`ID`, `test_id`, `result`, `test_time`, `date`, `last_step`)  values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, null);
            preparedStmt.setString(2, data[0]);
            preparedStmt.setString(3, data[1]);
            preparedStmt.setString(4, data[2]);
            preparedStmt.setString(5, data[3]);
            preparedStmt.setString(6, data[4]);

            // execute the preparedstatement
            preparedStmt.execute();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
