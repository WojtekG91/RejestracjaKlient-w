package com.company.SQL;

import java.sql.*;

public class InsertSQL {
    public static void registrationStatement(String name, String surname, String mail, String phone, String password) {

        Connection dbConnect = null;
        PreparedStatement preparedStatement = null;

        String sqlInsert = "INSERT INTO `tclients`(`Name`, `Surname`, `Mail`, `Phone`, `Password`)" + "VALUES (?, ?, ?, ?, ?);";

        try {
            dbConnect = SqlConnection.Connect();
            preparedStatement = dbConnect.prepareStatement(sqlInsert);
//            preparedStatement.setInt(1, clientID);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, mail);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, password);
            preparedStatement.executeUpdate();
            preparedStatement.clearParameters();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}