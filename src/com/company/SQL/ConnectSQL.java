package com.company.SQL;

import java.sql.*;

public class ConnectSQL {
    private static void connecting() {
        Connection connect = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        // This will load the MySQL driver, each DB has its own driver


        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/project?" + "user=root&password=");
            // Statements allow to issue SQL queries to the database

            String sqlInsert = "INSERT INTO `TCLIENT` (`Name`, `Surname`,`Email`, `Phone`,)" + "VALUES (?, ?, ?, ?);"";
            preparedStatement = connect.prepareStatement(sqlInsert);
            preparedStatement.setInt(1,5);
            preparedStatement.setString(2, "woda");
            preparedStatement.setString(3, "woda");
            preparedStatement.setString(4, "2347923874");
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void registrationStatement (String name, String surname, String mail, String phone, String password){
        Statement statement = null;
        ResultSet resultSet = null;

        String sqlInsert = "INSERT INTO `TCLIENT` (`ID`, `name`, `surname`, `phone`)" + "VALUES (?, ?, ?, ?);";
        resultSet = statement.executeQuery(sqlInsert);
    }

}